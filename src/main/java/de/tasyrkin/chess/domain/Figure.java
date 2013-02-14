package de.tasyrkin.chess.domain;

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

    /**
     * Is the position valid to cut another figure.
     */
    public abstract boolean isValidToCutAt(Position position);

    public Color getColor() {
        return color;
    }

    public Position getPosition() {
        return position;
    }
}
