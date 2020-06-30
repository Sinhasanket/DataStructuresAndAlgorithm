package DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class RobotPathCodeChef {
    static int MOD = 1000000007;
    public static void main(String[] args) throws IOException{
        FastReader sc = new FastReader();
        int m = sc.nextInt();
        int n = sc.nextInt();
        int p = sc.nextInt();
        int dp[][]=new int[1001][1001];
        for (int i=0;i<p;i++){
            int x = sc.nextInt();
            int y = sc.nextInt();
            dp[x-1][y-1] = -1;
        }
        System.out.println(solve(m,n,dp));
    }

    public static int solve(int m,int n,int dp[][]){
        if (dp[0][0]==-1)return 0;
        for (int i=0;i<n;i++){
            if (dp[0][i]==-1)break;
            dp[0][i]=1;
        }
        for (int i=0;i<m;i++){
            if (dp[i][0]==-1)break;
            dp[i][0]=1;
        }

        for (int i=1;i<m;i++){
            for (int j=1;j<n;j++){
                if (dp[i][j]==-1)continue;
                dp[i][j]=0;
                if (dp[i][j-1] != -1){
                    dp[i][j] = dp[i][j-1]%MOD;
                }
                if (dp[i-1][j] != -1){
                    dp[i][j] =(dp[i][j]+dp[i-1][j])%MOD;
                }
            }
        }
        if (dp[m-1][n-1]==-1)return 0;
        else return dp[m-1][n-1];
    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new
                    InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }
        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
}
