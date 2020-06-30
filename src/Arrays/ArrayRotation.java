package Arrays;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ArrayRotation {
    public static void main(String args[] ) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int test= Integer.parseInt(br.readLine());
        while(test-->0){
            String str = br.readLine();
            String strr[] =str.split(" ");
            int n= Integer.parseInt(strr[0]);
            int d= Integer.parseInt(strr[1]);
            int arr[] = new int[n];
            String input = br.readLine();
            String inputs[]= input.split(" ");
            for(int i=0;i<n;i++){
                arr[i]=Integer.parseInt(inputs[i]);
            }
            rotate(arr,d,n);

            StringBuffer sb = new StringBuffer();
            for(int j=0;j<n;j++){
                sb.append(arr[j]+" ");
            }
            System.out.println(sb);
        }
    }
    public static void rotate(int arr[],int d,int n){
        reverse(arr,0,d-1);
        reverse(arr,d,n-1);
        reverse(arr,0,n-1);
    }

    public static void reverse(int arr[],int start,int end){
        while(start<=end){
            int temp=arr[end];
            arr[end]=arr[start];
            arr[start]=temp;
            start++;
            end--;
        }
    }

}