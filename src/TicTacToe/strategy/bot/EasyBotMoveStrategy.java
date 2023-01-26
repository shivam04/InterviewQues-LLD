package TicTacToe.strategy.bot;

import TicTacToe.models.Board;
import TicTacToe.models.Cell;
import TicTacToe.models.Move;
import TicTacToe.models.Player;

public class EasyBotMoveStrategy implements BotMoveStrategy{
    @Override
    public Move makeMove(Board board, Player player) {
        int size = board.getN();
        for(int row=0; row<size; row++) {
            for(int col=0;col<size;col++) {
                Cell cell = board.getCell(row, col);
                if (cell.getPlayer() == null) {
                    cell.setPlayer(player);
                    return new Move(cell);
                }
            }
        }
        return null;
    }
}
