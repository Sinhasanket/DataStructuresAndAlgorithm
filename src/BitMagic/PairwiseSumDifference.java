package BitMagic;

import java.util.Scanner;

public class PairwiseSumDifference {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[]=new int[n];
        for (int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        int sum=0;
        for (int bit=1;bit<33;bit++){
            int ones=0,zeros=0;
            for (int i=0;i<n;i++){
                if ((arr[i] & (1<<(bit-1)))==1<<(bit-1)){
                    ones++;
                }else {
                    zeros++;
                }
            }
            sum+= (2 * ones * zeros)%1000000007;
        }
        System.out.println(sum);
    }
}
