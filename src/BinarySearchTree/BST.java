package BinarySearchTree;

class BinarySTree {
    private static class Node{
        int data;
        Node left;
        Node right;
    }

    private Node root;

    public BinarySTree(int arr[]){
        this.root = construct(arr,0,arr.length-1);
    }

    private static Node construct(int arr[],int low,int high){
        if (low > high)return null;
        int mid = (low+high)/2;
        Node newNode = new Node();
        newNode.data = arr[mid];
        newNode.left = construct(arr,low,mid-1);
        newNode.right = construct(arr,mid+1,high);
        return newNode;
    }

    public void display(){
        System.out.println("==================");
        display(this.root);
        System.out.println("==================");
    }

    private void display(Node root){
        if (root==null)return;
        String str="";
        if (root.left==null){
            str+=". ";
        }else{
            str += root.left.data;
        }
        str +=" -> " +root.data+" <- ";
        if (root.right==null){
            str+=".";
        }else{
            str += root.right.data;
        }
        System.out.println(str);

        display(root.left);
        display(root.right);
    }

    public boolean find(int item){
        return find(this.root,item);
    }

    private boolean find(Node root,int item){
        if (root==null)return false;
        if(item > root.data){
            return find(root.right,item);
        }else if(item < root.data){
            return find(root.left,item);
        }else return true;
    }

    public int max(){
        return max(this.root);
    }

    private int max(Node node){
        if (node.right==null)return node.data;
        return max(node.right);
    }

    public void add(int item){
        add(this.root,item);
    }

    private void add(Node node, int item){
        if (item > node.data){
            if (node.right == null){
                Node nn = new Node();
                nn.data = item;
                node.right = nn;
            }else {
                add(node.right,item);
            }
        }else {
            if (node.left == null){
                Node nn = new Node();
                nn.data = item;
                node.left = nn;
            }else {
                add(node.left,item);
            }
        }
    }

    public void remove(int item){
        remove(this.root,null,false,item);
    }

    private void remove(Node node,Node parent,boolean isLeft,int item){

        if (node==null)return;

        if (item > node.data){
            remove(node.right,node,false,item);
        }else if (item < node.data){
            remove(node.left,node,true,item);
        }else {
            //leaf node confition
            if (node.left==null && node.right==null){
                if (isLeft){
                    parent.left = null;
                }else {
                    parent.right = null;
                }
            } else if(node.left==null && node.right != null){
                if (isLeft){
                    parent.left = node.right;
                }else {
                    parent.right = node.right;
                }
            } else if(node.left!=null && node.right == null){
                if (isLeft){
                    parent.left = node.left;
                }else {
                    parent.right = node.left;
                }
            }else {
                int maxx = max(node.left);
                node.data = maxx;
                remove(node.left,node,true,maxx);

            }
        }
    }
}

public class BST{
    public static void main(String[] args){
        int arr[]={10,20,30,40,50,60,70};
        BinarySTree tree = new BinarySTree(arr);
        tree.display();

        Boolean check = tree.find(30);
        if (check) System.out.println(30+" is Present");
        else System.out.println("Not present");

        System.out.print("Maximum in BST is :");
        System.out.println(tree.max());

        tree.add(55);
        tree.display();

        tree.remove(55);
        tree.display();
    }
}