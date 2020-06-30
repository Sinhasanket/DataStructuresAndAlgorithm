package String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class KeypadTyping {
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

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }

    public static void main (String[] args) {
        FastReader s=new FastReader();
        int t = s.nextInt();
        while(t-->0){
            String str = s.nextLine();
            int n = str.length();
            for(int i=0;i<n;i++){
                char ch = str.charAt(i);
                switch(ch){
                    case 'a':
                    case 'b':
                    case 'c':
                        System.out.print(2);
                        break;
                    case 'd':
                    case 'e':
                    case 'f':
                        System.out.print(3);
                        break;
                    case 'g':
                    case 'h':
                    case 'i':
                        System.out.print(4);
                        break;
                    case 'j':
                    case 'k':
                    case 'l':
                        System.out.print(5);
                        break;
                    case 'm':
                    case 'n':
                    case 'o':
                        System.out.print(6);
                        break;
                    case 'p':
                    case 'q':
                    case 'r':
                    case 's':
                        System.out.print(7);
                        break;
                    case 't':
                    case 'u':
                    case 'v':
                        System.out.print(8);
                        break;
                    case 'w':
                    case 'x':
                    case 'y':
                    case 'z':
                        System.out.print(9);
                        break;
                }
            }
            System.out.println();
        }
    }
}

//You are given a string S of alphabet characters and the task is to find its matching decimal representation as on
// the shown keypad. Output the decimal representation corresponding to the string. For ex: if you are given “amazon”
// then its corresponding decimal representation will be 262966.

//Input
//2
//geeksforgeeks
//geeksquiz
//
//Output
//4335736743357
//4335778497