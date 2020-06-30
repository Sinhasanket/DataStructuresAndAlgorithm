package DynamicProgramming;

import java.util.Scanner;

public class Ncr {

    public static void main(String args[]) {
        Scanner s=new Scanner(System.in);
        int testcase=s.nextInt();
        while(testcase>0) {
            int n=s.nextInt();
            int r=s.nextInt();
            System.out.println(nCrModp(n, r));
            testcase--;
        }
    }

    public static int nCrModp(int n, int r){
        // n!/r!*(n-1)!
        int mod=1000000007;
        int dp[]=new int[r+1];
        dp[0]=1;
        for(int i=1;i<=n;i++){
            for(int j=Math.min(i,r);j>0;j--){
                dp[j]=dp[j]%mod+dp[j-1]%mod;
            }
        }
        return dp[r]%mod;
    }
}

//        Input:
//        2
//        3 2
//        4 2
//        Output:
//        3
//        6