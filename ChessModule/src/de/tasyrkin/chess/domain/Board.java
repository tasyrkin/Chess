package de.tasyrkin.chess.domain;

public class Board {

    private static int SIZE = 8;

    private Figure[][] positions = new Figure[8][8];

    public Board(){
        setPawns(1, Color.BLACK);

        setPawns(SIZE-2, Color.WHITE);
    }

    public Figure atPosition(Position position){

        if(!isValid(position)){
            throw new IllegalArgumentException("The position [" + position.toString() + "] is not valid");
        }

        return positions[position.getRow()][position.getRow()];
    }

    private boolean isValid(Position position){
        boolean isValidInColumn = position.getCol() >= 0 && position.getCol() < positions.length;
        boolean isValidInRow = position.getRow() >= 0 && position.getRow() < positions[0].length;

        return isValidInColumn && isValidInRow;
    }

    private void setPawns(int row, Color color) {
        for(int column = 0; column < SIZE; column++){
            positions[1][column] = new Pawn(new Position(row, column), color);
        }
    }
}
