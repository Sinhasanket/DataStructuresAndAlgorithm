package BackTracking;

public class MazePath {
    public static void main(String[] args){
        int maze[][] ={
                {0,1,0,0},
                {0,0,0,0},
                {0,1,0,0},
                {0,0,1,0}
        };

        BlockMaze(maze,0,0,"",new boolean[maze.length][maze[0].length]);
    }

    public static void BlockMaze(int maze[][],int row,int col,String ans,boolean visited[][]){
        //positive base case
        if (row==maze.length-1 && col==maze[0].length-1){
            System.out.println(ans);
            return;
        }
        //negative base case
        if (row==-1 || col==-1 || row==maze.length || col==maze[0].length ||
                maze[row][col]==1 || visited[row][col]){
            return;
        }
        //mark visited
        visited[row][col]=true;
        //top
        BlockMaze(maze,row-1,col,ans+"T",visited);
        //Down
        BlockMaze(maze,row+1,col,ans+"D",visited);
        //Left
        BlockMaze(maze,row,col-1,ans+"L",visited);
        //Right
        BlockMaze(maze,row,col+1,ans+"R",visited);
        //Backtrack
        visited[row][col] = false;
    }
}
