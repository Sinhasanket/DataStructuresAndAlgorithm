package Searching;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class MinPageAllocation {

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

    public static void main(String[] a){
        FastReader in = new FastReader();
        int test = in.nextInt();
        while(test-->0){
            int num = in.nextInt();
            int books[]= new int[num];
            for(int i=0;i<num;i++){
                books[i] = in.nextInt();
            }
            int k = in.nextInt();
            System.out.println(binSearchBook(books,num,k));
        }
    }

    static int binSearchBook(int books[],int n,int k){
        if(n<k){
            return -1;
        }
        int total_pages=0;
        int start =0;
        for(int i=0;i<n;i++){
            total_pages += books[i];
            start = Math.max(start,books[i]);
        }

        int end=total_pages;
        int finalAns = start;
        while(start<=end){
            int mid= (start+end)/2;
            if(isValidConfig(books,n,k,mid)){
                finalAns=mid;
                end=mid-1;
            }else{
                start=mid+1;
            }
        }
        return finalAns;
    }

    static boolean isValidConfig(int books[],int n,int k, int ans){
        int student =1;
        int current_page=0;
        for(int i=0;i<n;i++){
            if(current_page+books[i]>ans){
                current_page=books[i];
                student++;
                if(student>k){
                    return false;
                }
            }else{
                current_page+=books[i];
            }
        }
        return true;
    }
}

//input
//2
//4
//12 34 67 90
//2
//3
//15 17 20
//output
//113
//32