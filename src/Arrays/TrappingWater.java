package Arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TrappingWater {
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
            System.out.println(trapping(arr, n));
        }
    }

    public static int trapping(int arr[],int n){
        int trappedWater=0;
        int leftMax[] = new int[n];
        int rightMax[] = new int[n];

        leftMax[0]=arr[0];
        rightMax[n-1]=arr[n-1];

        for(int i=1;i<n-1;i++){
            if(leftMax[i-1] >= arr[i]){
                leftMax[i]=leftMax[i-1];
            }else{
                leftMax[i]=arr[i];
            }
        }

        for(int i=2;i>=0;i--){
            if(rightMax[i+1] > arr[i]){
                rightMax[i]=rightMax[i+1];
            }else{
                rightMax[i]=arr[i];
            }
            trappedWater += Math.max(Math.min(leftMax[i], rightMax[i]) - arr[i],0);
        }
        return trappedWater;
    }
}