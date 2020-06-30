package Recursion;

//permutation(arrangement) of any string is the factorial of length of string
// Example := "abc" --> length - 3 , so number of permutation is 3! which is 6

public class PermutationOfString {
    public static void main(String[] args){
        String str = "abc";
       // System.out.println(permute(str));
        permute(str,"");
    }
//    using Arraylist
//    public static ArrayList<String> permute(String str){
//        if (str.length()==0){
//            ArrayList<String> base = new ArrayList<>();
//            base.add("");
//            return base;
//        }
//        char ch = str.charAt(0);
//        String rest = str.substring(1);
//        ArrayList<String> recStr = permute(rest);
//        ArrayList<String> myStr = new ArrayList<>();
//        for (String prev : recStr){
//            for (int j=0;j<=prev.length();j++){
//               String in = prev.substring(0,j)+ch+prev.substring(j);
//               myStr.add(in);
//            }
//        }
//        return myStr;
//    }

//    without using arraylist
    public static void permute(String que,String ans){
        if (que.length()==0){
            System.out.println(ans);
            return;
        }
        for (int i=0;i<que.length();i++){
            char ch = que.charAt(i);
            String roq = que.substring(0,i)+que.substring(i+1);
            permute(roq,ans+ch);
        }
    }
}
