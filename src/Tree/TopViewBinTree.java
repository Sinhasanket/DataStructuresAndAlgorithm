package Tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TopViewBinTree {
  static class Node {
        int data, hd;
        Node left, right;
        public Node(int data) {
            this.data = data;
            left = right = null;
        }
    }

    public static void main(String args[])throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(read.readLine());

        while(tc-->0){

            int n = Integer.parseInt(read.readLine());
            Node root = null;
            if(n==0){
                System.out.println();
                continue;
            }
            int k = 0;
            String str[] = read.readLine().trim().replace("  ", " ").split(" ");

            for(k = 0; k < n*3;){
                int a1 = Integer.parseInt(str[k++]);
                int a2 = Integer.parseInt(str[k++]);

                char ch = str[k++].charAt(0);
                if(root==null){
                    root=new Node(a1);
                    switch(ch){
                        case 'L':root.left=new Node(a2);
                            break;
                        case 'R':root.right=new Node(a2);
                            break;
                    }
                }
                else{
                    insert(root,a1,a2,ch);
                }
            }

            printTopView(root);
            System.out.println();
        }
    }

    public static void insert(Node root,int a1,int a2,char ch){
        if(root==null)
            return;
        if(root.data==a1){
            switch(ch){
                case 'L':root.left=new Node(a2);
                    break;
                case 'R':root.right=new Node(a2);
                    break;
            }
        }
        else{
            insert(root.left,a1,a2,ch);
            insert(root.right,a1,a2,ch);
        }
    }

    static public void printTopView(Node root) {
       if(root==null)
           return;
        //TODO
    }
}


