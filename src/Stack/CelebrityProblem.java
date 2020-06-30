package Stack;

import java.util.Scanner;

public class CelebrityProblem {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t>0) {
            int N = sc.nextInt();
            int M[][] = new int[N][N];
            for(int i=0; i<N; i++) {
                for(int j=0; j<N; j++) {
                    M[i][j] = sc.nextInt();
                }
            }
            System.out.println(getId(M,N));
            t--;
        }
    }

    static int getId(int M[][], int n) {
        int a = 0;
        int b = n-1;

        while(a<b) {
            if(M[a][b] == 1)
                a++;
            else
                b--;
        }

        for(int i=0; i<n; i++)
            if((i != a) && (M[a][i]==1 || M[i][a] == 0))
                return -1;
        return a;
    }
}

//        Input :
//        2
//        3
//        0 1 0 0 0 0 0 1 0
//        2
//        0 1 1 0
//
//        Output :
//        1
//        -1