package de.tasyrkin.chess.domain;

import java.util.List;

public class Pawn extends Figure {

    public Pawn(Position position, Color color) {
        super(position, color);
    }

    @Override
    public boolean isValidMoveTo(Position newPosition) {

        if(position.getCol() != newPosition.getCol()){
            return false;
        }
        if(position.getRow() == newPosition.getRow()){
            return false;
        }

        boolean movingInRightDirection = color == color.BLACK ?
                (position.getRow() < newPosition.getRow()) :
                (position.getRow() > newPosition.getRow());

        if(!movingInRightDirection){
            return false;
        }

        boolean isTwoRowsMoveAllowed = color == color.BLACK ?
                (position.getRow() == 0 || position.getRow() == 1) :
                (position.getRow() == 7 || position.getRow() == 6);

        int rowsDifference = Math.abs(position.getRow() - newPosition.getRow());

        return (isTwoRowsMoveAllowed && rowsDifference <= 2) || rowsDifference == 1;
    }
}
