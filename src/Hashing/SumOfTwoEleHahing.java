package Hashing;

//You are given an array A[] of size N, and you are also given a sum. You need to
//find if two numbers in A exists that have sum equal to the given sum.

import java.util.HashMap;
import java.util.Scanner;

public class SumOfTwoEleHahing {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);

        int testcases = sc.nextInt();
        while(testcases-- > 0) {
            int sizeOfArray = sc.nextInt();
            int arr[] =  new int[sizeOfArray];

            for(int i = 0; i < sizeOfArray; i++)
                arr[i] = sc.nextInt();

            int sum = 0;
            sum = sc.nextInt();


            System.out.println(sumExists(arr, sizeOfArray, sum));
        }
    }

    public static int sumExists(int arr[], int n, int sum) {
        HashMap<Integer,Integer> h=new HashMap<>();
        for(int i : arr)
            if(!h.containsKey(i))
                h.put(i,1);
            else
                h.put(i, h.get(i)+1);

        for(int i : h.keySet()){
            int curr=i;
            int remain=sum-curr;
            if(h.containsKey(remain)){
                if(curr != remain)
                    return 1;
                else{
                    if(h.get(remain)>1)
                        return 1;
                }
            }
        }
        return 0;
    }
}

//       Input:
//        1
//        10
//        1 2 3 4 5 6 7 8 9 10
//        14
//        Output:
//        1