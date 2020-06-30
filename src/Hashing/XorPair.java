package Hashing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

//Given an array of positive element having size N and an integer C. Check if there exists a pair (A,B) such that A xor B = C.

public class XorPair {
    public static boolean XORPair(int arr[], int n, int c){
        Set<Integer> st = new HashSet<Integer>();
        for(int i=0; i<n; i++){
            st.add(arr[i]);
        }
        boolean flag = false;
        for(int i=0; i<n && !flag; i++){
            if(st.contains(arr[i]^c))flag = true;
        }
        if(flag)return true;
        return false;
    }

    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while(t-->0){
            String inputLine[] = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);
            int k = Integer.parseInt(inputLine[1]);
            int[] arr = new int[n];
            inputLine = br.readLine().trim().split(" ");
            for(int i=0; i<n; i++){
                arr[i] = Integer.parseInt(inputLine[i]);
            }
            if(XORPair(arr, n, k)){
                System.out.println("Yes");
            } else {
                System.out.println("No");
            }
        }
    }
}
//        Input
//        2
//        7 7
//        2 1 10 3 4 9 5
//        5 1
//        9 9 10 10 3
//
//        Output:
//        Yes
//        No