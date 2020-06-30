package String;

import java.util.Scanner;

public class RepeatingChar {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while(t-- > 0){
            String str = sc.next();
            int index = repeatedCharacter(str);
            if(index == -1)
                System.out.println("-1");
            else
                System.out.println(str.charAt(index));
        }
    }

    static int repeatedCharacter(String S) {
        int res = Integer.MAX_VALUE;
        int count[] = new int[256];
        for(int i=0;i<S.length();i++){
            count[i]=-1;
        }
        for(int i=0;i<S.length();i++){
            if(count[S.charAt(i)]==-1){
                count[S.charAt(i)]=i;
            }else{
                res= Math.min(res,count[S.charAt(i)]);
            }
        }
        return (res==Integer.MAX_VALUE)? -1 : res;
    }
}
