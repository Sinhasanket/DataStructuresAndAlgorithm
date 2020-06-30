package Stack;

import java.util.Scanner;
import java.util.Stack;

public class PrefixEvaluation {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        System.out.println(solve(str));
    }

    static double solve(String str) {
        Stack<Double> st = new Stack<Double>();
        for (int j = str.length() - 1; j >= 0; j--) {
            if (isOp(str.charAt(j)))
                st.push((double)(str.charAt(j) - 48));
            else {
                double one = st.peek();
                st.pop();
                double two = st.peek();
                st.pop();
                switch (str.charAt(j)) {
                    case '+':
                        st.push(one + two);
                        break;
                    case '-':
                        st.push(one - two);
                        break;
                    case '*':
                        st.push(one * two);
                        break;
                    case '/':
                        st.push(one / two);
                        break;
                }
            }
        }
        return st.peek();
    }

    public static Boolean isOp(char c) {
        if (c >= 48 && c <= 57) return true;
        else return false;
    }
}
