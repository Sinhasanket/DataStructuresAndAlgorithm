package DynamicProgramming;

import java.util.Scanner;

//You are provided an integers N. You need to count all possible distinct binary strings of length N such
// that there are no consecutive 1’s.

public class CountNumOfBinaryString {
    public static void main(String[] args){
      Scanner sc = new Scanner(System.in);
      int t = sc.nextInt();
      while(t-->0){
          int n = sc.nextInt();
        //  System.out.println(recursiveCount(n));
          System.out.println(fibonacci(n));
      }
    }

    public static int recursiveCount(int n,int last_digit){
        if(n==1) return 2;

        if(last_digit==0){
          return   recursiveCount(n-1,1)+recursiveCount(n-1,0);
        }else {
          return recursiveCount(n-1,0);
        }
    }

    //BY observation we can simply use fibonacci series to solve this
    public static int fibonacci(int n){
       int dp[]= new int[n+1];
       dp[0] = 1;
       dp[1] = 2;
       for(int i=2;i<=n;i++){
           dp[i] = dp[i-1] + dp[i-1];
       }
       return dp[n];
    }
}

//input
//2
//2
//3
//output
//3
//5