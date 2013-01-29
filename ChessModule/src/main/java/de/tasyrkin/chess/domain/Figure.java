package de.tasyrkin.chess.domain;

import java.util.List;

/**
 * Represents all figures.
 */
public abstract class Figure {

    protected Position position;
    protected Color color;

    public Figure(Position position, Color color){
        this.position = position;
        this.color = color;
    }

    /**
     * Is the position valid for the figure to move to.
     */
    public abstract boolean isValidMoveTo(Position position);

    public Color getColor() {
        return color;
    }

    public Position getPosition() {
        return position;
    }
}
