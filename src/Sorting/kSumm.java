package Sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class kSumm {
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

    public static void main (String[] args) {
        FastReader s=new FastReader();
        int t = s.nextInt();

        while(t-->0){
            int n = s.nextInt();
            int k = s.nextInt();
            int arr[] = new int[n];
            for(int i=0;i<n;i++){
                arr[i]=s.nextInt();
            }
            Arrays.sort(arr);
            int sum=0;
            for(int i=0;i<k;i++){
                sum += arr[i];
            }
           System.out.println(sum);
        }
    }
}
