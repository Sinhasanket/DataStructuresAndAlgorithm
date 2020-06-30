package Graph;

import java.util.*;

class Graph {
    private class Vertex{
        HashMap<String,Integer> nbrs = new HashMap<>();
    }
    HashMap<String,Vertex> vrtcs;

    Graph(){
        vrtcs = new HashMap<>();
    }

    public int numVertex(){
        return this.vrtcs.size();
    }

    public boolean containVertex(String vname){
       return this.vrtcs.containsKey(vname);
    }

    public void addVertex(String vname){
       Vertex vtx = new Vertex();
       vrtcs.put(vname,vtx);
    }

    public void addEdge(String vname1,String vname2,int cost){
        Vertex vts1 = vrtcs.get(vname1);
        Vertex vts2 = vrtcs.get(vname2);
        if(vts1==null || vts2==null || vts1.nbrs.containsKey(vname2)){
            return ;
        }
        vts1.nbrs.put(vname2,cost);
        vts2.nbrs.put(vname1,cost);
    }

    public void removeVertex(String vname){
        Vertex vtx = vrtcs.get(vname);
        ArrayList<String> nbrss = new ArrayList<>(vtx.nbrs.keySet());
        for (String key : nbrss){
            Vertex vt = vrtcs.get(key);
            vt.nbrs.remove(vname);
        }
        vrtcs.remove(vname);
    }

    public int numEdges(){
       int count=0;
        ArrayList<String> keys = new ArrayList<>(vrtcs.keySet());
        for (String key : keys){
            Vertex vts = vrtcs.get(key);
            count+= vts.nbrs.size();
        }
        return count/2;
    }

    public boolean containsEdges(String vname1,String vname2){
        Vertex vts1 = vrtcs.get(vname1);
        Vertex vts2 = vrtcs.get(vname2);
        if(vts1==null || vts2==null || !vts1.nbrs.containsKey(vname2)){
            return false;
        }
        return true;
    }

    public void removeEdge(String vname1,String vname2){
        Vertex vt1 = vrtcs.get(vname1);
        Vertex vt2 = vrtcs.get(vname2);
        if(vt1==null || vt2==null || !vt1.nbrs.containsKey(vname2)){
            return ;
        }
        vt1.nbrs.remove(vname2);
        vt2.nbrs.remove(vname1);
    }

    public void display(){
        ArrayList<String> key = new ArrayList<>(vrtcs.keySet());
        System.out.println("===========================");
        for (String keys : key){
            Vertex vtx = vrtcs.get(keys);
            System.out.println(keys+" : "+vtx.nbrs);
        }
        System.out.println("===========================");
    }

    public boolean hasPath(String vname1,String vname2,HashMap<String,Boolean> processed){
        processed.put(vname1,true);
        if (containsEdges(vname1,vname2)){
            return true;
        }
        Vertex vtx = vrtcs.get(vname1);
        ArrayList<String> nbrss = new ArrayList<>(vtx.nbrs.keySet());
        for (String nb : nbrss){
            if (!processed.containsKey(nb) &&  hasPath(nb,vname2,processed)){
                return true;
            }
        }
        return false;
    }

    private class Pair{
        String psf;
        String vname;
    }

    //similar to level order of tree
    public boolean bfs(String src,String dst){
        HashMap<String,Boolean> processed = new HashMap<>();
        LinkedList<Pair> queue = new LinkedList<>();
        Pair sp = new Pair();
        sp.vname = src;
        sp.psf = src;
        queue.addLast(sp);
        while (!queue.isEmpty()){
            Pair rp = queue.removeLast();
            if (processed.containsKey(rp.vname)){
                continue;
            }
            processed.put(rp.vname,true);
            if (containsEdges(rp.vname,dst)){
                System.out.println(rp.psf+dst);
                return true;
            }
            Vertex vtx = vrtcs.get(rp.vname);
            ArrayList<String> nbr = new ArrayList<>(vtx.nbrs.keySet());
            for (String nb : nbr){
                if(!processed.containsKey(nb)){
                    Pair np = new Pair();
                    np.vname = nb;
                    np.psf = rp.psf + nb;
                    queue.addLast(np);
                }
            }
        }
        return false;
    }

    //similar to inOrder traversal of tree
    public boolean dfs(String src,String dst){
        HashMap<String,Boolean> processed = new HashMap<>();
        LinkedList<Pair> stack = new LinkedList<>();
        Pair sp = new Pair();
        sp.vname = src;
        sp.psf = src;
        stack.addFirst(sp);
        while (!stack.isEmpty()){
            Pair rp = stack.removeLast();
            if (processed.containsKey(rp.vname)){
                continue;
            }
            processed.put(rp.vname,true);
            if (containsEdges(rp.vname,dst)){
                System.out.println(rp.psf+dst);
                return true;
            }
            Vertex vtx = vrtcs.get(rp.vname);
            ArrayList<String> nbr = new ArrayList<>(vtx.nbrs.keySet());
            for (String nb : nbr){
                if(!processed.containsKey(nb)){
                    Pair np = new Pair();
                    np.vname = nb;
                    np.psf = rp.psf + nb;
                    stack.addFirst(np);
                }
            }
        }
        return false;
    }

