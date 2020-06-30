package Stack;

import java.util.Scanner;
import java.util.Stack;

public class DeleteMid {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int testcases = sc.nextInt();

        while (testcases-- > 0) {
            int sizeOfStack = sc.nextInt();
            Stack<Integer> myStack = new Stack<>();
            for (int i = 0; i < sizeOfStack; i++) {
                int x = sc.nextInt();
                myStack.push(x);

            }

            if (sizeOfStack == 1) {
                System.out.println(myStack.peek());
            } else {
                 Mid ob = new Mid();
                Stack<Integer> modified = ob.deleteM(myStack, sizeOfStack, 0);
                while (!modified.isEmpty()) {
                    System.out.print(modified.peek() + " ");
                    modified.pop();
                }
                System.out.println();
            }
        }
    }
}

class Mid{
    public Stack<Integer> deleteM(Stack < Integer > s,int sizeOfStack, int current){
        if (current == sizeOfStack / 2) {
            s.pop();
            return s;
        }
        int head = s.peek();
        s.pop();
        current++;
        Stack<Integer> temp = deleteM(s, sizeOfStack, current);
        temp.push(head);
        return temp;
    }
}


//        Input:
//        2
//        5
//        1 2 3 4 5
//        7
//        1 2 3 4 5 6 7
//
//        Output:
//        5 4 2 1
//        7 6 5 3 2 1