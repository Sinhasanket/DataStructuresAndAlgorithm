package Maths;

import java.util.Scanner;

// n = 5 , k = 2
//* * * I * *  ==> x+y=n

public class StarsAndBars {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-->0){
            long n = sc.nextLong();
            long k = sc.nextLong();
            System.out.println(binomial(n+k-1,k-1));
        }
    }

    public static long binomial(long n,long k){
        long ans=1;
        if (k>n-k)k=n-k;
        for (long i=1;i<=k;i++){
            ans*=(n-i+1);
            ans/=i;
        }
        return ans;

    }
}
