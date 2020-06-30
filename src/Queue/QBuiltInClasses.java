package Queue;

import java.util.LinkedList;
import java.util.Queue;

public class QBuiltInClasses {

    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<>();

        for (int i=0; i<5; i++)
            q.add(i);

        System.out.println("Elements of queue-"+q);

        int removedele = q.remove();
        System.out.println("removed element-" + removedele);

        System.out.println(q);

        int head = q.peek();
        System.out.println("head of queue-" + head);

        int size = q.size();
        System.out.println("Size of queue-" + size);
    }
}


//QUEUE USING LINKEDLIST
// QueueNode front, rear;
//    void push(int a)
//    {
//        // Your code here
//        QueueNode temp=new QueueNode(a);
//
//        if(front==null){
//            front=rear=temp;
//            return;
//        }
//        rear.next=temp;
//        rear=temp;
//    }
//
//    int pop()
//    {
//        // Your code here
//        if(front==null)
//            return -1;
//
//        int x = front.data;
//        front=front.next;
//        return x;
//    }