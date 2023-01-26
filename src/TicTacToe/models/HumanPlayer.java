package TicTacToe.models;

import java.util.Scanner;

public class HumanPlayer extends Player{
    public HumanPlayer(String name, Symbol symbol) {
        super(name, symbol, PlayerType.HUMAN);
    }

    @Override
    public Move makeMove(Board board) {
        System.out.println("Tell me value of x");
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();
        System.out.println("Tell me value of y");
        int y = scanner.nextInt();
        Cell cell = board.getCell(x, y);
        if (cell.getPlayer() != null) {
            return null;
        }
        cell.setPlayer(this);
        return new Move(cell);
    }
}