    public void bft(){
        HashMap<String,Boolean> processed = new HashMap<>();
        LinkedList<Pair> queue = new LinkedList<>();
        ArrayList<String> keys = new ArrayList<>(vrtcs.keySet());
        for (String key : keys){
            if (processed.containsKey(key)){
                continue;
            }
            Pair sp = new Pair();
            sp.vname = key;
            sp.psf = key;
            queue.addLast(sp);
            while (!queue.isEmpty()){
                Pair rp = queue.removeLast();
                if (processed.containsKey(rp.vname)){
                    continue;
                }
                processed.put(rp.vname,true);
                System.out.println(rp.vname+" via "+rp.psf);
                Vertex vtx = vrtcs.get(rp.vname);
                ArrayList<String> nbr = new ArrayList<>(vtx.nbrs.keySet());
                for (String nb : nbr){
                    if(!processed.containsKey(nb)){
                        Pair np = new Pair();
                        np.vname = nb;
                        np.psf = rp.psf + nb;
                        queue.addLast(np);
                    }
                }
            }
        }
    }

    public void dft(){
        HashMap<String,Boolean> processed = new HashMap<>();
        LinkedList<Pair> stack = new LinkedList<>();
        ArrayList<String> keys = new ArrayList<>(vrtcs.keySet());
        for (String key : keys){
            if (processed.containsKey(key)){
                continue;
            }
            Pair sp = new Pair();
            sp.vname = key;
            sp.psf = key;
            stack.addFirst(sp);
            while (!stack.isEmpty()){
                Pair rp = stack.removeLast();
                if (processed.containsKey(rp.vname)){
                    continue;
                }
                processed.put(rp.vname,true);
                System.out.println(rp.vname+" via "+rp.psf);
                Vertex vtx = vrtcs.get(rp.vname);
                ArrayList<String> nbr = new ArrayList<>(vtx.nbrs.keySet());
                for (String nb : nbr){
                    if(!processed.containsKey(nb)){
                        Pair np = new Pair();
                        np.vname = nb;
                        np.psf = rp.psf + nb;
                        stack.addFirst(np);
                    }
                }
            }
        }
    }

    public boolean isCyclic(){
        HashMap<String,Boolean> processed = new HashMap<>();
        LinkedList<Pair> queue = new LinkedList<>();
        ArrayList<String> keys = new ArrayList<>(vrtcs.keySet());
        for (String key : keys){
            if (processed.containsKey(key)){
                continue;
            }
            Pair sp = new Pair();
            sp.vname = key;
            sp.psf = key;
            queue.addLast(sp);
            while (!queue.isEmpty()){
                Pair rp = queue.removeLast();
                if (processed.containsKey(rp.vname)){
                    return true;
                }
                processed.put(rp.vname,true);
                Vertex vtx = vrtcs.get(rp.vname);
                ArrayList<String> nbr = new ArrayList<>(vtx.nbrs.keySet());
                for (String nb : nbr){
                    if(!processed.containsKey(nb)){
                        Pair np = new Pair();
                        np.vname = nb;
                        np.psf = rp.psf + nb;
                        queue.addLast(np);
                    }
                }
            }
        }
        return false;
    }

    public boolean isConnected(){
        int flag = 0;
        HashMap<String,Boolean> processed = new HashMap<>();
        LinkedList<Pair> queue = new LinkedList<>();
        ArrayList<String> keys = new ArrayList<>(vrtcs.keySet());
        for (String key : keys){
            if (processed.containsKey(key)){
                continue;
            }
            flag++;
            Pair sp = new Pair();
            sp.vname = key;
            sp.psf = key;
            queue.addLast(sp);
            while (!queue.isEmpty()){
                Pair rp = queue.removeLast();
                if (processed.containsKey(rp.vname)){
                    continue;
                }
                processed.put(rp.vname,true);
                Vertex vtx = vrtcs.get(rp.vname);
                ArrayList<String> nbr = new ArrayList<>(vtx.nbrs.keySet());
                for (String nb : nbr){
                    if(!processed.containsKey(nb)){
                        Pair np = new Pair();
                        np.vname = nb;
                        np.psf = rp.psf + nb;
                        queue.addLast(np);
                    }
                }
            }
        }
        return (flag >=2)?false : true;
    }

    public boolean isTree(){
        return !isCyclic() && isConnected();
    }

