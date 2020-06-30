package Stack;

import java.util.LinkedList;
import java.util.Queue;

public class StackUsingQ {
    static Queue<Integer> q1 = new LinkedList<>();
    static Queue<Integer> q2 = new LinkedList<>();

    static int curr_size;

    StackUsingQ() {
        curr_size = 0;
    }

    static void push(int x) {
        curr_size++;

        // Push x first in empty q2
        q2.add(x);

        // Push all the remaining
        // elements in q1 to q2.
        while (!q1.isEmpty()) {
            q2.add(q1.peek());
            q1.remove();
        }

        // swap the names of two queues
        Queue<Integer> q = q1;
        q1 = q2;
        q2 = q;
    }

    static void pop(){

        // if no elements are there in q1
        if (q1.isEmpty())
            return ;
        q1.remove();
        curr_size--;
    }

    static int top() {
        if (q1.isEmpty())
            return -1;
        return q1.peek();
    }

    static int size() {
        return curr_size;
    }

public static void main(String[] args) {
        StackUsingQ s = new StackUsingQ();
        s.push(1);
        s.push(2);
        s.push(3);

        System.out.println("current size: " + s.size());
        System.out.println(s.top());
        s.pop();
        System.out.println(s.top());
        s.pop();
        System.out.println(s.top());

        System.out.println("current size: " + s.size());
    }
}


//USING ONLY ONE QUEUE
//Queue<Integer> q1 = new LinkedList<Integer>();

    /*The method pop which return the element poped out of the stack*/
//    int pop(){
//     if (q1.isEmpty())
//            return -1;
//        int size = q1.size();
//        for (int i = 0; i < size - 1; i++)
//            q1.add(q1.poll());
//        return q1.poll();
//    }
//
//    /* The method push to push element into the stack */
//    void push(int a){
//        q1.add(a);
//    }