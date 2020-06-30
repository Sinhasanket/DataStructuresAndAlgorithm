package BackTracking;

import java.util.Arrays;
import java.util.Scanner;

public class Mcoloring {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int graph[][]=new int[4][4];
        for (int i=0;i<4;i++){
            for (int j=0;j<4;j++){
                graph[i][j] = sc.nextInt();
            }
        }
        int color = 3;
        int vertex = 4;
        int colorArr[]=new int[vertex];
        Arrays.fill(colorArr,0);
        if (ColorGraph(graph,color,vertex,colorArr,0)){
            System.out.println("Yes");
        }else{
            System.out.println("No");
        }
    }

    public static boolean ColorGraph(int graph[][],int m,int vertex,int[] colors, int initial){
        if (initial==vertex)return true;
        for (int i=1;i<=m;i++){
            if(isSafe(graph,initial,colors,i,vertex)){
                colors[initial] = i;
                if(initial+1 <  vertex && ColorGraph(graph,m,vertex,colors,initial+1)){
                    return true;
                }
                colors[initial] = 0;
            }
        }
        return false;
    }

    public static boolean isSafe(int graph[][],int presentVertex,int colors[],int checkColor,int vertex){
        for (int i=0;i<vertex;i++){
            if(graph[presentVertex][i]==1 && colors[i]==checkColor){
                return false;
            }
        }
        return true;
    }
}
