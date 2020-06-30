package DynamicProgramming;

import java.util.Arrays;
import java.util.Scanner;

public class LongestIncreasingSubseq {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[]=new int[n];
        for (int i=0;i<n;i++)arr[i]=sc.nextInt();
        System.out.println(findLIS(arr,n));
        System.out.println(findLISOptim(arr,n));
    }

    //this one takes O(n^2) time
    public static int findLIS(int arr[],int n){
        int lis[]=new int[n+1];
        Arrays.fill(lis,1);
        for (int i=1;i<n;i++){
            for (int j=0;j<i;j++){
                if (arr[i] > arr[j] && lis[i] <= lis[j]+1){
                    lis[i] = lis[j]+1;
                }
            }
        }
        int max = 0;
        for (int find : lis){
            if (find > max)max=find;
        }
        return max;
    }

    //this one takes O(nlogn) time it uses binary Search
    public static int findLISOptim(int arr[],int n){
        //we can use arraylist here to save some space
        int tail[]=new int[n];
        tail[0]=arr[0];
        int length=1;
        for (int i=1;i<n;i++){
            if (arr[i] > tail[length-1]){
                tail[length] = arr[i];
                length++;
            }else {
                int search = findCeil(tail,0,length-1,arr[i]);
                tail[search] = arr[i];
            }
        }
        return length;

    }

    //binary search the ceil value
    public static int findCeil(int arr[],int start,int end,int x){
        while (end > start){
            int mid = (start+end) / 2;
            if (arr[mid] >= x){
                end = mid;
            }else {
                start = mid+1;
            }
        }
        return end;
    }
}
