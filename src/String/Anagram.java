package String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Anagram {

    public static int max_length = 256;

    public static void main (String[] args)throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            String str = br.readLine();
            String s1 = str.split(" ")[0];
            String s2 = str.split(" ")[1];

            if (isAnagram(s1, s2)) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }

    public static boolean isAnagram(String s1,String s2){
        int count1[] = new int[max_length];
        int count2[] = new int[max_length];
        int i=0;
        if(s1.length() != s2.length()){
            return false;
        }
        for(;i<s1.length()&&i<s2.length();i++){
            count1[s1.charAt(i)]++;
            count2[s2.charAt(i)]++;
        }
        for(;i<max_length;i++){
            if(count1[i] != count2[i]){
                return false;
            }
        }
        return true;
    }
}

