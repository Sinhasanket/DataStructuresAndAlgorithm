package Searching;
//some bugs

public class InfiniteArrayEle {
    public static void main(String[] args){
        int arr[] = {1,2,3,50,55,100,200,222,234,250,300,350,400,450,500,550,552,553};
        int x = 350;
        int ans = findEle(arr,x);
        if (ans==-1) System.out.println("element not found");
        else System.out.println("element found at : "+ans);
    }

    public static int findEle(int arr[],int x){

        int l = 0,h=1;
        int val = arr[0];

        while (val < x){
            l=h;
            if(2*h < arr.length-1)
                h = 2*h;
            else
                h = arr.length-1;
            val = arr[h];
        }

        return binarySearch(arr,l,h,x);
    }

    public static int binarySearch(int arr[],int left,int right,int x){
        while (left<=right){
            int mid = left+(right-left)/2;
            if (arr[mid]==x) {
                return mid;
            }
            else if(arr[mid] > x){
                right = mid-1;
            } else{
                left = mid+1;
            }
        }
        return -1;
    }
}
