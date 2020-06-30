package DynamicProgramming;

public class EditDistance {
    public static void main(String[] args){
        String s1 =  "horse";
        String s2 =  "ros";
        System.out.println( eDistanceRec(s1,s2));
     //   System.out.println( eDistance(s1,s2));
    }

    public static int eDistance(String s1,String s2){
        int dp[][]=new int[s1.length()+1][s2.length()+1];
        dp[s1.length()][s2.length()]=0;
        for (int i=s1.length()-1;i>=0;i--){
            for (int j=s2.length()-1;j>=0;j--){
                if (i==s1.length()){
                    dp[i][j] = s2.length()-j;
                    continue;
                }
                if (j==s2.length()){
                    dp[i][j] = s1.length()-i;
                    continue;
                }
                if (s1.charAt(i)==s2.charAt(j)){
                    dp[i][j] = dp[i+1][j+1];
                }else {
                    dp[i][j] = Math.min(1+dp[i+1][j+1],1+Math.min(dp[i+1][j],dp[i][j+1]));
                }
            }
        }
        return dp[0][0];
    }

    public int minDistance(String w1, String w2) {
        int dp[][]=new int[w1.length()+1][w2.length()+1];
        for(int i=0;i<=w1.length();i++){
            for(int j=0;j<=w2.length();j++){
                if(i==0 || j==0){
                    dp[i][j] = Math.max(i,j);
                }else{
                    if(w1.charAt(i-1)==w2.charAt(j-1)){
                        dp[i][j] = dp[i-1][j-1];
                    }else{
                        dp[i][j] = 1+Math.min(dp[i-1][j-1],Math.min(dp[i-1][j],dp[i][j-1]));
                    }

                }
            }
        }
        return dp[w1.length()][w2.length()];
    }

    public static int eDistanceRec(String s1,String s2){
        if (s1.length()==0)return s2.length();
        if (s2.length()==0)return s1.length();
        String ros1 = s1.substring(1);
        String ros2 = s2.substring(1);
        int ans=0;
        if (s1.charAt(0)==s2.charAt(0)){
            ans = eDistance(ros1,ros2);
        }else {
            int replace = 1+eDistance(ros1,ros2);
            int add = 1+eDistance(ros1,s2);
            int remove = 1+eDistance(s1,ros2);
            ans = Math.min(replace,Math.min(add,remove));
        }
        return ans;
    }
}
