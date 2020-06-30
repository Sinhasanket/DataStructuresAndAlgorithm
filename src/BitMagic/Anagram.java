package BitMagic;

import java.util.Scanner;

public class Anagram {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int t= sc.nextInt();
        while(t-->0){
            String s1 = sc.next();
            String s2 = sc.next();

            if(isAnagaram(s1,s2)){
                System.out.println("YES");
            }else {
                System.out.println("NO");
            }
        }
    }

    static boolean isAnagaram(String s1,String s2){
        if(s1.length() != s2.length()) return false;

        int value=0;
        for(int i=0;i<s1.length();i++){
            value ^= (int) s1.charAt(i);
            value ^= (int) s2.charAt(i);
        }
        return value==0;
    }
}



