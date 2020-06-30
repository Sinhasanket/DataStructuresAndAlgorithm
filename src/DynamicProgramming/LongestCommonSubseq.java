package DynamicProgramming;

import java.util.Scanner;

public class LongestCommonSubseq {

    public static void main (String[] args) {
        Scanner sc=new Scanner(System.in);
        int test=sc.nextInt();
        while(test-- > 0){
         //   int p=sc.nextInt();
           // int q=sc.nextInt();

            String s1=sc.next();
            String s2=sc.next();

           // System.out.println(lcs(s1, s2));
            PrintStringlcs(s1,s2);
          //  System.out.println(lcsCb(s1, s2));
           // System.out.println(lcsRec(s1,s2));

        }
    }

    static int lcsRec(String s1,String s2){
        if (s1.length()==0 || s2.length()==0)return 0;
        String ros1=s1.substring(1);
        String ros2=s2.substring(1);
        int count=0;
        if (s1.charAt(0)==s2.charAt(0)){
            count = count + 1 + lcsRec(ros1,ros2);
        }else {
            int condition1 = lcsRec(s1,ros2);
            int condition2 = lcsRec(ros1,s2);
            count = Math.max(condition1,condition2);
        }
        return count;
    }

    static int lcsCb(String s1, String s2){
        int m = s1.length();
        int n = s2.length();
        int dp[][] = new int[m+1][n+1];
        for (int i=m-1; i>=0; i--) {
            for (int j=n-1; j>=0; j--) {
                if (i == m || j == n){
                    dp[i][j] = 0;
                    continue;

                }
                if (s1.charAt(i) == s2.charAt(j)) {
                    dp[i][j] = dp[i + 1][j + 1] + 1;
                   // System.out.print(s1.charAt(i));
                }
                else
                    dp[i][j] = Math.max(dp[i+1][j], dp[i][j+1]);
            }
        }
        return dp[0][0];
    }

    static int lcs(String s1, String s2){
        int m = s1.length();int n=s2.length();
        char X[] = s1.toCharArray();
        char Y[] = s2.toCharArray();
        int L[][] = new int[m+1][n+1];
        for (int i=0; i<=m; i++) {
            for (int j=0; j<=n; j++) {
                if (i == 0 || j == 0)
                    L[i][j] = 0;
                else if (X[i-1] == Y[j-1]){
                    L[i][j] = L[i-1][j-1] + 1;
                  //  System.out.print(X[j-1]);
                }
                else
                    L[i][j] = Math.max(L[i-1][j], L[i][j-1]);
            }
        }
        return L[m][n];
    }

    static int recursiveLCS(int m,int n,String s1,String s2){
        if (m==0||n==0) return 0;
        if(s1.charAt(m)==s2.charAt(n)){
            return 1+recursiveLCS(m-1,n-1,s1,s2);
        }else{
            return Math.max( recursiveLCS(m-1,n,s1,s2), recursiveLCS(m,n-1,s1,s2));
        }
    }


    static void PrintStringlcs(String X, String Y) {
        int m = X.length();
        int n = Y.length();
        int[][] L = new int[m+1][n+1];

        for (int i=0; i<=m; i++) {
            for (int j=0; j<=n; j++) {
                if (i == 0 || j == 0)
                    L[i][j] = 0;
                else if (X.charAt(i-1) == Y.charAt(j-1))
                    L[i][j] = L[i-1][j-1] + 1;
                else
                    L[i][j] = Math.max(L[i-1][j], L[i][j-1]);
            }
        }

        int index = L[m][n];
        int temp = index;

        char[] lcs = new char[index+1];
        lcs[index] = ' ';
        int i = m, j = n;
        while (i > 0 && j > 0) {
            if (X.charAt(i-1) == Y.charAt(j-1)) {
                lcs[index-1] = X.charAt(i-1);
                i--;
                j--;
                index--;
            }
            else if (L[i-1][j] > L[i][j-1])
                i--;
            else
                j--;
        }

        for(int k=0;k<=temp;k++)
            System.out.print(lcs[k]);
    }

}

//        Input:
//        2
//        6 6
//        ABCDGH
//        AEDFHR
//        3 2
//        ABC
//        AC
//
//        Output:
//        3
//        2