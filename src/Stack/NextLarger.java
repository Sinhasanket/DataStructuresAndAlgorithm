package Stack;

import java.util.Stack;

public class NextLarger {

    public static void printNGE(long[] arr, int n) {
        Stack<Long> s = new Stack<>();
        long nge[] = new long[n];                   // Unordered Map to store all the result
        for (int i = n - 1; i >= 0; i--) {          // Run a loop in reverse order
            if (!s.empty()) {
                while (!s.empty() && s.peek() < arr[i]) { // If Peek element is less than curr element then it
                    s.pop();                              // can't be the next greater element, so pop it.
                }
            }
            nge[i] = s.empty() ? -1 : s.peek();   // If some element exist in stack then the top element is next
            s.push(arr[i]);                       // greater element. Push the current element to stack.
        }
        for(int i = 0; i < n; i++) {
            System.out.print(nge[i]+" ");
        }

    }

    public static void main(String[] args) {
            long arr[] = { 11, 13, 21, 3 };
            int n = arr.length;
            printNGE(arr, n);
        }
}

//NAIVE SOLUTION

//    static void printNGE(int arr[], int n)
//    {
//        int next, i, j;
//        for (i=0; i<n; i++)
//        {
//            next = -1;
//            for (j = i+1; j<n; j++)
//            {
//                if (arr[i] < arr[j])
//                {
//                    next = arr[j];
//                    break;
//                }
//            }
//            System.out.print(next+" ");
//        }