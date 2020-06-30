package DynamicProgramming;

import java.util.Scanner;

public class PalindromicSubstring {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String st = sc.next();
        System.out.println(find(st));
    }
    public static String find(String str){
        int best_len=0;
        String best_str="";
        int n = str.length();
        for (int mid=0;mid<n;mid++){
            for (int x=0; mid-x >=0 && mid+x < n; x++){
                if (str.charAt(mid-x) != str.charAt(mid+x)){
                    break;
                }
                int len = 2*x+1;
                if (len > best_len){
                    best_len = len;
                    best_str = str.substring(mid-x,len);
                }
            }
        }

        for (int mid=0;mid<n-1;mid++){
            for (int x=1;mid-x+1>=0 && mid+x<n;x++){
                if (str.charAt(mid-x+1) != str.charAt(mid+x)){
                    break;
                }
                int len = 2*x;
                if (len > best_len){
                    best_len = len;
                    best_str = str.substring(mid-x-1,len);
                }
            }
        }
        return best_str;
    }
}
