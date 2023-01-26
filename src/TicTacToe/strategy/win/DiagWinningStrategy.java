package TicTacToe.strategy.win;

import TicTacToe.models.Board;
import TicTacToe.models.Cell;
import TicTacToe.models.Move;

public class DiagWinningStrategy implements WinningStrategy{
    @Override
    public boolean checkWin(Board board, Move move) {
        Cell curCell = move.getCell();
        if (curCell.getRow() != curCell.getCol())
            return false;
        for (int i=0; i<board.getN(); i++) {
            Cell cell = board.getCell(i, i);
            if (cell.getPlayer() != curCell.getPlayer())
                return false;
        }
        return true;
    }
}
