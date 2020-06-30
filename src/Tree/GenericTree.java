package Tree;

import java.util.ArrayList;
import java.util.Scanner;

class Generic {

    private  class Node{
        int data;
        ArrayList<Node> children;
        Node(int data){
            this.data=data;
            this.children = new ArrayList<>();
        }
    }

    private Node root;
    private int size;

    Generic(){
        Scanner sc = new Scanner(System.in);
        this.root=takeInput(sc,null,0);
    }

    private Node takeInput(Scanner sc, Node parent, int ithChild){
          if (parent==null){
              System.out.println("Enter the data for root node :");
          }else {
              System.out.println("Enter the data for "+ithChild+"th child of "+parent.data);
          }

          int newdata = sc.nextInt();
          Node node = new Node(newdata);
          this.size++;

        System.out.println("Enter the number of child for "+node.data);
        int children = sc.nextInt();
        for (int i=0;i<children;i++){
            Node child=this.takeInput(sc,node,i);
            node.children.add(child);
        }
        return node;
    }

    public void display(){
        this.display(this.root);
    }

    private void display(Node node){
         String nod = node.data+" => ";
         for (int i=0;i<node.children.size();i++){
            nod += node.children.get(i).data+", ";
         }
         nod +="End";
        System.out.println(nod);
        for (int i=0;i<node.children.size();i++){
            this.display(node.children.get(i));
        }
    }
}

public class GenericTree{
    public static void main(String[] args){
       Generic tree = new Generic();
       tree.display();
    }
}
