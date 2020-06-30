package Recursion;

import java.util.Scanner;

public class Factorial {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
      //  int n = sc.nextInt();
        //int ans = fact(n);
        //System.out.println(ans);
        //System.out.println(fib(n));
        System.out.println(power(2,5));

    }

    public static int fact(int n){
        if (n==1)return n;
        int ans = n*fact(n-1);
        return ans;
    }

    public static int fib(int n){
        if (n==0 || n==1)return n;
         int ans = fib(n-1)+fib(n-2);
         return ans;
    }

    public static int power(int x,int n){
        if (n==0)return 1;
        int ans = x*power(x,n-1);
        return ans;

    }
}
