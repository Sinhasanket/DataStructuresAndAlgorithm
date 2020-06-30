package Searching;

public class OccurenceOfElement {
    public static void main(String a[]){
       int arr[]= new int[]{2, 3, 4, 5, 5, 5, 6, 6};
       int ele = 5;
       int l = firstOcurrence(arr,ele,arr.length);
       int r = lastOccurence(arr,ele,arr.length);
       int ans = (r-l)+1;
       System.out.println(ans);
    }

    static int firstOcurrence(int arr[],int x,int n){
        int left = 0,right = n-1;
        while (left<=right){
            int mid = left+(right-left)/2;
            if (arr[mid]==x && (mid==0 || arr[mid-1] != x ))
                return mid;
            else if(arr[mid] >= x)
                right = mid-1;
            else
                left = mid+1;
        }

        return -1;
    }

    static int lastOccurence(int arr[],int x,int n){
        int left = 0,right = n-1;
        while (left<=right){
            int mid = left+(right-left)/2;
            if (arr[mid]==x && (mid==(n-1) || arr[mid+1] != x ))
                return mid;
            else if(arr[mid] > x)
                right = mid-1;
            else
                left = mid+1;
        }
        return -1;
    }
}
