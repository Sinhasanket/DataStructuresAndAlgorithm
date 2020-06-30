package Recursion;

public class Firstindex {
    public static void main(String[] args){
        int arr[]={3,8,1,8,8,7};
        int find = 8;
       // System.out.println(firstIndex(arr,0,find));
       // System.out.println(lastIndex(arr,0,find));
    }

    public static int firstIndex(int arr[],int si,int find){
        if (si==arr.length)return -1;
        if (arr[si]==find)return si;
        else return firstIndex(arr,si+1,find);
    }

    public static int lastIndex(int arr[],int si,int find){
        if (si==arr.length)return -1;
        int index = lastIndex(arr,si+1,find);
        if (index==-1){
            if (arr[si]==find) return si;
            else  return -1;
        }else return index;
    }
}
