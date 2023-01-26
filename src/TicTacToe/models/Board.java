package TicTacToe.models;

import TicTacToe.exception.InvalidCellMoveException;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private int n;
    List<List<Cell>> matrix;

    public Board(int n) {
        this.n = n;
        this.matrix = new ArrayList<>();
        for(int i=0;i<n;i++) {
            this.matrix.add(new ArrayList<>());
            for(int j=0;j<n;j++) {
                this.matrix.get(i).add(new Cell(i, j));
            }
        }
    }

    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }

    public List<List<Cell>> getMatrix() {
        return matrix;
    }

    public void setMatrix(List<List<Cell>> matrix) {
        this.matrix = matrix;
    }

    public Cell getCell(int r, int c) {
        validateCell(r, c);
        return matrix.get(r).get(c);
    }

    private void validateCell(int r, int c) {
        if (r < 0 || r > n || c < 0 || c > n) {
            throw new InvalidCellMoveException("Invalid Cell Move Exception");
        }
    }

    public void display() {
        for (int row=0; row<n; row++ ){
            for(int col=0; col<n; col++) {
                Cell cell = getCell(row, col);
                char symbol = cell.getPlayer() == null ? '.' : cell.getPlayer().getSymbol().getCharSymbol();
                System.out.print("|"+ symbol + "| ");
            }
            System.out.println();
        }
    }
}
