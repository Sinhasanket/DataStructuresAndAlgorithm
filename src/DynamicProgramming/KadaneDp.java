package DynamicProgramming;

import java.util.Scanner;

public class KadaneDp {

    public static void main (String[] args) {
        Scanner sc=new Scanner(System.in);
        int testcases=sc.nextInt();
        while(testcases-->0) {
            int sizeOfArray=sc.nextInt();
            int arr[]=new int[sizeOfArray];

            for(int i=0;i<sizeOfArray;i++) {
                int x=sc.nextInt();
                arr[i]=x;
            }

            System.out.println(maximumSum(arr,sizeOfArray));
        }
    }

    static public long maximumSum(int arr[], int sizeOfArray) {
        long  dp[]=new long[sizeOfArray];
        dp[0]=arr[0];
        long  answer=arr[0];
        for(int i=1;i<sizeOfArray;i++) {
            //The maximum sum at dp[i] will be max of (current array element+dp[i-1]) and (current array element)
            //Complete this code
            dp[i] = Math.max(arr[i]+ dp[i-1], arr[i]);
            answer=Math.max(answer,dp[i]);
        }

        for(int i=0;i<sizeOfArray;i++) {
            System.out.print(dp[i]+" ");
        }
        System.out.println();

        return answer;
    }
}


//        Input:
//        2
//        6
//        5 -2 -3 32 -5 65
//        5
//        -9 -8 8 3 -4
//
//        Output:
//        5 3 0 32 27 92
//        92
//        -9 -8 8 11 17
//        11