package DisjointSet;

import java.util.Arrays;

class Edge implements Comparable<Edge>{

    // Weight of the edge
    int weight;

    // Vertices on both ends of the edge
    int u, v;

    Edge(int weight, int u, int v) {
        this.weight = weight;
        this.u = u;
        this.v = v;
    }

    @Override
    public int compareTo(Edge o) {
        if(this.weight > o.weight)
            return 1;
        return -1;
    }
}

public class MinimumSpanningTree {

    static int findRoot(int node, int parent[]) {
        // Find root of set that contains node, node
        while(parent[node] != node) {
            parent[node] = parent[parent[node]];
            node = parent[node];
        }
        return node;
    }

    // Function to perform union of two sets,
    // node1 and node2 belongs to
    static void unionSets(int node1, int node2, int parent[]) {
        // Find root of set, node1 belongs to
        int p1 = findRoot(node1, parent);

        // Find root of set, node2 belongs to
        int p2 = findRoot(node2, parent);

        // Make parent of p1 as p2, to join two sets
        parent[p1] = parent[p2];
    }

    // Function to implement the kruskal's MST Algorithm
    static int kruskalMST(Edge edge[], int V, int E) {
        // Parent array for union-find Algorithm
        int parent[] = new int[V];

        // Initialize the parent array
        for(int i=0; i<V; i++) {
            parent[i] = i;
        }

        int u, v, cost, minCost = 0;

        for(int i = 0; i<E; i++) {
            u = edge[i].u;
            v = edge[i].v;
            cost = edge[i].weight;

            // Check if selected edge will form
            // a cycle or not
            // --> It will form a cycle if they belongs
            //     to the same set
            if(findRoot(u,parent)!=findRoot(v,parent)) {
                minCost += cost;
                unionSets(u, v, parent);
            }
        }
        return minCost;
    }

    // Driver code
    public static void main(String[] args) {
        /* Let us create following weighted graph
            10
        0--------1
        |  \     |
       6|   5\   |15
        |       \ |
        2--------3
            4     */
        int V = 4; // Number of vertices in graph
        int E = 5; // Number of edges in graph

        // Declare a list of Pair of Pair
        // pair<int, pair<int, int> > graph[],
        // such that graph.first is the weight of an edge
        // and, graph.second.first and graph.second.second
        // are the vertices joined to form the edge
        Edge edge[] = new Edge[E];

        // add edge 0-1
        edge[0] = new Edge(10, 0, 1);

        // add edge 0-2
        edge[1] = new Edge(6, 0, 2);

        // add edge 0-3
        edge[2] = new Edge(5, 0, 3);

        // add edge 1-3
        edge[3] = new Edge(15, 1, 3);

        // add edge 2-3
        edge[4] = new Edge(4, 2, 3);

        // Sort the graph according to weight of edges
        Arrays.sort(edge);

        // Apply Kruskal's Algorithm
        int minCost = kruskalMST(edge, V, E);

        System.out.print("The cost of MST is: "+minCost);
    }
}