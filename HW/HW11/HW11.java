import java.util.List;
import java.util.Arrays;
import java.util.Queue;
import java.util.LinkedList;

public class Graph{
    List<int[]> directions = Arrays.asList(
            new int[]{0,1},
            new int[]{0,-1},
            new int[]{1,0},
            new int[]{-1,0});
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int m = image.length;
        
        if(m==0) 
            return image;
        
        int n = image[0].length;
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{sr,sr});
        boolean visited[][] = new boolean[image.length][image[0].length];
        int oldColor = image[sr][sc];
        image[sr][sc] = color;

        while(!queue.isEmpty()){
            int[] currentNode = queue.poll();
            int currentRow = currentNode[0];
            int currentColumn = currentNode[1];
            visited[currentRow][currentColumn] = true;

            for (int i = 0; i < directions.size(); i++){
                int directionRow = currentRow + directions.get(i)[0];
                int directionColumn = currentColumn + directions.get(i)[1];

                if(directionRow < 0 || directionColumn < 0 || directionRow >= m ||directionColumn >= n || image[directionRow][directionColumn] != oldColor)
                    continue;
                
                if(visited[directionRow][directionColumn])
                    continue;
                
                image[directionRow][directionColumn] = color;

                queue.add(new int[]{directionRow, directionColumn});
            }
        }
        return image;
 }
    public static void main(String[] args) {
        Graph graph = new Graph();

        int[][] image1 = {{1, 1, 1}, {1, 1, 0}, {1, 0, 1}};
        int sr1 = 1;
        int sc1 = 1;
        int color1 = 2;

        int[][] result1 = graph.floodFill(image1, sr1, sc1, color1);
        System.out.println("Output 1:");
        printArray(result1);

        int[][] image2 = {{0, 0, 0}, {0, 0, 0}};
        int sr2 = 0;
        int sc2 = 0;
        int color2 = 0;

        int[][] result2 = graph.floodFill(image2, sr2, sc2, color2);
        System.out.println("Output 2:");
        printArray(result2);
    }

    private static void printArray(int[][] array) {
        for (int[] row : array) {
            System.out.print("[");
            for (int i = 0; i < row.length; i++) {
                System.out.print(row[i]);
                if (i < row.length - 1) {
                    System.out.print(", ");
                }
            }
            System.out.println("]");
        }
    }
}
