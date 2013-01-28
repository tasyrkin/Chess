package de.tasyrkin.chess.domain;

public class Position {

    private int row;
    private int col;

    public Position(int row, int col){
        this.row = row;
        this.col = col;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public int differenceInCells(Position position){
        return Math.abs(row - position.row) + Math.abs(col - position.col);
    }

    @Override
    public String toString(){
        return getRow() + ", " + getCol();
    }
}
