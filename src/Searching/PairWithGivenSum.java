package Searching;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class PairWithGivenSum {

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new
                    InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
    }

    public static void main(String[] args){
        FastReader in = new FastReader();
        int len = in.nextInt();
        int arr[] = new int[len];
        for(int i=0;i<len;i++){
            arr[i]=in.nextInt();
        }
        int x = in.nextInt();
        for(int i=0;i<arr.length;i++){
            if(isPair(arr,arr.length,x)){
                System.out.println("YES");
            }else{
                System.out.println("NO");
            }
        }
    }

    static boolean isPair(int arr[],int n,int x){
        int left=0,right=n-1;
        while(left<=right){
            if(arr[left]+arr[right]==x){
                return true;
            }else if(arr[left]+arr[right]>x){
                right--;
            }else{
                left++;
            }
        }
        return false;
    }
}
