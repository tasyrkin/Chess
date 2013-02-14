package de.tasyrkin.chess.domain;

public class Pawn extends Figure {

    public Pawn(Position position, Color color) {
        super(position, color);
    }

    @Override
    public boolean isValidMoveTo(Position newPosition) {

        if(position.getCol() != newPosition.getCol()){
            return false;
        }

        if(!isMovingInRightDirection(newPosition)){
            return false;
        }

        boolean isTwoRowsMoveAllowed = color == Color.BLACK ?
                (position.getRow() == 0 || position.getRow() == 1) :
                (position.getRow() == 7 || position.getRow() == 6);

        int rowsDifference = Math.abs(position.getRow() - newPosition.getRow());

        return (isTwoRowsMoveAllowed && rowsDifference <= 2) || rowsDifference == 1;
    }

    @Override
    public boolean isValidToCutAt(Position newPosition) {

        int rowDifference = Math.abs(position.getRow() - newPosition.getRow());
        if(rowDifference != 1){
            return false;
        }

        int colDifference = Math.abs(position.getCol() - newPosition.getCol());
        if(colDifference != 1){
            return false;
        }

        if(!isMovingInRightDirection(newPosition)){
            return false;
        }
        return false;
    }

    private boolean isMovingInRightDirection(Position newPosition) {
        return color == Color.BLACK ?
                (position.getRow() < newPosition.getRow()) :
                (position.getRow() > newPosition.getRow());
    }

}
