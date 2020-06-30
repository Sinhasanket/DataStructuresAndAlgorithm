package String;

//Pasha is a strange guy. He has a string of length N. He wants to perform 2 types of queries on the string.
//Type 1- Rotate the string by K character from the end.
//Type 2- Print the Character at the I'th index of the resulting string at that Instant.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class LazyPasha {
//    maintain the position from where  we need to shift the character to the beginning of the string,
//    without rotating the string really
    public static void main (String[] args) {
        FastReader s=new FastReader();
        int t = s.nextInt();
        while(t-->0){
            int len = s.nextInt();
            int q = s.nextInt();
            String st = s.next();
            char stt[]=st.toCharArray();
            int start = 0;
            while(q-->0){
                int x = s.nextInt();
                int y = s.nextInt()%len;
                if(x==1){
                    start = (start + len - y )%len;
                }else{
                    System.out.println(stt[(start + y)%len]);
                }
            }
        }
    }

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
    }
}

//        Sample Input:
//        1
//        7 5
//        abcdefg
//        1 2
//        2 0
//        2 6
//        1 4
//        2 1
//
//        Sample output:
//        f
//        e
//        c