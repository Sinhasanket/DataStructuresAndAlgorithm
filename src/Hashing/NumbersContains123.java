package Hashing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

//Given an array arr[] of N numbers. The task is to print only those numbers whose digits are from set {1,2,3}.
public class NumbersContains123 {
    public static boolean ok(int n){
        while(n!=0){
            if(!(n%10==1||n%10==2||n%10==3)){
                return false;
            }
            n=n/10;
        }
        return true;
    }

    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc=Integer.parseInt(br.readLine());
        while(tc-->0){
            int n=Integer.parseInt(br.readLine());
            String line = br.readLine();
            String[] strs = line.trim().split("\\s+");
            int arr[] = new int[n];
            for (int i = 0; i < n; i++)
                arr[i] = Integer.parseInt(strs[i]);
            Arrays.sort(arr);
            List<Integer> m=new ArrayList<Integer>();
            StringBuffer str = new StringBuffer();
            boolean joy=true;
            for(int y=0;y<n;y++){
                int a=arr[y];
                if(ok(a)==true){
                    joy=false;
                    str.append((a)+" ");}
            }
            if(joy==false)
                System.out.println(str);
            else
                System.out.println("-1");
        }
    }
}

//        Input:
//        3
//        3
//        4 6 7
//        4
//        1 2 3 4
//        5
//        12 111 34 13 55
//
//        Output:
//        -1
//        1 2 3
//        12 13 111