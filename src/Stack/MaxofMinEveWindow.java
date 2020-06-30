package Stack;

import java.util.Stack;

public class MaxofMinEveWindow {
   // static int arr[] = {10, 20, 30, 50, 10, 70, 30};
   static int arr[] = {10, 20 ,30, 50 ,10 ,70 ,30};
    static void printMaxOfMin(int n) {
        Stack<Integer> s = new Stack<>();

        int left[] = new int[n+1];
        int right[]  = new int[n+1];

        for (int i=0; i<n; i++) {
            left[i] = -1;
            right[i] = n;
        }

        for (int i=0; i<n; i++) {
            while (!s.empty() && arr[s.peek()] >= arr[i])
                s.pop();

            if (!s.empty())
                left[i] = s.peek();

            s.push(i);
        }

        while (!s.empty())
            s.pop();

        for (int i = n-1 ; i>=0 ; i-- ) {
            while (!s.empty() && arr[s.peek()] >= arr[i])
                s.pop();

            if(!s.empty())
                right[i] = s.peek();

            s.push(i);
        }

        int ans[] = new int[n+1];
        for (int i=0; i<=n; i++)
            ans[i] = 0;

        for (int i=0; i<n; i++) {
            int len = right[i] - left[i] - 1;
            ans[len] = Math.max(ans[len], arr[i]);
        }

        for (int i=n-1; i>=1; i--)
            ans[i] = Math.max(ans[i], ans[i+1]);

        for (int i=1; i<=n; i++)
            System.out.print(ans[i] + " ");
    }

    public static void main(String[] args) {
        printMaxOfMin(arr.length);
    }
}

//        2
//        7
//        10 20 30 50 10 70 30
//        3
//        10 20 30
//
//        Output:
//        70 30 20 10 10 10 10
//        30 20 10