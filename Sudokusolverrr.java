/*
Code for solving literally any level of sudoku
 */

public class Sudokusolverrr {
    private static final int G_size=9;
    public static void main(String[] args) {
        /*
        just enter your personal sudoku here
        keep in mind that the zero represents as empty spaces
         */
        int [][] board={
                {0 ,9 ,0 ,0 ,0 ,0 ,0 ,0 ,0},
                {0 ,0 ,0 ,7 ,0 ,0 ,0 ,8 ,0},
                {0 ,5 ,4 ,0 ,3 ,0 ,7 ,0 ,0},
                {6 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,0},
                {0 ,0 ,0 ,0 ,0 ,1 ,0 ,0 ,2},
                {0 ,7 ,3 ,0 ,5 ,0 ,8 ,0 ,0},
                {9 ,0 ,0 ,0 ,0 ,0 ,4 ,0 ,0},
                {8 ,0 ,0 ,0 ,6 ,0 ,0 ,0 ,0},
                {0 ,4 ,6 ,0 ,0 ,5 ,0 ,1 ,0}
        };

        printboard(board);

        if (solv(board)){
            System.out.println("Solved successfully");
        }
        else{
            System.out.println("Unsolvable board :(");
        }
        printboard(board);    }

    private static void printboard(int[][] board) {
        for (int i=0; i<G_size; i++){
            if(i%3==0&&i!=0){
                System.out.println("-----------");
            }
            for(int j=0; j<G_size; j++){
                if (j%3==0&&j!=0){
                    System.out.print("|");
                }
                System.out.print(board[i][j]);
            }
            System.out.println();
        }
    }
/*
this function will check if the number to be inserted is already present in the row or not
 */
    private static boolean isNumberInRow(int [][]board,int number, int row){
        for (int i=0; i<G_size; i++){
            if(board[row][i]==number){
                return true;
            }
        }
        return false;
    }
    /*
this function will check if the number to be inserted is already present in the column or not
 */

    private static boolean isNumberInColumn(int [][]board,int number, int column){
        for (int i=0; i<G_size; i++){
            if(board[i][column]==number){
                return true;
            }
        }
        return false;
    }

    /*
this function will check if the number to be inserted is already present in the box or not
 */
    private static boolean isNumberInbox(int [][]board,int number, int row,int column){
        int localboxrow=row-row%3;
        int localboxcol=column-column%3;

        for(int i=localboxrow; i<localboxrow +3; i++ ){
            for (int j=localboxcol; j<localboxcol +3; j++){
                if(board[i][j]==number){
                    return true;
                }
            }
        }
        return false;
    }

    /*
this function will check all the three conditions above
 */
    private static boolean isValid(int [][]board,int number, int row,int column){
        return !isNumberInRow(board,number,row)&&
                !isNumberInColumn(board,number,column)&&
                !isNumberInbox(board,number,row,column);
    }
/*
spend most of your time for understanding the function below
refer https://youtu.be/eAFcj_2quWI?si=6pQNV4A1lXbanZLH for depth of the function and logic of how computer solves the sudoku
 */
    private static boolean solv(int [][]board){
        for(int row =0 ;row <G_size; row++){
            for(int col=0; col<G_size; col++){
                if (board[row][col]==0){
                    for(int numberins=1; numberins<=G_size;numberins++){
                        if(isValid(board,numberins,row,col)){
                            board[row][col]=numberins;

                            if(solv(board)){
                                return true;
                            }
                            else {
                                board [row][col]=0;
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }
}
/*
Used concepts as 2D array along with recursion
line 97 in function solv
 */