package String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class IsomorphicStr {
    static int size=256;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        while(tc-->0) {
            String s1 = br.readLine();
            String s2 = br.readLine();

            boolean a = areIsomorphic(s1,s2);
            if(a)
                System.out.println(1);
            else
                System.out.println(0);
        }
    }

    public static boolean areIsomorphic(String S1,String S2) {
        int m = S1.length();
        int n = S2.length();
        if(m !=n ){
            return false;
        }
        Boolean marked[] = new Boolean[size];
      //  Arrays.fill(marked, Boolean.FALSE);

        int map[] = new int[size];
        //Arrays.fill(map,-1);

        for(int i=0; i<n;i++){
            if(map[S1.charAt(i)]==-1){
                if(marked[S2.charAt(i)]==true)
                    return false;

                marked[S2.charAt(i)]=true;
                map[S1.charAt(i)]=S2.charAt(i);

            }
            else if(map[S1.charAt(i)] != S2.charAt(i))
                return false;
        }
        return true;
    }
}
