package Recursion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class DictionaryOrder {
    static ArrayList<String> check = new ArrayList<>();
    public static void main(String args[]) {
        // Your Code Here
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        solve(str,"",str);
        Collections.sort(check);
        for(int i=0;i<check.size();i++){

            //change this condition to str.compareTo(check.get(i)) > 0 to get lexiographically smaller

            if(check.get(i).compareTo(str)>0 ) System.out.println(check.get(i));
            //	else break;
        }
        check.clear();
    }

    public static void solve(String str,String ans, String chhh){
        if(str.length()==0){
            check.add(ans);
            return;
        }

        for(int i=0;i<str.length();i++){
            char ch = str.charAt(i);
            String rest = str.substring(0,i)+str.substring(i+1);
            solve(rest,ans+ch,chhh);
        }
    }
}
