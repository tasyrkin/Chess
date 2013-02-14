package de.tasyrkin.chess.domain;

import com.google.common.base.Preconditions;

import static com.google.common.base.Preconditions.checkArgument;

/**
 * Represent chess board. Black figures are located at the top of it (rows 0-1),
 * white are at the bottom (rows 6-7).
 */
public class Board {

    public static final int SIZE = 8;

    private Figure[][] positions = new Figure[8][8];

    public Board(){
        setPawns(1, Color.BLACK);

        setPawns(SIZE-2, Color.WHITE);
    }

    public Figure atPosition(Position position){

        checkArgument(isValid(position), "The position [%s] is not valid", position.toString());

        return positions[position.getRow()][position.getRow()];
    }

    private boolean isValid(Position position){

        boolean isValidInRow = position.getRow() >= 0 && position.getRow() < positions[0].length;
        boolean isValidInColumn = position.getCol() >= 0 && position.getCol() < positions.length;

        return isValidInColumn && isValidInRow;
    }

    private void setPawns(int row, Color color) {
        for(int column = 0; column < SIZE; column++){
            positions[1][column] = new Pawn(new Position(row, column), color);
        }
    }
}
