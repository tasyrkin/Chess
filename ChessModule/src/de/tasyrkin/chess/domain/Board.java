package de.tasyrkin.chess.domain;

public class Board {

    private static int SIZE = 8;

    private Figure[][] positions = new Figure[8][8];

    public Board(){

        int row = 1;
        for(int column = 0; column < SIZE; column++){
            positions[1][column] = new Pawn(new Position(row, column), Color.BLACK);
        }
    }
}
