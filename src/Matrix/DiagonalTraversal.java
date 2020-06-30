package Matrix;

import java.util.Scanner;

public class DiagonalTraversal {
    public static void main(String[] args){
        Scanner sc= new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int mat[][] = new int[m][n];
        for (int i=0;i<m;i++){
            for (int j=0;j<n;j++){
                mat[i][j] = sc.nextInt();
            }
        }

        for (int k = 0;k<=m-1;k++){
            int i = k;
            int j = 0;
            while (i >=0){
                System.out.print(mat[i][j]+" ");
                i--;j++;
            }
            System.out.println();
        }

        for (int k = 1; k<=n-1;k++){
            int i = m-1;
            int j = k;
            while (j<=n-1){
                System.out.print(mat[i][j]+" ");
                i--;j++;
            }
            System.out.println();
        }
    }
}

//4 5
//1 2 3 4 5
//6 7 8 9 10
//11 12 13 14 15
//16 17 18 19 20