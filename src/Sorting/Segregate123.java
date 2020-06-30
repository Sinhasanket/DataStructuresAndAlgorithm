package Sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Segregate123 {

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
        int t = in.nextInt();
        while(t-->0){
            int n = in.nextInt();
            int arr[] = new int[n];
            for(int i=0;i<n;i++){
                arr[i]=in.nextInt();
            }
            System.out.println();
            segragate012(arr,n);

            for(int i=0;i<n;i++){
                System.out.print(arr[i]+" ");
            }
        }
    }

    public static void segragate012(int A[], int n) {
        int start = 0, mid = 0, end = n-1, temp;
        while (mid <= end) {
            switch (A[mid]) {
                case 0:
                    temp = A[mid];
                    A[mid] = A[start];
                    A[start] = temp;
                    start++;
                    mid++;
                    break;

                case 1:
                    mid++;
                    break;

                case 2:
                    temp = A[end];
                    A[end] = A[mid];
                    A[mid] = temp;
                    end--;
                    break;
            }
        }
    }
}
//input
//2
//5
// 0 2 1 2 0
//3
// 0 1 0
//output
// 0 0 1 2 2
//
//0 0 1

