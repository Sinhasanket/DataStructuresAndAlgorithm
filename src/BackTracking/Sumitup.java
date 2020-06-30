package BackTracking;
//You are given an array of numbers and a target number(T) , print all unique
//combinations in the array whose sum equals the target number T. Note that each number
// in the array may only be used once in the combination.

import java.util.*;
public class Sumitup {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int len = sc.nextInt();
        int arr[]=new int[len];
        for(int i=0;i<len;i++)arr[i]=sc.nextInt();
        int total = sc.nextInt();
        Arrays.sort(arr);
        solve(arr,total,0,"",0);
    }

    public static void solve(int[] denominaion,int totalAmt,int sum,String ans,int lastidx){
        if(sum==totalAmt){
            System.out.println(ans);
            return;
        }
        for(int i=lastidx;i<denominaion.length;i++){
            sum+=denominaion[i];
            if(sum <= totalAmt && (i==lastidx || denominaion[i] != denominaion[i-1])){
                solve(denominaion,totalAmt,sum,ans+denominaion[i]+" ",i+1);
            }
            sum-=denominaion[i];
        }
    }
}

//7
//10 1 2 7 6 1 5
//8


//1 1 6
//1 2 5
//1 7
//2 6