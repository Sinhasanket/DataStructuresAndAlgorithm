package BackTracking;

import java.io.IOException;
import java.util.Scanner;

//How many ways are there to place a black and a white knight on an N * M chessboard such that they
//do not attack each other? The knights have to be placed on different squares. A knight can move two
//squares horizontally and one square vertically (L shaped), or two squares vertically and one square
//horizontally (L shaped). The knights attack each other if one can reach the other in one move.

public class BlackandWhite {
    static int row[]={1,1,2,2,-1,-1,-2,-2};
    static int coloumn[]={2,-2,1,-1,2,-2,1,-1};

    static long solve(int n, int m) {
        int count=0;
        int total=n*m;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                int moves=1;
                for(int k=0;k<8;k++){
                    int r=i+row[k];
                    int c=j+coloumn[k];
                    if(r>=0 && c>=0 && r<n && c<m )
                        moves++;
                }
                count+=(total-moves);
            }
        }
        return count;
    }

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int t=0; t<T; t++) {
            int N = sc.nextInt();
            int M = sc.nextInt();
            System.out.println(solve(N, M));
        }
    }
}


//        Input:
//        3
//        2 2
//        2 3
//        4 5
//
//        Output:
//        12
//        26
//        312


