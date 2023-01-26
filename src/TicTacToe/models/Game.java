package TicTacToe.models;

import TicTacToe.exception.InvalidBotPlayersException;
import TicTacToe.exception.InvalidCellMoveException;
import TicTacToe.exception.InvalidNumberOfPlayersException;
import TicTacToe.exception.PersonWithDuplicateSymbolException;
import TicTacToe.strategy.win.WinningStrategy;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Game {
    private Board board;
    private List<Player> players;
    private int playerNextMoveIndex;
    private List<WinningStrategy> winningStrategies;
    private List<Move> moves;
    private Player winner;
    private GameStatus gameStatus;
    private int filledCells;

    private Game() {
    }

    private Game(GameBuilder gameBuilder) {
        this.players = gameBuilder.getPlayers();
        this.winningStrategies = gameBuilder.getWinningStrategies();
        this.board = new Board(gameBuilder.sizeOfTheBoard);
        this.gameStatus = GameStatus.NOT_STARTED;
        this.moves = new ArrayList<>();
        this.playerNextMoveIndex = 0;
        this.filledCells = 0;
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public int getPlayerNextMoveIndex() {
        return playerNextMoveIndex;
    }

    public void setPlayerNextMoveIndex(int playerNextMoveIndex) {
        this.playerNextMoveIndex = playerNextMoveIndex;
    }

    public List<WinningStrategy> getWinningStrategies() {
        return winningStrategies;
    }

    public void setWinningStrategies(List<WinningStrategy> winningStrategies) {
        this.winningStrategies = winningStrategies;
    }

    public List<Move> getMoves() {
        return moves;
    }

    public void setMoves(List<Move> moves) {
        this.moves = moves;
    }

    public Player getWinner() {
        return winner;
    }

    public void setWinner(Player winner) {
        this.winner = winner;
    }

    public GameStatus getGameStatus() {
        return gameStatus;
    }

    public void setGameStatus(GameStatus gameStatus) {
        this.gameStatus = gameStatus;
    }

    public static GameBuilder getBuilder() {
        return new GameBuilder();
    }

    public static class GameBuilder {
        private List<Player> players;
        private List<WinningStrategy> winningStrategies;
        private int sizeOfTheBoard;

        public List<Player> getPlayers() {
            return players;
        }

        public GameBuilder setPlayers(List<Player> players) {
            this.players = new ArrayList<>();
            this.players.addAll(players);
            return this;
        }

        public List<WinningStrategy> getWinningStrategies() {
            return winningStrategies;
        }

        public GameBuilder setWinningStrategies(List<WinningStrategy> winningStrategies) {
            this.winningStrategies = winningStrategies;
            return this;
        }

        public int getSizeOfTheBoard() {
            return sizeOfTheBoard;
        }

        public GameBuilder setSizeOfTheBoard(int sizeOfTheBoard) {
            this.sizeOfTheBoard = sizeOfTheBoard;
            return this;
        }

        public Game build() {
            validatePlayersSymbol(players);
            onlyOneOrNoBotPresent();
            noOfPlayerCheck();
            return new Game(this);
        }

        private void noOfPlayerCheck() {
            int numberOfPlayers = players.size();
            if (numberOfPlayers < 2 && numberOfPlayers > sizeOfTheBoard - 1) {
                throw new InvalidNumberOfPlayersException("Invalid Numbers of Players!!");
            }
        }

        private void onlyOneOrNoBotPresent() {
            int countBotPlayers = 0;
            for (Player p: players) {
                if (p instanceof Bot) {
                    countBotPlayers++;
                }
            }
            if (countBotPlayers > 1) {
                throw new InvalidBotPlayersException("Invalid Number of Bot Players!!");
            }
        }

        private void validatePlayersSymbol(List<Player> players) {
            Set<Character> set = new HashSet<>();
            for (Player p: players) {
                if (set.contains(p.getSymbol().getCharSymbol())) {
                    throw new PersonWithDuplicateSymbolException("Invalid Symbols assigned to Players!!");
                }
                set.add(p.getSymbol().getCharSymbol());
            }
            set.clear();
        }
    }

    public void play() {
        board.display();
        gameStatus = GameStatus.IN_PROGRESS;
        Move potentialMove = null;
        try {
            potentialMove = this.players.get(playerNextMoveIndex).makeMove(board);
        } catch (InvalidCellMoveException ignore) {}
        if (potentialMove == null) {
            System.out.println("Wrong Move, Cell already occupied, Please try again!");
            return;
        }
        this.moves.add(potentialMove);
        filledCells++;
        boolean win = false;
        for(WinningStrategy winningStrategy: winningStrategies) {
            win = winningStrategy.checkWin(board, potentialMove);
            if (win) {
                System.out.println("Winner is: " + potentialMove.getCell().getPlayer().getName());
                gameStatus = GameStatus.WIN;
                winner = potentialMove.getCell().getPlayer();
                return;
            }
        }
        playerNextMoveIndex = (playerNextMoveIndex + 1)%(players.size());
        int boardSize = board.getN();
        if (filledCells == boardSize*boardSize) {
            gameStatus = GameStatus.DRAW;
            return;
        }
    }
}
