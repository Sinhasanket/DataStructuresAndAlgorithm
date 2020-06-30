package SegmentTree;

import java.util.Scanner;

public class Solve {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int c = sc.nextInt();
        int BIT[]=new int[n+2];
        while (m-->0){
            char ch = sc.next().charAt(0);
            if (ch=='Q'){
                int qry = sc.nextInt();
                System.out.println(getSum(qry,BIT));
            }else {
                int u = sc.nextInt();
                int v = sc.nextInt();
                int k = sc.nextInt();
                construct(u,v,k,BIT,n);
            }
        }
    }

    static void construct(int u,int v,int k,int BIT[],int n){
        for (int i=0;i<v;i++){
            update(i,k,n,BIT);
        }
    }

    static void update(int index,int val,int n,int BIT[]){
        index = index + 1;
        while(index <= n) {
            BIT[index] += val;
            index += index & (-index);
        }
    }

    static int getSum(int index,int BIT[]){
         int sum = 0;
         index++;
         while (index>0){
             sum += BIT[index];
             index -= index & (~index);
         }
         return sum;
    }
}
