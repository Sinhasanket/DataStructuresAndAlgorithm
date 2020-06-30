package Arrays;

import java.util.Scanner;

public class PrefixSum {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int len = sc.nextInt();
        int arr[]=new int[len];
        for (int i=0;i<len;i++)arr[i]=sc.nextInt();
        int prefix[]=new int[len];
        prefix[0] = arr[0];
        for (int i=1;i<len;i++){
            prefix[i] = arr[i] + prefix[i-1];
        }
//        for (int i=0;i<len;i++){
//            System.out.print(arr[i]+" ");
//        }
        int q = sc.nextInt();
        while (q-->0){
            int l = sc.nextInt();
            int r = sc.nextInt();
            System.out.println(prefix[r] - prefix[l-1]);
        }

    }
}
