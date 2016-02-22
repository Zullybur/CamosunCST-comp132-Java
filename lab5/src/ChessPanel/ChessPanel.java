package ChessPanel;

/**
 * ChessPanel.java
 */

// Import the basic graphics classes.
import java.awt.Canvas;
import java.awt.*;

/**
 * A chess board drawing program.
 * 
 * @author Matthew Casiro.
 */
public class ChessPanel extends Canvas{
    
    //declare constanst for the number of rows and columns (8 of each)
    //and the offset of x and y can be set to 32
    private static final int ROWS = 8;
    private static final int COLS = 8;
    private static final int X_OFF = 32;
    private static final int Y_OFF = 32;
    
    //declare a field to hold the size of the squares
    @SuppressWarnings("FieldMayBeFinal")
    private int squareSize;
    @SuppressWarnings("FieldMayBeFinal")
    private int boardSize;
    
    
    /**
     * Determine the size of each square and the chess board based on
     * a size provided.
     * 
     * @param size determines the max width &amp; height of the board.
     */
    public ChessPanel(int size){
      
        //this call to super MUST come first in the constructor
        super();
        //set the grid square size as board size divided by number of rows
        squareSize = size / ROWS;
        boardSize = squareSize * ROWS;
    
    }

    /**
     * Fill the canvas with a black background and call the functions to
     * draw the checkerboard pattern.
     * 
     * @param g is the graphics object being used.
     */
    @Override
    public void paint(Graphics g){

        //this is where the drawing happens!
        //in here you will:
        //fill the whole panel with the color black
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, this.getWidth(), this.getHeight());
        
        //call the function drawRects(Graphics g) to draw the chessboard
        drawRects(g);
        
        //set the colour to White
        g.setColor(Color.WHITE);
        //draw a rectangle around the chessboard 
        g.drawRect(X_OFF, Y_OFF, boardSize, boardSize);
    
    }
    
    /**
     * Iterate through the columns and rows and calculate the color required
     * for each square, then call the fillGridSquare method to draw it.
     * 
     * @param g is the graphics object being used.
     */
    private void drawRects(Graphics g){
        //this function will draw the rects to create a chess board
        //iterate through the rows and columns and draw alternating 
        //black and white squares
        //logic is as follows:
        /*
        for each column:
            for each row:
                if column index is even and row index is odd: draw a black rect
                if column index is odd and row index is even: draw a black rect
                otherwise draw a white rect
        */
        for(int i = 0; i < COLS; i++) {
            for(int j = 0; j < ROWS; j++) {
                if((i + j) % 2 == 0) {
                    g.setColor(Color.WHITE);
                } else {
                    g.setColor(Color.BLACK);
                }
                fillGridSquare(g, i, j);
            }
        }
        
        
    }
    
    /**
     * Draw a filled rectangle give a graphics object, row, and column number.
     * 
     * @param g is the graphics object being used.
     * @param column is the column number we are drawing for.
     * @param row is the row number we are drawing for.
     */
    private void fillGridSquare(Graphics g, int column, int row){
        /*
        fills a grid square by calling g.fillRect(xPosition, yPosition, squareSize, squareSize);
        you'll need to calculate xPosition as:
            column number times square size + x offset
        and yPosition as:
            row number times square size + y offset
        */
        int x, y;
        x = X_OFF + (column * squareSize);
        y = Y_OFF + (row * squareSize);
        g.fillRect(x, y, squareSize, squareSize);
    }
}