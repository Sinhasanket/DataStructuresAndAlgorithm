package Recursion;

public class ArraySortedorNot {
    public static void main(String[] args){
       // Scanner sc = new Scanner(System.in);
        int arr[]={3,8,1,6,9,7};
        //int arr[]={1,2,3,4,5,6};
        int index = 0;
        System.out.println(isSorted(arr,index,arr.length-1));
    }

    public static boolean isSorted(int arr[],int si,int len){
        if (si>len-1)return true;
       // System.out.println(arr[si]+" "+arr[len]);
        if (arr[si] > arr[si+1]) return false;
        else return isSorted(arr,si+1,len);
    }
}
