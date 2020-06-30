package Sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class MergeTwoSortedArray {

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new
                    InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
    }


    public static void main(String[] args){
       FastReader in = new FastReader();
       int t = in.nextInt();
       int n = in.nextInt();
       int m = in.nextInt();
       int arr1[] = new int[n];
       int arr2[] = new int[m];
       while(t-->0){
           for(int i=0;i<arr1.length;i++){
               arr1[i]=in.nextInt();
           }
           for(int j=0;j<arr2.length;j++){
               arr2[j]=in.nextInt();
           }

           merge(arr1,arr2,n,m);
       }
    }

    public static void merge(int arr1[], int arr2[], int n, int m) {
        int i=0,j=0,k=0;
        int merged[] =new int[n+m];
        while(i<n && j<m){
            if(arr1[i]<arr2[j]){
                merged[k++]= arr1[i++];
            }else{
                merged[k++]=arr2[j++];
            }
        }
        while(i<n){
            merged[k++]=arr1[i++];
        }
        while(j<m){
            merged[k++]=arr2[j++];
        }

        for(int o=0;o<merged.length;o++){
            System.out.print(merged[o]+" ");
        }

    }

//THIS TAKES O(1) EXTRA SPACE
//    private static int nextGap(int gap){
//        if (gap <= 1)
//            return 0;
//        return (gap / 2) + (gap % 2);
//    }
//
//    public static void merge(int arr1[], int arr2[], int n, int m) {
//        int i, j, gap = n + m;
//        for (gap = nextGap(gap); gap > 0;
//             gap = nextGap(gap)) {
//
//            for (i = 0; i + gap < n; i++)
//                if (arr1[i] > arr1[i + gap]) {
//                    int temp = arr1[i];
//                    arr1[i] = arr1[i + gap];
//                    arr1[i+gap] = temp;
//                }
//
//            for (j = gap > n ? gap - n : 0 ;
//                 i < n && j < m; i++, j++)
//                if (arr1[i] > arr2[j]) {
//                    int temp = arr1[i];
//                    arr1[i] = arr2[j];
//                    arr2[j] = temp;
//                }
//
//            if (j < m) {
//                for (j = 0; j + gap < m; j++)
//                    if (arr2[j] > arr2[j + gap]) {
//                        int temp = arr2[j];
//                        arr2[j] = arr2[j + gap];
//                        arr2[j+gap] = temp;
//                    }
//            }
//        }
//
//    }


}

//input
//1
//4
//5
//1 3 5 7
//0 2 6 8 9
//output
//0 1 2 3 5 6 7 8 9