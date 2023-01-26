package TicTacToe.strategy.win;

import TicTacToe.models.Board;
import TicTacToe.models.Move;

public class FalseWinningStrategy implements WinningStrategy{
    @Override
    public boolean checkWin(Board board, Move move) {
        return false;
    }
}
