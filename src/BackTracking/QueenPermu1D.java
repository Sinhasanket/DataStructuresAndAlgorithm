package BackTracking;

public class QueenPermu1D {
    static int count=0;
    public static void main(String[] args){
        boolean board[]=new boolean[4];
        int totalQueen = 2;
        queenPermutation(board,0,totalQueen,"");
    }
    public static void queenPermutation(boolean[] board, int qpsf,int tq,String ans){
        if (qpsf==tq){
            count++;
            System.out.println(count+". "+ans);
            return;
        }

        for (int i=0;i<board.length;i++){
            if (board[i]==false){
                board[i]=true;
                queenPermutation(board,qpsf+1,tq, ans+"q"+qpsf+"b"+i+" ");
                board[i]=false; //undo
            }
        }
    }
}
