package Sorting;

//Inplace sorting Algorithm : Bubble,Insertion,Selection,quick
//Not Inplace Sorting Algorithm : Merge

//Merge sort is a divide and conquer Algorithm

public class Merge {
    public static void main(String[] args){
//        int arr1[] = {5,10,15,20,30};
//        int arr2[] = {12,15,17,25,35,40,80,90};
//        int[] mergeIt = merged(arr1,arr2);
//        for (int i=0;i<mergeIt.length;i++) System.out.print(mergeIt[i]+" ");

         int arr[] = {80,9,1,5,55,40,30,47};
        // int print[]=sort(arr,0,arr.length-1);
         //for (int val : print) System.out.print(val+" ");
         quick(arr,0,arr.length-1);
         for (int p : arr) System.out.print(p+" ");
    }

    public static int[] merged(int arr1[],int arr2[]){
        int merg[] = new int[arr1.length+arr2.length];
        int i=0,j=0,k=0;
        while (i<arr1.length && j<arr2.length){
            if (arr1[i] <= arr2[j]){
                merg[k] = arr1[i];
                k++;i++;
            }else{
                merg[k] = arr2[j];
                k++;j++;
            }
        }

        if (i==arr1.length){
            while (j<arr2.length){
                merg[k] = arr2[j];
                k++;j++;
            }
        }

        if (j==arr2.length){
            while (i<arr1.length){
                merg[k] = arr1[i];
                k++;i++;
            }
        }
        return merg;
    }

    public static int[] sort(int arr[],int low,int high){
        if (low==high){
            int ret[] = new int[1];
            ret[0] = arr[low];
            return ret;
        }
        int mid = (low+high)/2;
        int firstHalf[] = sort(arr,low,mid);
        int secondHalf[] = sort(arr,mid+1,high);
        int merge[]=merged(firstHalf,secondHalf);
        return merge;
    }

    //inplace sorting algo
    public static void quick(int arr[],int low,int high){
        //we can take low high and mid any of these as our pivot
        if (low>=high)return;
        int mid = (low+high)/2;
        int pivot = arr[mid];
        int i=low,j=high;
        while (i<=j){
            while (arr[i]<pivot){
                i++;
            }
            while (arr[j]>pivot){
                j--;
            }
            if (i<=j){
                int temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
                i++;j--;
            }
        }
        quick(arr,low,j);
        quick(arr,i,high);
    }
}
