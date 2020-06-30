package Graph;

import java.io.*;
import java.util.*;
import java.lang.*;

class PathExists {

        static class Pair {
            int x,y;
            Pair(int a, int b){
                this.x=a;
                this.y=b;
            }
        }

        static int[] X = new int[] {1, 0, -1, 0};
        static int[] Y = new int[] {0, 1, 0, -1};

        static boolean validPath(int x, int y, int n){
            return (x>=0 && y>=0 && x<n && y<n);
        }

        static int pathExists(int[][] arr, int n, Pair s, Pair d){
            boolean[][] visited = new boolean[n+1][n+1];
            Queue<Pair> q = new LinkedList<>();
            q.add(s);
            boolean pathFound = false;
            while(!q.isEmpty()){
                Pair p = q.poll();
                visited[p.x][p.y]=true;
                for(int i=0; i<4; i++){
                    int x = p.x+X[i];
                    int y = p.y+Y[i];
                    if(validPath(x, y, n)){
                        if(arr[x][y]==2){
                            pathFound=true;
                            break;
                        }
                        if(!visited[x][y] && arr[x][y]==3){
                            q.add(new Pair(x, y));
                        }
                    }
                }
                if(pathFound)break;
            }
            if(pathFound)return 1;
            return 0;
        }

        public static void main (String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int t = Integer.parseInt(br.readLine().trim());
            while(t-->0){
                String inputLine[] = br.readLine().trim().split(" ");
                int n = Integer.parseInt(inputLine[0]);
                inputLine = br.readLine().trim().split(" ");
                int[][] arr = new int[n][n];
                int k=0;
                Pair s = null,d=null;
                for(int i=0; i<n; i++){
                    for(int j=0; j<n; j++){
                        arr[i][j]=Integer.parseInt(inputLine[k++]);
                        if(arr[i][j]==1)s = new Pair(i, j);
                        if(arr[i][j]==2)d = new Pair(i, j);
                    }
                }
                System.out.println(pathExists(arr, n, s, d));
            }
        }
}


//        Input:
//        2
//        4
//        3 0 0 0 0 3 3 0 0 1 0 3 0 2 3 3
//        3
//        0 3 2 3 0 0 1 0 0
//
//        Output:
//        1
//        0


