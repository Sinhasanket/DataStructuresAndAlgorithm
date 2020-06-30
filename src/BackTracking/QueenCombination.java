package BackTracking;

public class QueenCombination {
    static int count=0;
    public static void main(String[] args){
        // boolean board[]=new boolean[4];
        // int totalQueen = 2;
        // QueenCombination(board,0,totalQueen,"",-1);

        // QueenCombinationwrtBox(board,0,0,totalQueen,"");

        // QueenCombinationwrtBox2d(new boolean[2][2],0,0,0,2,"");

         QueenCombinationwrtBox2dKill(new boolean[10][10],0,0,0,10,"");

        // boolean chess[][] = new boolean[3][3];
        // NQueen(chess,0,0,0,chess.length,"");

       //  boolean chess[][] = new boolean[3][3];
       //  NKnights(chess,0,0,0,chess.length,"");

       //  boolean chess[][] = new boolean[3][3];
       //  NQueen2(chess,0,0,3,"");

       // KQueenNBoard(new boolean[4][4],0,0,3,"");
    }

    public static void QueenCombination(boolean[] boards,int qpsf,int tq,String ans,int lastboxused){
        if (qpsf==tq){
            count++;
            System.out.println(count+". "+ans);
            return;
        }

        for (int i=lastboxused+1;i<boards.length;i++){
            boards[i]=true;
            QueenCombination(boards,qpsf+1,tq,ans+"q"+qpsf+"b"+i+" ",i);
            boards[i]=false; //backtrack
        }
    }

    public static void QueenCombinationwrtBox(boolean[] board,int col,int qpsf,int tq,String ans){
        //Positive BaseCase
        if (qpsf==tq){
            System.out.println(ans);
            return;
        }

        //Negtive BaseCase
        if (col==board.length){
            return;
        }

        //Place Queen
        board[col] = true;
        QueenCombinationwrtBox(board,col+1,qpsf+1,tq,ans+"B"+col+" ");
        board[col] = false;

        //Don't Place Queen
        QueenCombinationwrtBox(board,col+1,qpsf,tq,ans);
    }

    public static void QueenCombinationwrtBox2d(boolean[][] board,int row,int col,int qpsf,int tq,String ans){
        //Positive BaseCase
        if (qpsf==tq){
            System.out.println(ans);
            return;
        }
        //Change ror and col manually
        if (col==board[0].length){
            row++;
            col=0;
        }
        //can do the above thing using extra recu Call
//        if (col==board[0].length){
//            QueenCombinationwrtBox2d(board,row+1,0,qpsf,tq,ans);
//           return;
//        }

        //Negtive BaseCase
        if (row==board.length){
            return;
        }
        //Place Queen
        board[row][col] = true;
        QueenCombinationwrtBox2d(board,row,col+1,qpsf+1,tq,ans+"{"+row+","+col+"}, ");
        board[row][col] = false;

        //Don't Place Queen
        QueenCombinationwrtBox2d(board,row,col+1,qpsf,tq,ans);
    }

    //MxN Board and K Queen when queen can kill
    public static void QueenCombinationwrtBox2dKill(boolean[][] board,int row,int col,int qpsf,int tq,String ans){
        //Positive BaseCase
        if (qpsf==tq){
            System.out.println(++count+" "+ans);
            return;
        }
        //Change ror and col manually
        if (col==board[0].length){
            row++;
            col=0;
        }
        //Negtive BaseCase
        if (row==board.length){
            return;
        }
        //Place Queen
        if(isSafe(board,row,col)) {
            board[row][col] = true;
            QueenCombinationwrtBox2dKill(board, row, col + 1, qpsf + 1, tq, ans + "{" + row + "," + col + "}, ");
            board[row][col] = false;
        }

        //Don't Place Queen
        QueenCombinationwrtBox2dKill(board,row,col+1,qpsf,tq,ans);
    }

    public static boolean isSafe(boolean board[][],int row,int col){
        //Vertically upward
        int r = row-1;
        int c = col;
        while (r>=0){
            if (board[r][c]){
                return false;
            }
            r--;
        }

        //Hoeizontal left
        r = row;
        c = col-1;
        while (c>=0){
            if (board[r][c]){
                return false;
            }
            c--;
        }

        //Diagonally left
        r = row-1;
        c = col-1;
        while (r>=0 && c>=0){
            if (board[r][c]){
                return false;
            }
            c--;r--;
        }

        //Diagonally right
        r = row-1;
        c = col+1;
        while (r>=0 && c<board[0].length){
            if (board[r][c]){
                return false;
            }
            r--;c++;
        }

        return true;
    }

    //NxN board with N Queen to be placed Combination
    public static void NQueen(boolean[][] board,int row,int col,int qpsf,int tq,String ans){
        //Positive BaseCase
        if (qpsf==tq){
            System.out.println(ans);
            return;
        }
        //Change row and col manually
        if (col==board[0].length){
            row++;
            col=0;
        }
        //Negtive BaseCase
        if (row==board.length){
            return;
        }
        //Place Queen
        if(isSafe(board,row,col)) {
            board[row][col] = true;
            //if we have placed a queen in particular row we can directly place the next queen to
            //next row to save some function frame :D
            NQueen(board, row+1, 0, qpsf + 1, tq, ans + "{" + row + "," + col + "}, ");
            board[row][col] = false;
        }
        //Don't Place Queen
        NQueen(board,row,col+1,qpsf,tq,ans);
    }

    //NxN board with N Knights to be placed
    public static void NKnights(boolean board[][],int row,int col,int kpsf,int tk,String ans){
        if (kpsf==tk){
            System.out.println(ans);
            return;
        }
        if (board[0].length==col){
            row++;
            col=0;
        }
        if (board.length==row){
            return;
        }
        if (isitSafeToPlaceKnight(board,row,col)) {
            board[row][col] = true;
            NKnights(board, row, col + 1, kpsf + 1, tk, ans + "{" + row + "," + col + "}, ");
            board[row][col] = false;
        }
        NKnights(board,row,col+1,kpsf,tk,ans);
    }

    public static boolean isitSafeToPlaceKnight(boolean board[][],int row,int col){
        int rowArr[] = {-1,-2,-2,-1};
        int colArr[] = {2,1,-1,-2};
        for (int i=0;i<4;i++){
            int r = row - rowArr[i];
            int c = col - colArr[i];
            if (r >= 0 && r < board.length && c >= 0 && c < board[0].length){
                if (board[r][c])return false;
            }
        }
        return true;
    }

    //NQueen only one queen per row
    public static void NQueen2(boolean board[][],int row,int qpsf,int tq,String ans){
        if (tq==qpsf){
            System.out.println(ans);
            return;
        }
        if (board.length==row){
            return;
        }
        for (int col=0;col<board[0].length;col++){
            if (isSafe(board,row,col)) {
                board[row][col] = true;
                NQueen2(board, row + 1, qpsf + 1, tq, ans + "{" + row + "-" + col + "}");
                board[row][col] = false;
            }
        }
    }


    public static void KQueenNBoard(boolean board[][],int row,int qpsf,int tq,String ans){
        if (tq==qpsf){
            System.out.println(ans);
            return;
        }
        if (board.length==row){
            return;
        }
        for (int col=0;col<board[0].length;col++){
            if (isSafe(board,row,col)) {
                board[row][col] = true;
                KQueenNBoard(board, row + 1, qpsf + 1, tq, ans + "{" + row + "-" + col + "}");
                board[row][col] = false;
            }
        }
        //Not-Place
        KQueenNBoard(board,row+1,qpsf,tq,ans);
    }
}