package Hashing;

import java.util.HashMap;
//Given an unsorted array arr[] of N integers and a sum. The task is to count the number of subarray which adds to a given number.

public class SubarrayRangeWithGivSum {
    static int findSubarraySum(int arr[], int n, int sum) {
        HashMap<Integer, Integer> prevSum = new HashMap<>();

        int res = 0;
        int currsum = 0;

        for (int i = 0; i < n; i++) {
            currsum += arr[i];

            if (currsum == sum)
                res++;

            if (prevSum.containsKey(currsum - sum))
                res += prevSum.get(currsum - sum);

            Integer count = prevSum.get(currsum);
            if (count == null)
                prevSum.put(currsum, 1);
            else
                prevSum.put(currsum, count+1);
        }
        return res;
    }

    public static void main(String []args){

        int arr[] = { 10, 2, -2, -20, 10 };
        int sum = -10;
        int n = arr.length;
        System.out.println(findSubarraySum(arr, n, sum));
    }
}

//        Input:
//        2
//        5
//        10 2 -2 -20 10
//        -10
//        6
//        1 4 20 3 10 5
//        33
//
//        Output:
//        3
//        1