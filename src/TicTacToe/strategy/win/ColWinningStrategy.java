package TicTacToe.strategy.win;

import TicTacToe.models.Board;
import TicTacToe.models.Cell;
import TicTacToe.models.Move;

public class ColWinningStrategy implements WinningStrategy{
    @Override
    public boolean checkWin(Board board, Move move) {
        Cell curCell = move.getCell();
        int cCol = curCell.getCol();
        for (int row = 0; row < board.getN(); row++) {
            Cell cell = board.getCell(row, cCol);
            if (cell.getPlayer() != curCell.getPlayer()) {
                return false;
            }
        }
        return true;
    }
}
