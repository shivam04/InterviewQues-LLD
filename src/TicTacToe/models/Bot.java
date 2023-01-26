package TicTacToe.models;

import TicTacToe.strategy.bot.BotMoveStrategy;
import TicTacToe.factory.BotMoveStrategyFactory;

public class Bot extends Player{
    private BotDifficultyLevel difficultyLevel;
    private BotMoveStrategy botMoveStrategy;

    public Bot(String name, Symbol symbol, BotDifficultyLevel difficultyLevel) {
        super(name, symbol, PlayerType.BOT);
        this.difficultyLevel = difficultyLevel;
        this.botMoveStrategy = BotMoveStrategyFactory.getInstance(difficultyLevel);
    }

    public BotDifficultyLevel getDifficultyLevel() {
        return difficultyLevel;
    }

    public void setDifficultyLevel(BotDifficultyLevel difficultyLevel) {
        this.difficultyLevel = difficultyLevel;
    }

    @Override
    public Move makeMove(Board board) {
        return botMoveStrategy.makeMove(board, this);
    }
}
