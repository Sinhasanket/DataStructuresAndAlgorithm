package Arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MaxOccuredElementInRange {

    public static void main (String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim()); //Inputting the testcases
        while(t-->0){
            int n = Integer.parseInt(br.readLine().trim());
            int L[] = new int[n];
            int R[] = new int[n];
            String inputLine[] = br.readLine().trim().split(" ");
            for(int i=0; i<n; i++){
                L[i]=Integer.parseInt(inputLine[i]);
            }
            inputLine = br.readLine().trim().split(" ");
            for(int i=0; i<n; i++){
                R[i]=Integer.parseInt(inputLine[i]);
            }
            System.out.println(maxOccured(L, R, n));
        }
    }

    static int max = 1000000;
    public static int maxOccured(int L[], int R[], int n){
        int arr[]= new int[max];
        int maxi = -1;
        for(int i=0;i<n;i++){
            arr[L[i]]+=1;
            arr[R[i]+1] -=1;
            if(R[i]>maxi){
                maxi=R[i];
            }
        }

        int sum = arr[0];
        int index = 0;
        for(int i=1;i<maxi+1;i++){
            arr[i] += arr[i-1];
            if(sum < arr[i]){
                sum = arr[i];
                index = i;
            }
        }
        return index;
    }
}
