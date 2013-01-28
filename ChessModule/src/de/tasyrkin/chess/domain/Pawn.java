package de.tasyrkin.chess.domain;

import java.util.List;

public class Pawn extends Figure {

    public Pawn(Position position, Color color) {
        super(position, color);
    }

    @Override
    public boolean isValidMoveTo(Position newPosition) {

        if(position.differenceInCells(newPosition) != 1){
            return false;
        }

        if(color == Color.BLACK){
            if(newPosition.getCol() - position.getCol() == 1){
                return true;
            }
        } else if(color == Color.WHITE){
            if(position.getCol() - newPosition.getCol() == 1){
                return true;
            }
        }

        return false;
    }

    @Override
    public List<Position> getMovePositions() {
        return null;
    }
}
