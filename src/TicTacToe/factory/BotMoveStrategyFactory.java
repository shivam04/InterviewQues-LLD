package TicTacToe.factory;

import TicTacToe.exception.InvalidBotMoveStrategyException;
import TicTacToe.models.BotDifficultyLevel;
import TicTacToe.strategy.bot.BotMoveStrategy;
import TicTacToe.strategy.bot.EasyBotMoveStrategy;
import TicTacToe.strategy.bot.HighBotMoveStrategy;
import TicTacToe.strategy.bot.MedBotMoveStrategy;

public class BotMoveStrategyFactory {
    public static BotMoveStrategy getInstance(BotDifficultyLevel difficultyLevel) {
        switch (difficultyLevel) {
            case EASY:
                return new EasyBotMoveStrategy();
            case MED:
                return new MedBotMoveStrategy();
            case HIGH:
                return new HighBotMoveStrategy();
            default:
                throw new InvalidBotMoveStrategyException("BotMoveStrategy: " + difficultyLevel + " doesn't exist");
        }
    }
}