    public ArrayList<ArrayList<String>> getCC(){

        ArrayList<ArrayList<String>> ans = new ArrayList<>();
        HashMap<String,Boolean> processed = new HashMap<>();
        LinkedList<Pair> queue = new LinkedList<>();
        ArrayList<String> keys = new ArrayList<>(vrtcs.keySet());
        for (String key : keys){
            if (processed.containsKey(key)){
                continue;
            }
            ArrayList<String> subans = new ArrayList<>();
            Pair sp = new Pair();
            sp.vname = key;
            sp.psf = key;
            queue.addLast(sp);
            while (!queue.isEmpty()){
                Pair rp = queue.removeLast();
                if (processed.containsKey(rp.vname)){
                    continue;
                }
                processed.put(rp.vname,true);
                subans.add(rp.vname);
                Vertex vtx = vrtcs.get(rp.vname);
                ArrayList<String> nbr = new ArrayList<>(vtx.nbrs.keySet());
                for (String nb : nbr){
                    if(!processed.containsKey(nb)){
                        Pair np = new Pair();
                        np.vname = nb;
                        np.psf = rp.psf + nb;
                        queue.addLast(np);
                    }
                }
            }
            ans.add(subans);
        }
        return ans;
    }

//    PRIMS ALGORITHM
//    ALGO
//    1) Make a pair class with vertex name its acquire name(from where it's discovered from) and its edge cost
//    2) Add all the keys(vertex name) of hashmap into vname.key and acqname to null and cost to inf
//    3) Run a loop over heap untill it's empty
//    4) remove pair from heap and hashmap vname
//    5) Check if acqname is null if it's null that mean it is a single vertex hust add it to minimum spanning tree
//       else add a vertex and add edge between vname and acqname
//    6) Run a loop over all the connected vertex of present vname and check if it contains in map or not
//    7) If it is present in map find out old cost and new cost if new cost is small than old cost than update
//       the nbrs pair vname and cost to new vname and cost which is lesser
//    8) Heapify the heap
//    9) Atlast return the minimum spanning tree

    private class PrimPair implements Comparable<PrimPair>{
        String vname;
        String acqname;
        int cost;

        @Override
        public int compareTo(PrimPair o){
            return o.cost - this.cost;
        }
    }

    public Graph prim(){
        Graph mst = new Graph();
        HashMap<String,PrimPair> map = new HashMap<>();
        PriorityQueue<PrimPair> heap = new PriorityQueue<>();

        //make a pair and put in heap and map
        for (String key : vrtcs.keySet()){
            PrimPair np = new PrimPair();
            np.vname = key;
            np.acqname = null;
            np.cost = Integer.MAX_VALUE;
        }

       //till the heap gets empty
        while (!heap.isEmpty()){
            PrimPair rp = heap.poll();
            map.remove(rp.vname);

            //add to minimum spanning tree
            if (rp.acqname==null){
                mst.addVertex(rp.vname);
            }else {
                mst.addVertex(rp.vname);
                mst.addEdge(rp.vname,rp.acqname,rp.cost);
            }

            //nbrs
            for (String nbrs : vrtcs.get(rp.vname).nbrs.keySet()){

                //work for nbrs which are in heap
                if (map.containsKey(nbrs)){

                    //get the old cost and new cost
                    int oc = map.get(nbrs).cost;
                    int nc = vrtcs.get(rp.vname).nbrs.get(nbrs);

                    //update the vname and cost if new cost is less than old cost
                    if (nc < oc){
                        PrimPair gp = map.get(nbrs);
                        gp.vname = rp.vname;
                        gp.cost = nc;
                        //we have to Heapify the generic heap which is used in this question (sec heap)
                        //48min
                    }
                }
            }
        }
        return mst;
    }

    private class DijikstraPair implements Comparable<DijikstraPair>{
        String vname;
        String psf;
        int cost;

        @Override
        public int compareTo(DijikstraPair o){
            return o.cost - this.cost;
        }
    }

    public HashMap<String,Integer> dijikstra(String src){
        HashMap<String,Integer> ans = new HashMap<>();
        HashMap<String,DijikstraPair> map = new HashMap<>();
        PriorityQueue<DijikstraPair> heap = new PriorityQueue<>();

        //make a pair and put in heap and map
        for (String key : vrtcs.keySet()){
            DijikstraPair np = new DijikstraPair();
            np.vname = key;
            np.psf = "";
            np.cost = Integer.MAX_VALUE;

            if (key.equals(src)){
                np.cost = 0;
                np.psf = key;
            }
        }

        //till the heap gets empty
        while (!heap.isEmpty()){
            DijikstraPair rp = heap.poll();
            map.remove(rp.vname);

            //add to ans map
            ans.put(rp.vname,rp.cost);


            //nbrs
            for (String nbrs : vrtcs.get(rp.vname).nbrs.keySet()){

                //work for nbrs which are in heap
                if (map.containsKey(nbrs)){

                    //get the old cost and new cost
                    int oc = map.get(nbrs).cost;
                    int nc = rp.cost +  vrtcs.get(rp.vname).nbrs.get(nbrs);

                    //update the vname and cost if new cost is less than old cost
                    if (nc < oc){
                        DijikstraPair gp = map.get(nbrs);
                        gp.psf = rp.psf + nbrs;
                        gp.cost = nc;
                        //we have to Heapify the generic heap which is used in this question (sec heap)
                        //48min Prim section
                    }
                }
            }
        }
        return ans;
    }
}