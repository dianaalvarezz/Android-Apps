/************************************************************************
 *                                                                      *
 *     Class Name: Chessboard.java                                      *
 *                                                                      *
 *        Purpose: Model that represents and controls the chessboard    *                                            *
 *        color and logic                                               *
 *                                                                      *
 ************************************************************************/
package edu.niu.android.chessboard;

 public class ChessboardModel
 {
    private final String[][] board;

    // Class that helps chessboard behavior
    public ChessboardModel()
    {

        // Initalizes and creates the 2d array that is the chessboard
        board = new String[][]{
                {"8", "", "", "", "", "", "", ""},
                {"7", "", "", "", "", "", "", ""},
                {"6", "", "", "", "", "", "", ""},
                {"5", "", "", "", "", "", "", ""},
                {"4", "", "", "", "", "", "", ""},
                {"3", "", "", "", "", "", "", ""},
                {"2", "", "", "", "", "", "", ""},
                {"1 a", "b", "c", "d", "e", "f", "g", "h"}
        };
    }

    // Methods that gets the label at a specic postion on the chessboard
    public String getPieceAt(int row, int col)
    {
        return board[row][col];
    }

    // This is what makes ever other square black
    public boolean isBlackSquare(int row, int col)
    {
        return (row + col) % 2 == 0;
    }
}
