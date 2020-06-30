package DynamicProgramming;

import java.util.Scanner;

public class MinStepsToOne {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        System.out.println(findMin(num));
    }

    // to find min step to reach one if n is divisible by 3 we can take 3 steps if
    // n is divisible by 2 we can take 2 steps else 1.

    public static int findMin(int num){
        int dp[] = new int[100];
        dp[1] = 0;
        for(int i=2;i<=num;i++){
            int option1=Integer.MAX_VALUE,option2=Integer.MAX_VALUE,option3=Integer.MAX_VALUE;
            if(num%2==0){
                option1 = dp[i/2];
            }
            if(num%3==0){
                option2 = dp[i/3];
            }
            option3 = dp[i-1];

            dp[i] = Math.min(Math.min(option1,option2 ),option3)+1;
        }

        return dp[num];
    }
}
