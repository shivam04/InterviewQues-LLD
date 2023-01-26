package TicTacToe.strategy.bot;

import TicTacToe.models.Board;
import TicTacToe.models.Move;
import TicTacToe.models.Player;

public interface BotMoveStrategy {
    Move makeMove(Board board, Player player);
}
