package DynamicProgramming;

public class BoardPath {
    public static void main(String[] args){
         int n = 10;
         int dp[]=new int[n+1];
         System.out.println(countpath(n,0,dp));
    }

    public static int countpath(int end,int curr,int dp[]){
        if (end==curr){
            return 1;
        }

        if (curr > end){
            return 0;
        }

        if (dp[curr] != 0){
            return dp[curr];
        }
        int count=0;
        for (int dice=1;dice<=6;dice++){
            count+=countpath(end,curr+dice,dp);
        }
        dp[curr] = count;
        return count;
    }

    public static int countpathIt(int end){
        int dp[]=new int[end+1];
        dp[end]=1;
        for (int i=end-1;i>=0;i--){
            int count=0;
            for (int dice=1;dice<=6 && dice+i < dp.length;dice++){
                count+=dice+i;
            }
            dp[i] = count;
        }
        return dp[0];
    }
}
