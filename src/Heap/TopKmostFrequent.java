package Heap;

import java.util.ArrayList;
import java.util.Scanner;

public class TopKmostFrequent {
    static ArrayList<Integer> data = new ArrayList<>();

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int t  = sc.nextInt();
        while(t-->0){
            int n = sc.nextInt();
            int k = sc.nextInt();

            int arr[] =new int[n];
            int freq[]=new int[n+1];
            for(int i=0;i<n;i++){
                arr[i]=sc.nextInt();
            }
            for (int i=0;i<n;i++){
                freq[arr[i]]++;
            }



        }
    }
}
