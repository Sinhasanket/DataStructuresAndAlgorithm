package Greedy;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class ActivitySelection {
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());

        while(t-- > 0) {
            String inputLine[] = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);
            int start[] = new int[n];
            int end[] = new int[n];

            inputLine = br.readLine().trim().split(" ");
            for(int i = 0; i < n; i++)
                start[i] = Integer.parseInt(inputLine[i]);

            inputLine = br.readLine().trim().split(" ");
            for(int i= 0; i < n; i++)
                end[i] = Integer.parseInt(inputLine[i]);

            System.out.println(new Activity().activitySelection(start, end, n));
        }
    }
}

class Pair {
    int x,y;
    Pair(){
        this.x=0;
        this.y=0;
    }
    Pair(int x, int y){
        this.x = x;
        this.y = y;
    }
}

class Activity {

    static void sortPair(Pair arr[], int n) {
        Arrays.sort(arr, new Comparator<Pair>() {
            @Override public int compare(Pair p1, Pair p2) {
                return p1.x - p2.x;
            }
        });
    }

    static int activitySelection(int start[], int end[], int n){
        Pair[] p = new Pair[n];
        for(int i=0; i<n; i++){
            p[i] = new Pair();
            p[i].y = start[i];
        }
        for(int i=0; i<n; i++){
            p[i].x = end[i];
        }
        sortPair(p, n);
        int i=0, j=1, ans=1;
        while(i<n && j<n){
            if(p[i].x<=p[j].y){
                i=j;
                j++;
                ans++;
            } else {
                j++;
            }
        }
        return ans;
    }
}

//        Input:
//        2
//        6
//        1 3 2 5 8 5
//        2 4 6 7 9 9
//        4
//        1 3 2 5
//        2 4 3 6
//
//        Output:
//        4
//        4