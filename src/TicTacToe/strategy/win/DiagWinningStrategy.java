package TicTacToe.strategy.win;

import TicTacToe.models.Board;
import TicTacToe.models.Cell;
import TicTacToe.models.Move;

public class DiagWinningStrategy implements WinningStrategy{
    @Override
    public boolean checkWin(Board board, Move move) {
        Cell curCell = move.getCell();
        boolean win = true;
        for (int i=0; i<board.getN(); i++) {
            Cell cell = board.getCell(i, i);
            if (cell.getPlayer() != curCell.getPlayer()) {
                win = false;
                break;
            }
        }
        if (!win) {
            int col = board.getN()-1;
            for (int row = 0; row < board.getN(); row++, col--) {
                Cell cell = board.getCell(row, col);
                if (cell.getPlayer() != curCell.getPlayer()) {
                    return false;
                }
            }
        }
        return true;
    }
}
