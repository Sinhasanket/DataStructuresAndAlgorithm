package Tree;

class Tree{
//    private static Node{
//        int data;
//        Node left;
//        Node right;
//    }
//    private Node root=null;
//
//    Tree(){
//        Scanner sc = new Scanner(System.in);
//        this.root =  construct(this.root,sc,sc,-1);
//    }
//
//    public Node construct(Node node,Scanner sc,Scanner sc,int init){
//        if(node==null)return null;
//        Node newNode = new Node();
//        newNode.data = sc.nextInt();
//        int childs = sc.nextInt();
//        if(init > 0){
//            childs--;
//            init = childs;
//            newNode.left =  construct(node.left,sc,sc,init);
//            if(init != 0)
//                newNode.right = construct(node.right,sc,sc,init);
//        }
//    }
//
//    public int levelSum(int k){
//        return levelSum(this.root,k,0,0);
//    }
//
//    private int levelSum(Node node,int k,int iniL,int iniR){
//        LinkedList<Node> queue = new LinkedList<>();
//        int ans = 0;
//        queue.add(this.root);
//        while(!queue.isEmpty()){
//            Node remo = queue.removeFirst();
//            if(remo.left != null){
//                if(iniL==k){
//                    ans+=remo.left.data;
//                    iniL = 0;
//                }
//                iniL++;
//                queue.addLast(remo.left);
//            }else if(remo.right != null){
//                if(iniR==k){
//                    ans+=remo.right.data;
//                    iniR = 0;
//                }
//                iniR++;
//                queue.addLast(remo.right);
//            }
//        }
//        return ans;
//    }
}

public class SumatlevelK {
    public static void main(String args[]) {
//        Scanner sc = new Scanner(System.in);
//        Tree binary=new Tree();
//        int z = 0;
//        while(true){
//            if(sc.hasNext()==false)break;
//            binary = new Tree();
//        }
//        System.out.println(binary.levelSum(sc.nextInt()));
    }
}