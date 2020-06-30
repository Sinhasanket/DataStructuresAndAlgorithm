package Recursion;

public class Nqueen {
    public static void main(String[] args){
        boolean board[][]=new boolean[4][4];
        System.out.println(countNqueen(board,0));
//        printNQueen(board,0,"");
    }

    public static int countNqueen(boolean[][] board, int row){
        if (row==board.length){
            return 1;
        }
        int count=0;
        for (int col=0;col<board[row].length;col++){
            if (isSafe(board,row,col)){
                board[row][col]=true;
                count=count+countNqueen(board,row+1);
                board[row][col]=false;
            }
        }
        return count;
    }

//    public static void printNQueen(boolean[][] board,int row,String ans){
//       if (row==board.length){
//           System.out.println(ans);
//           return;
//       }
//        for (int col=0;col<board[row].length;col++){
//            if (isSafe(board,row,col)){
//                board[row][col]=true;
//                printNQueen(board,row+1,ans+"{"+(row+1)+"-"+(col+1)+"}, ");
//                board[row][col]=false;
//            }
//        }
//    }

    public static boolean isSafe(boolean[][] board,int row,int col){
        for (int i=row;i>=0;i--){
            if (board[i][col]){
                return false;
            }
        }

        for (int i=row,j=col;i>=0&&j>=0;i--,j--){
            if (board[i][j]){
                return false;
            }
        }

        for (int i=row,j=col;i>=0&&j<board.length;i--,j++){
            if (board[i][j]){
                return false;
            }
        }

        return true;
    }
}
