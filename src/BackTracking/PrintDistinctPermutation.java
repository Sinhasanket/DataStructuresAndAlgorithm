package BackTracking;

import java.util.*;
public class PrintDistinctPermutation {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        TreeSet<String> ans = solve(str);
        for(String aa : ans){
            System.out.println(aa);
        }
    }
    public static TreeSet<String> solve(String str){
        if(str.length()==0){
            TreeSet<String> base = new TreeSet<>();
            base.add("");
            return base;
        }
        char ch = str.charAt(0);
        String rest = str.substring(1);
        TreeSet<String> my = new TreeSet<>();
        TreeSet<String> rec = solve(rest);
        for(String r : rec){
            for(int i=0;i<=r.length();i++){
                String sub = r.substring(0,i)+ch+r.substring(i);
                my.add(sub);
            }
        }
        return my;
    }
}

//ABA