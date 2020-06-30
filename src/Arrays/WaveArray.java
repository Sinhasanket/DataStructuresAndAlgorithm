package Arrays;//lexicographical order

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class WaveArray {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());

        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            int arr[] = new int[n];
            String inputLine[] = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }
            convertToWave(arr, n);

            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < n; i++)
                sb.append(arr[i] + " ");

            System.out.println(sb);
        }
    }

    public static void convertToWave(int arr[],int n){
        for(int i=0;i<n-1;i+=2){
            swap(arr,i,i+1 );
        }
    }

    public static void swap(int arr[],int start,int end ){
        int temp=arr[end];
        arr[end]=arr[start];
        arr[start]=temp;
    }
}
