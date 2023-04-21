package ar.edu.utn.frc.tup.lciii;

import java.util.List;


public class Queen {

    /*
     * Complete the 'queensAttack' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. INTEGER k
     *  3. INTEGER r_q
     *  4. INTEGER c_q
     *  5. 2D_INTEGER_ARRAY obstacles
     * int n: the number of rows and columns in the board
       int k: the number of obstacles on the board
       int r_q: the row number of the queen's position
       int c_q: the column number of the queen's position
       int obstacles [k][2]: each element is an array of 2 integers, the row and column of an obstacle
     */

    private void fillTheBoard(Integer[][]board){
        for(int i=0; i<board.length; i++){
            for(int j=0; j < board.length; j++ ){
                board[i][j]=0;

            }

        }

    }

    private void setQueensPositionAndObstacles(Integer [][]board, Integer rowQueen, Integer columnQueen, List<List<Integer>> obstacles){

        try {
            board[rowQueen - 1][columnQueen - 1] = 1;
        }
        catch(IndexOutOfBoundsException e)
        {
            throw new IllegalArgumentException("Error, pusiste la reina fuera del tablero papa");
        }

        if(obstacles!=null){
            try {
                for (List<Integer> obstacle :
                        obstacles) {
                    int row = obstacle.get(0);
                    int col = obstacle.get(1);
                    board[row - 1][col - 1] = 2;
                }
            } catch (IndexOutOfBoundsException e) {
                throw new IllegalArgumentException("ERROR: Los obstaculos deben estar en el tablero, no en tu cabeza");
            }
        }


    }



    public Integer queensAttack(Integer n, Integer k, Integer r_q, Integer c_q, List<List<Integer>> obstacles) {
        // Write your code here

        Integer[][] board = new Integer[n][n];
        fillTheBoard(board);
        setQueensPositionAndObstacles(board,r_q,c_q,obstacles);

        int[] x = {0, 0, -1, 1, -1, -1, 1, 1};
        int[] y = {-1, 1, 0, 0, -1, 1, -1, 1};

        int count = 0;
        int r = r_q - 1;
        int c = c_q - 1;

        for (int i = 0; i < x.length; i++) {
            int row = r + x[i];
            int col = c + y[i];


            while (row >= 0 && row < n && col >= 0 && col < n && board[row][col] != 2) {
                if (board[row][col] == 0) {
                    count++;
                }
                row += x[i];
                col += y[i];
            }
        }

        return count;
    }
}
