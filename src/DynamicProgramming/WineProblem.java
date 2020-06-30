package DynamicProgramming;

public class WineProblem {
    public static void main(String[] args){
        int wines[] = {2,3,5,1,4};
        int year = 1;
        int len = wines.length;
        int dp[][] = new int[100][100];
        System.out.println(profit(wines,0,len-1,year,dp));
    }

    public static int profit(int wines[],int i,int j,int year,int dp[][]){
        if(i>j){
            return 0;
        }

        if(dp[i][j] != 0){
            return dp[i][j];
        }

        int option1 = wines[i]*year+profit(wines,i+1,j,year+1,dp);
        int option2 = wines[j]*year+profit(wines,i,j-1,year+1,dp);

        int ans = Math.max(option1,option2);

        return dp[i][j] = ans;
    }
}
