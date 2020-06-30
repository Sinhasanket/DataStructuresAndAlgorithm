package Matrix;

import java.util.*;

public class SpiralTraversing {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while(t-- > 0) {
            int n1 = sc.nextInt();
            int m1 = sc.nextInt();

            int arr1[][] = new int[n1][m1];

            for(int i = 0; i < n1; i++) {
                for(int j = 0; j < m1; j++)
                    arr1[i][j] = sc.nextInt();
            }
            traverse(n1,m1,arr1);
            System.out.println();
        }
    }


    static void traverse(int m, int n, int arr1[][]){
        int l=0,k=0;
        while(k<m &&l<n){
           for(int i=l;i<n;i++){
              System.out.print(arr1[k][i]+" ");
           }
        k++;
           for(int i=k;i<m;i++){
             System.out.print(arr1[i][n-1]+" ");
            }
        n--;
        if(k<m){
          for(int i=n-1;i>=l;i--){
            System.out.print(arr1[m-1][i]+" ");
         }
         m--;
        }
        if(l<n){
          for(int i=m-1;i>=k;i--){
            System.out.print(arr1[i][l]+" ");
          }
        l++;
        }
        }
    }
}

//2
//4 4
//1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16
//3 4
//1 2 3 4 5 6 7 8 9 10 11 12

