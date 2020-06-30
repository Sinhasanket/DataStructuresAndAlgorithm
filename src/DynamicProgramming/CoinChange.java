package DynamicProgramming;

public class CoinChange {
    public static void main(String[] ags){
        int change = 4;
        int[] coins = {1,2,3};
        int dp[] = new int[100];
        System.out.println(minCoins(coins,change,dp,coins.length));
        System.out.println(minCoinsBU(coins,change,coins.length));
        System.out.println(numberOfWays(coins,change));
    }


    //TOP DOWN APPROACH
    static int minCoins(int coins[] , int n,int dp[],int t ){
        if(n==0){
            return 0;
        }

        if(dp[n] != 0 ){
            return dp[n];
        }

        int ans = Integer.MAX_VALUE;

        for(int i=0;i<t;i++){
            if(n-coins[i] >= 0 ){
                int subProblem = minCoins(coins,n-coins[i],dp,t );
                ans =  Math.min(ans,subProblem+1);
            }
        }
        dp[n] = ans;

        return dp[n];
    }


    //BOTTOM UP
    static int minCoinsBU(int coins[] , int n,int t){
         int dp[] = new int[100];
         if(n==0){
             return n;
         }

         for(int i=1;i<=n;i++){
             dp[i] = Integer.MAX_VALUE;
             for(int j=0;j<t;j++){
                 if(i-coins[j] >=0 ){
                     int subprob = dp[i-coins[j]];
                     dp[i] = Math.min(dp[i],subprob+1);
                 }
             }
         }

         return dp[n];
    }


    //NUMBER OF WAYS
    static int numberOfWays(int coins[],int n){
        int dp[] = new int[n+1];
        dp[0] = 1;
        for(int coin:coins ){
            for(int j=0;j<n+1;j++){
                if(j>=coin){
                    dp[j]+=dp[j-coin];
                }
            }
        }
      return dp[n];
    }
}
