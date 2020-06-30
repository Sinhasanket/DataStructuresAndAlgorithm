package BitMagic;

import java.util.Scanner;

public class MaximumAndValue {
    public static int maxAND (int arr[], int n) {
        int res = 0, count;
        for (int bit = 31; bit >= 0; bit--) {
            count = checkBit(res | (1 << bit),arr,n);
            if ( count >= 2 )
                res |= (1 << bit);
        }

        return res;
    }
    public static int checkBit(int pattern, int arr[], int n) {
        int count = 0;
        for (int i = 0; i < n; i++)
            if ((pattern & arr[i]) == pattern)
                count++;
        return count;
    }
    public static void main(String[] args){
        Scanner sc =new Scanner(System.in);
        int n = sc.nextInt();
        int arr[]=new int[n];
        for (int i=0;i<n;i++)arr[i]=sc.nextInt();
        System.out.println(maxAND(arr,n));
    }
}
