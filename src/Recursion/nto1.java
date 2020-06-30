package Recursion;

import java.util.Scanner;

public class nto1 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
      //  int n = sc.nextInt();
      //  printnto1(n);
     //   System.out.println();
        //print1ton(n);
       // System.out.println();
        //printftob(n);
       // System.out.println();
//        printskip(n);
        printpattern(5,1,1);
    }
    public static void printnto1(int num){
        if (num<1)return;
        System.out.println(num);
        printnto1(num-1);
    }
    public static void print1ton(int num){
        if (num<1)return;
        print1ton(num-1);
        System.out.println(num);
    }
    public static void printftob(int num){
        if (num<1)return;
        System.out.println(num);
        printftob(num-1);
        System.out.println(num);
    }

    public static void printskip(int num){
        if (num<1)return;
//        System.out.println(num);
//        printskip(num-2);
//        if (num < 5)
//        System.out.println(num+1);
        if (num%2 != 0) System.out.println(num);
        printskip(num-1);
        if (num%2==0) System.out.println(num);
    }

    public static void printpattern(int n,int row,int col){
        if (row > n)return;
        if (col > row){
            System.out.println();
            printpattern(n,row+1,1);
            return;
        }
        System.out.print("* ");
        printpattern(n,row,col+1);
    }
}
