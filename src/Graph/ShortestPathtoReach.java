package Graph;

import java.io.IOException;
import java.util.Scanner;

public class ShortestPathtoReach {
    public static void main(String args[] ) throws IOException {
        try{
            Scanner s = new Scanner(System.in);
            int t = s.nextInt();
            int n = s.nextInt();
            int m = s.nextInt();
            long graph[][] =new long[n+1][n+1];
            while(m-->0){
                int u = s.nextInt();
                int v = s.nextInt();
                int w = s.nextInt();
                if(graph[u][v]>w || graph[v][u]>w) {
                    graph[u][v]=w;
                    graph[v][u]=w;
                }
                graph[u][v] = w;
                graph[v][u] = w;
            }
//            for(int i=1;i<=n;i++){
//                for(int j=1;j<=n;j++){
//                    System.out.print(graph[i][j]+" ");
//                }
//                System.out.println();
//            }
            int st = s.nextInt();
            dijkstra(graph,n,st);

        }catch(Exception e){
            return;
        }
    }

    public static void dijkstra(long graph[][],int v,int src){
        long dist[] = new long[v+1];
        boolean vis[]=new boolean[v+1];
        for(int i=1;i<=v;i++){
            dist[i] = Integer.MAX_VALUE;
            vis[i] = false;
        }
        dist[src] = 0;
        for(int i=1;i<=v;i++){
            int min = minIdx(dist,vis,v);
            vis[i] = true;
            for(int j=1;j<=v;j++){
                if(!vis[j] && graph[min][j] != 0){
                    long dista = graph[min][j] + dist[min];
                    if(dista < dist[j]){
                        dist[j] = dista;
                    }
                }
            }
        }

        for(int i=2;i<=v;i++){
            if (dist[i]==Integer.MAX_VALUE) System.out.println("-1 ");
            else System.out.print(dist[i]+" ");
        }
    }

    public static int minIdx(long dis[],boolean vis[],int v){
        int mI = -1;
        for(int i=1;i<=v;i++){
            if(!vis[i] && (mI == -1 || dis[i] <= dis[mI])){
                mI = i;
            }
        }
        return mI;
    }
}
