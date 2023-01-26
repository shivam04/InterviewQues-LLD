package TicTacToe.strategy.win;

import TicTacToe.models.Board;
import TicTacToe.models.Cell;
import TicTacToe.models.Move;

public class RowWinningStrategy implements WinningStrategy{
    @Override
    public boolean checkWin(Board board, Move move) {
        Cell curCell = move.getCell();
        int cRow = curCell.getRow();
        for (int col = 0; col < board.getN(); col++) {
            Cell cell = board.getCell(cRow, col);
            if (cell.getPlayer() != curCell.getPlayer()) {
                return false;
            }
        }
        return true;
    }
}
