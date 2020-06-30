package Heap;

import java.util.PriorityQueue;
import java.util.Scanner;

public class MinCostOfRope {

    public static void main (String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while(t-->0) {
            int n = in.nextInt();
            int arr[] = new int[n];

            for(int i = 0; i<n; ++i)
                arr[i] = in.nextInt();

            new solve().minCost(arr, n);
        }
    }
}

class solve{
    void minCost(int arr[], int n){
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i = 0; i<n ;i++)
            pq.add(arr[i]);

        Long cost = new Long("0");
        while(pq.size()!=1){
            int x = pq.poll();
            int y = pq.poll();
            cost += x+y;
            pq.add(x+y);
        }
        System.out.println(cost);
    }
}


//        Input:
//        2
//        4
//        4 3 2 6
//        5
//        4 2 7 6 9
//
//        Output:
//        29
//        62