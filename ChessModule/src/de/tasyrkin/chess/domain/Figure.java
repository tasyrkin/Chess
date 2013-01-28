package de.tasyrkin.chess.domain;

import java.util.List;

public abstract class Figure {

    protected Position position;
    protected Color color;

    public Figure(Position position, Color color){
        this.position = position;
        this.color = color;
    }

    public boolean moveTo(Position newPosition){
        if(isValidMoveTo(position)){
            position = newPosition;
            return true;
        }
        return false;
    }
    public abstract boolean isValidMoveTo(Position position);
    public abstract List<Position> getMovePositions();

}
