package Graph;

public class GraphClient {
    public static void main(String[] args){
        Graph g = new Graph();
        g.addVertex("A");
        g.addVertex("B");
        g.addVertex("C");
        g.addVertex("D");
        g.addVertex("E");
        g.addVertex("F");
        g.addVertex("G");

        g.addEdge("A","B",2);
        g.addEdge("A","D",6);
        g.addEdge("B","C",3);
        g.addEdge("C","D",1);
        g.addEdge("D","E",8);
        g.addEdge("E","F",5);
        g.addEdge("E","G",7);
        g.addEdge("F","G",9);

        g.display();

//        System.out.println(g.numEdges());
//        System.out.println(g.numVertex());
//        System.out.println(g.containsEdges("A","C"));
//        System.out.println(g.containsEdges("E","F"));
//        g.removeEdge("D","E");
//
//        g.display();
//
//        g.removeVertex("F");
//
//        g.display();
//
//        g.addVertex("F");
//        g.display();
//
//        g.addEdge("A","F",15);
//        g.display();

//        System.out.println(g.hasPath("A","F",new HashMap<>()));

        System.out.println(g.bfs("A","F"));

//        System.out.println(g.dfs("A","F"));
//        g.bft();
//        g.dft();

//        System.out.println(g.isCyclic());

//        System.out.println(g.getCC());

//          g.prim().display();
      //  System.out.println(g.dijikstra("A"));

    }

}
