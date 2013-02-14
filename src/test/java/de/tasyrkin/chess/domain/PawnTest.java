package de.tasyrkin.chess.domain;

import org.junit.Assert;
import org.junit.Test;

import java.util.zip.CheckedInputStream;

import static org.junit.Assert.assertEquals;

public class PawnTest {

    @Test
    public void testIsValidMoveBlackOK(){

        for(int row = 0; row < Board.SIZE-1; row++){
            checkMove(true, Color.BLACK, row, row+1);
        }
        checkMove(true, Color.BLACK, 0, 2);
        checkMove(true, Color.BLACK, 1, 3);
    }

    @Test
    public void testIsValidMoveBlackWrong(){

        //moving back
        for(int row = Board.SIZE-1; row > 0; row--){
            checkMove(false, Color.BLACK, row, row-1);
        }

        //moving 2 rows in enemy's half
        for(int row = 2; row < Board.SIZE-2; row++){
            checkMove(false, Color.BLACK, row, row+2);
        }
    }

    @Test
    public void testIsValidMoveBlackWrongInColumn(){
        checkMove(false, Color.BLACK, 0, 0, 0, 1);
        checkMove(false, Color.BLACK, 0, 2, 0, 3);
    }

    @Test
    public void testIsValidMoveWrongMoreThenTwo(){

        for(int i = 0; i < Board.SIZE; i++){
            for(int j = 0; j < Board.SIZE; j++){
                if(Math.abs(i-j) > 2){
                    checkMove(false, Color.BLACK, i, j);
                    checkMove(false, Color.WHITE, i, j);
                    for(int row = 0; row < Board.SIZE; row++){
                        checkMove(false, Color.BLACK, row, i, row, j);
                        checkMove(false, Color.WHITE, row, i, row, j);
                    }
                }
            }
        }
    }

    @Test
    public void testIsValidMoveWhiteOK(){

        for(int row = Board.SIZE-1; row > 0; row--){
            checkMove(true, Color.WHITE, row, row-1);
        }
        checkMove(true, Color.WHITE, 7, 5);
        checkMove(true, Color.WHITE, 6, 4);
    }

    @Test
    public void testIsValidMoveWhiteWrong(){

        //moving back
        for(int row = 0; row < Board.SIZE-1; row++){
            checkMove(false, Color.WHITE, row, row+1);
        }

        //moving 2 rows in enemy's half
        for(int row = 5; row > 1; row--){
            checkMove(false, Color.WHITE, row, row-2);
        }
    }

    @Test
    public void testIsValidMoveWhiteWrongInColumn(){
        checkMove(false, Color.WHITE, 0, 0, 0, 1);
        checkMove(false, Color.WHITE, 0, 2, 0, 3);
    }

    private void checkMove(boolean isValid, Color color, int startRow, int targetRow) {
        for(int column = 0; column < Board.SIZE; column++){
            checkMove(isValid, color, startRow, column, targetRow, column);
        }
    }

    private void checkMove(boolean isValid, Color color, int startRow, int startColumn, int targetRow, int targetColumn) {
        Position initialPosition = new Position(startRow, startColumn);
        Position targetPosition = new Position(targetRow, targetColumn);

        Pawn pawn = new Pawn(initialPosition, color);

        assertEquals("Move to [" + targetPosition + "] must " + (!isValid ? "NOT" : "") + " be allowed", isValid, pawn.isValidMoveTo(targetPosition));
    }
}
