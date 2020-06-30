package Sorting;

import java.util.Scanner;

//Given an array arr[] consisting of N positive integers. The task is to find inversion count of array.
//
//Inversion Count : For an array, inversion count indicates how far (or close) the array is from
//being sorted. If array is already sorted then inversion count is 0. If array is sorted in reverse
//order that inversion count is the maximum.
//Formally, two elements a[i] and a[j] form an inversion if a[i] > a[j] and i < j.

//TIME COMPLEXITY O(NLOGN)
public class InversionOfArray {

    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        long t = sc.nextLong();

        while(t-- > 0) {
            long n = sc.nextLong();
            long arr[] = new long[(int)n];

            for(long i = 0; i < n; i++)
                arr[(int)i] = sc.nextLong();
            System.out.println(inversionCount(arr, n));

        }
    }

    static long inversionCount(long arr[], long n){
        int size = (int) n;
        long temp[] = new long[size];
        return _mergeSort(arr, temp, 0, size - 1);
    }

    static long _mergeSort(long arr[], long temp[], long left, long right) {
        long mid, inv_count = 0;
        if (right > left) {
            mid = (right + left) / 2;
            inv_count = _mergeSort(arr, temp, left, mid);
            inv_count += _mergeSort(arr, temp, mid + 1, right);
            inv_count += merge(arr, temp, left, mid + 1, right);
        }
        return inv_count;
    }

    static long merge(long arr[], long temp[], long left, long mid, long right){
        long i, j, k;
        long inv_count = 0;

        i = left;
        j = mid;
        k = left;
        while ((i <= mid - 1) && (j <= right)) {

            if (arr[(int) i] <= arr[(int)j]) {
                temp[(int)k++] = arr[(int)i++];
            }
            else {
                temp[(int)k++] = arr[(int)j++];
                inv_count = inv_count + (mid - i);
            }
        }
        while ( i <= mid - 1)
            temp[(int)k++] = arr[(int)i++];

        while ( j <= right)
            temp[(int)k++] = arr[(int)j++];

        for ( i = left; i <= right; i++)
            arr[(int)i] = temp[(int)i];

        return inv_count;
    }
}


//        Input:
//        3
//        5
//        2 4 1 3 5
//        5
//        2 3 4 5 6
//        3
//        10 10 10
//
//        Output:
//        3
//        0
//        0

//INEFFICIENT WAY O(N*N)
//    static int arr[] = new int[] { 1, 20, 6, 4, 5 };
//
//    static int getInvCount(int n)
//    {
//        int inv_count = 0;
//        for (int i = 0; i < n - 1; i++)
//            for (int j = i + 1; j < n; j++)
//                if (arr[i] > arr[j])
//                    inv_count++;
//
//        return inv_count;
//    }