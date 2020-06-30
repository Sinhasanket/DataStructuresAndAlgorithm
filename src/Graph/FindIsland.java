package Graph;

import java.util.ArrayList;
import java.util.Scanner;

public class FindIsland {

    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while(t-->0){
            int N = sc.nextInt();
            int M = sc.nextInt();

            ArrayList<ArrayList<Integer>> list = new ArrayList<>(N);

            for(int i = 0; i < N; i++) {
                ArrayList<Integer> temp = new ArrayList<>(M);
                list.add(i, temp);
            }

            for(int i = 0; i < N; i++) {
                for(int j = 0; j < M; j++) {
                    int val = sc.nextInt();
                    list.get(i).add(j, val);
                }
            }
            System.out.println(findIslands(list, N, M));
        }
    }

    static int findIslands(ArrayList<ArrayList<Integer>> list, int N, int M) {

        int count = 0;
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                int current=list.get(i).get(j);
                if(current== 1) {
                    dfs(list,N,M,i,j);
                    count++;
                }
            }
        }
        return count;
    }

    static void dfs(ArrayList<ArrayList<Integer>> list, int N, int M, int i, int j) {
        list.get(i).set(j, 2);

        for(int dx=((i==0)?0:-1); dx<=((i==N-1)?0:1); dx++) {
            for(int dy=((j==0)?0:-1); dy<=((j==M-1)?0:1); dy++) {
                if(list.get(i+dx).get(j+dy) == 1) {
                    dfs(list,N,M,i+dx,j+dy);
                }
            }
        }

    }
}



//        Input
//        2
//        3 3
//        1 1 0 0 0 1 1 0 1
//        4 4
//        1 1 0 0 0 0 1 0 0 0 0 1 0 1 0 0
//
//        Output
//        2
//        2
