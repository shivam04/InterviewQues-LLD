package TicTacToe.factory;

import TicTacToe.models.WinningStrategyType;
import TicTacToe.strategy.win.WinningStrategy;
import TicTacToe.strategy.win.RowWinningStrategy;
import TicTacToe.strategy.win.ColWinningStrategy;
import TicTacToe.strategy.win.DiagWinningStrategy;
import TicTacToe.strategy.win.FalseWinningStrategy;

public class WinningStrategyFactory {
    public static WinningStrategy getInstance(WinningStrategyType winningStrategyType) {
        switch (winningStrategyType) {
            case ROW:
                return new RowWinningStrategy();
            case COL:
                return new ColWinningStrategy();
            case DIAG:
                return new DiagWinningStrategy();
            default:
                return new FalseWinningStrategy();
        }
    }
}
