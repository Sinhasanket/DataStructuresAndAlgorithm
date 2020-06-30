package Sorting;

//sort array with  0,1,2
public class DutchNationalFlag {
    public static void main(String[] args){
        int arr[] = {0,2,1,2,0,1,0,1};
        //if arr[mid]==0 swap element at low and mid and increment low and mid
        //if arr[mid]==1 increase mid only
        //else swap high and mid element and decrese high

        int low=0,mid=0,high= arr.length-1;
        while (mid<=high){
            if (arr[mid]==1){
                mid++;
            }else if (arr[mid]==0){
                int temp = arr[low];
                arr[low] = arr[mid];
                arr[mid] = temp;
                low++;mid++;
            }else {
                int temp = arr[high];
                arr[high] = arr[mid];
                arr[mid] = temp;
                high--;
            }
        }
        for (int s : arr) System.out.print(s+" ");
    }
}
