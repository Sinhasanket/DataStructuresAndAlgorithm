package Hashing;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class RearrangeChar {

    public static void main (String[] args) {
            try {
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                int t = Integer.parseInt(br.readLine());
                while (t-- > 0) {
                    String str = br.readLine();
                    boolean result = rearrangeCharacters(str);
                    if (result)
                        System.out.println(1);
                    else
                        System.out.println(0);
                }
            } catch (Exception e) {
        }
    }

    static boolean rearrangeCharacters(String s) {
        Map<Character, Integer> freq=new HashMap<>();
        char str[]=s.toCharArray();
        int max_freq = 0;
        for (int j = 0; j < (str.length); j++) {
            if(freq.containsKey(str[j])) {
                freq.put(str[j], freq.get(str[j])+1);
                if (freq.get(str[j]) > max_freq)
                    max_freq = freq.get(str[j]);
            } else{
                freq.put(str[j], 1);
                if (freq.get(str[j]) > max_freq)
                    max_freq = freq.get(str[j]);
            }
        }

        if (max_freq <= (str.length - max_freq))
            return true;
        return false;
    }
}


//        Input:
//        3
//        geeksforgeeks
//        bbbabaaacd
//        bbbbb
//
//        Output:
//        1
//        1
//        0