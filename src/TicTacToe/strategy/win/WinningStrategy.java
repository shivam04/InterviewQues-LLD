package TicTacToe.strategy.win;

import TicTacToe.models.Board;
import TicTacToe.models.Move;

public interface WinningStrategy {
    public boolean checkWin(Board board, Move move);
}
