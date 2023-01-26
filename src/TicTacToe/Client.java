package TicTacToe;

import TicTacToe.factory.WinningStrategyFactory;
import TicTacToe.models.*;
import TicTacToe.strategy.win.WinningStrategy;

import java.util.Set;
import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class Client {
    private static final Set<GameStatus> VALID_GAME_STATUS = new HashSet<GameStatus>() {
        {
            add(GameStatus.IN_PROGRESS);
            add(GameStatus.NOT_STARTED);
        }
    };

    public static void main(String[] args) {
        System.out.println("!!Game STARTS!!");

        Scanner scanner = new Scanner(System.in);

        System.out.println("What is the size of the Board ?");
        int sizeOfBoard = scanner.nextInt();

        System.out.println("!!Number of Human Player!!");
        int noOfHumanPlayers = scanner.nextInt();

        System.out.println("No of Bots!!");
        int noOfBots = scanner.nextInt();

        List<Player> players = new ArrayList<>();
        for(int i=0;i<noOfBots;i++) {
            System.out.println("Input symbol for bot:" + i);
            String symbol = scanner.next();
            System.out.println("Input Name for bot:" + i);
            String name = scanner.next();
            System.out.println("What is the difficulty level for bot:" + i);
            String difficultyLevel = scanner.next();
            players.add(new Bot(name, new Symbol(symbol.charAt(0)), BotDifficultyLevel.valueOf(difficultyLevel)));
        }

        for(int i=0;i<noOfHumanPlayers;i++) {
            System.out.println("Input symbol for Human:"+i);
            String symbol = scanner.next();
            System.out.println("Input Name for Human:"+i);
            String name = scanner.next();
            players.add(new HumanPlayer(name, new Symbol(symbol.charAt(0))));
        }

        List<WinningStrategy> winningStrategies = new ArrayList<>();
        System.out.println("How Many Winning Strategy we want");
        int noOfWinningStrategy = scanner.nextInt();

        for(int i=0;i<noOfWinningStrategy;i++) {
            System.out.println("Input type for WinningStrategy:"+i);
            String winningStrategyType = scanner.next();
            winningStrategies.add(WinningStrategyFactory.getInstance
                    (WinningStrategyType.valueOf(winningStrategyType)));
        }

        Game myGame = Game.getBuilder()
                .setPlayers(players)
                .setSizeOfTheBoard(sizeOfBoard)
                .setWinningStrategies(winningStrategies)
                .build();
        while (VALID_GAME_STATUS.contains(myGame.getGameStatus())) {
            myGame.play();
        }
    }
}
