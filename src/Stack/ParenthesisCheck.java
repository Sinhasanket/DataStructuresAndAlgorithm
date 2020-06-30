package Stack;

import java.util.Scanner;
import java.util.Stack;

public class ParenthesisCheck {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t= sc.nextInt();

        while(t-- >0){
            String st = sc.next();
            if(ispar(st) == true)
                System.out.println("balanced");
            else
                System.out.println("not balanced");
        }
    }

    static boolean isMatchingPair(char character1, char character2){
        if (character1 == '(' && character2 == ')')
            return true;
        else if (character1 == '{' && character2 == '}')
            return true;
        else if (character1 == '[' && character2 == ']')
            return true;
        else
            return false;
    }

    static boolean ispar(String x) {
        // add your code here
        Stack<Character> st = new Stack<Character>();
        for(int i=0;i<x.length() ;i++){
            if(x.charAt(i)=='(' || x.charAt(i)=='{'|| x.charAt(i)=='['){
                st.push(x.charAt(i));
                //   System.out.print(x.charAt(i)+" ");
            }
            if(x.charAt(i)==')' || x.charAt(i)=='}'|| x.charAt(i)==']'){
                //  System.out.print(st.peek()+" ");
                if(st.isEmpty()){
                    return false;
                }
                else if(!isMatchingPair(st.pop(),x.charAt(i))){
                    return false;
                }
            }
        }

        if(st.isEmpty()){
            return true;
        }else{
            return false;
        }
    }

}
