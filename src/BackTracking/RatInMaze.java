package BackTracking;

import java.util.Scanner;

public class RatInMaze {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        char mat[][]=new char[n][m];
        int ans[][]=new int[n][m];
        for (int i=0;i<n;i++){
            String s = sc.next();
            for(int j=0;j<m;j++){
                mat[i][j] = s.charAt(j);
            }
        }
        if (solve(mat,n-1,m-1,ans,0,0)){
            for (int i=0;i<n;i++){
                for(int j=0;j<m;j++){
                    System.out.print(ans[i][j]+" ");
                }
                System.out.println();
            }
        }else{
            System.out.println(-1);
        }
    }

    public static boolean solve(char maze[][],int n,int m, int ans[][],int i,int j){
        if (i==n && j==m){
            ans[n][m]=1;
            return true;
        }

        if (i>n || j>m)return false;

        if (maze[i][j]=='X') return false;

        ans[i][j]=1;
        if (solve(maze,n,m,ans,i,j+1)){
            return true;
        }

        if (solve(maze,n,m,ans,i+1,j)){
            return true;
        }

        ans[i][j]=0;
        return false;
    }
}


//        5 4
//        OXOO
//        OOOX
//        OOXO
//        XOOO
//        XXOO