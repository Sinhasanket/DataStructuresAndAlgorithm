package Graph;

import java.util.ArrayList;
import java.util.LinkedList;

public class BFSTraversal {

    static void addEdge(ArrayList<ArrayList<Integer> > adj,int u, int v) {
        adj.get(u).add(v);
        adj.get(v).add(u);
    }

    static void BFS(ArrayList<ArrayList<Integer> > adj, int V) {
        boolean visited[] =  new boolean[V+1];
        LinkedList<Integer> queue = new LinkedList<Integer>();
        int s = 1;
        visited[s]=true;
        queue.add(s);
        while (queue.size() != 0) {
            s = queue.poll();
            System.out.print(s+" ");
            for (int i = 0; i < adj.get(s).size(); i++) {
                int newNode = adj.get(s).get(i);
                if(visited[newNode] == false) {
                    visited[newNode] = true;
                    queue.add(newNode);
                }
            }
        }
    }

    public static void main(String[] args) {

        int V = 6;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer> >(V+1);

        for (int i = 0; i < V+1; i++)
            adj.add(new ArrayList<Integer>());

        addEdge(adj, 1, 2);
        addEdge(adj, 1, 3);
        addEdge(adj, 2, 4);
        addEdge(adj, 2, 5);
        addEdge(adj, 3, 5);
        addEdge(adj, 4, 5);
        addEdge(adj, 4, 6);
        addEdge(adj, 5, 6);

        BFS(adj, V);
    }
}
