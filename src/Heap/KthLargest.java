package Heap;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class KthLargest {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while(t-- > 0)
        {
            int n = sc.nextInt();
            int k = sc.nextInt();

            int arr[] = new int[n];

            for(int i = 0; i<n; ++i)
                arr[i] = sc.nextInt();

            System.out.println(KthLargest(arr, n, k));

        }

    }
    public static int KthLargest(int arr[], int n, int k){
        Queue<Integer> pq= new PriorityQueue<>();

        for(int i = 0; i < n; i++){
            if(pq.size() == k && pq.peek() < arr[i]){

                pq.poll();
                pq.add(arr[i]);
            }
            else if(pq.size() < k)
                pq.add(arr[i]);
        }
        return pq.peek();

    }
}

//        Input:
//        2
//        5 3
//        3 5 4 2 9
//        5 5
//        4 3 7 6 5
//
//        Output:
//        4
//        3
