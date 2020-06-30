package Graph;

public class Dijikstras {
    static final int V = 9;
    int minDistance(int dist[], Boolean sptSet[]) {
        int  min_index = -1;
        for (int v = 0; v < V; v++)
            if (sptSet[v] == false && ( min_index==-1 ||  dist[v] <= dist[min_index])) {
                min_index = v;
            }

        return min_index;
    }

    void printSolution(int dist[], int n) {
        System.out.println("Vertex   Distance from Source\n");
        for (int i = 0; i < V; i++)
            System.out.println(i + "                " + dist[i]+"\n");
    }

    void dijkstra(int graph[][], int src) {

        int dist[] = new int[V];

        Boolean sptSet[] = new Boolean[V];

        for (int i=0;i<V;i++){
            dist[i]=Integer.MAX_VALUE;
            sptSet[i] = false;
        }

        dist[src] = 0;
        // Find shortest path for all vertices
        for (int count = 0; count < V -1; count++) {
            // Pick the minimum distance vertex from the set of vertices
            // not yet processed. u is always equal to src in first
            // iteration.
            int u = minDistance(dist, sptSet);

            // Mark the picked vertex as processed
            sptSet[u] = true;

            // Update dist value of the adjacent vertices of the
            // picked vertex.
            for (int v = 0; v < V; v++)

                // Update dist[v] only if is not in sptSet, there is an
                // edge from u to v, and total weight of path from src to
                // v through u is smaller than current value of dist[v]
                if (!sptSet[v] && graph[u][v] != 0 ){
                     int distance = dist[u] + graph[u][v];
                     if (distance < dist[v]){
                         dist[v] = distance;
                     }

                }
        }

        printSolution(dist, V);
    }

    // Driver method
    public static void main(String[] args) {
        int graph[][] = new int[][] {
                { 0, 4, 0, 0, 0, 0, 0, 8, 0 },
                { 4, 0, 8, 0, 0, 0, 0, 11, 0 },
                { 0, 8, 0, 7, 0, 4, 0, 0, 2 },
                { 0, 0, 7, 0, 9, 14, 0, 0, 0 },
                { 0, 0, 0, 9, 0, 10, 0, 0, 0 },
                { 0, 0, 4, 14, 10, 0, 2, 0, 0 },
                { 0, 0, 0, 0, 0, 2, 0, 1, 6 },
                { 8, 11, 0, 0, 0, 0, 1, 0, 7 },
                { 0, 0, 2, 0, 0, 0, 6, 7, 0 }
        };
        Dijikstras t = new Dijikstras();
        t.dijkstra(graph, 0);
    }
}
