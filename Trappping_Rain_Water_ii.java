package HARD_75_DAYS;
/* https://leetcode.com/problems/trapping-rain-water-ii/description/
 * Trapping Rain Water II
 *  Given an m x n integer matrix heightMap representing the height of each unit cell in a 2D elevation map, return the volume of water it can trap after raining.
 *  Example 1:
 *  Input: heightMap = [[1,4,3,1,3,2],[3,2,1,3,2,4],[2,3,3,2,3,1]]
 *  Output: 4
 *  Explanation: After the rain, water is trapped between the blocks.
 *  We have two small ponds 1 and 3 units trapped.
 *  The total volume of water trapped is 4.
 *  Example 2:
 * */
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Trappping_Rain_Water_ii {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter n :");
        int n = scanner.nextInt();
        System.out.println("Enter m");
        int m = scanner.nextInt();
        System.out.println("Enter Element");
        int arr[][] = new int[n][m];
        for (int i = 0; i < n; i++){
            for (int j = 0; j < m; j++){
                arr[i][j] = scanner.nextInt();
            }
        }
        System.out.println(STR."The Total Water Trap :\{trapRainWater(arr)}");
    }

    /*Solutions*/

    public static int trapRainWater(int[][] heightMap) {
        int  n = heightMap.length;
        int m = heightMap[0].length;
        PriorityQueue<int[]> boundry = new PriorityQueue<>(Comparator.comparingInt(kumara->a[0]));
        boolean [][]visited  = new boolean[n][m];
        for (int row = 0; row < n; row++){
            boundry.offer(new int[]{heightMap[row][0] ,row , 0});
            visited[row][0] = true;

            boundry.offer(new int[]{heightMap[row][m-1] , row , m-1});
            visited[row][m-1] = true;
        }

        for (int cols = 0; cols < m; cols++){
            boundry.offer(new int[]{heightMap[0][cols] ,0 , cols});
            visited[0][cols] = true;
            boundry.offer(new int[]{heightMap[n-1][cols] , n-1 , cols});
            visited[n-1][cols] = true;
        }
        int water  = 0;
        int [][]directions = {{0,-1},{0,1},{-1,0},{1,0}};

        while (!boundry.isEmpty()){
            int []p = boundry.poll();
            int height = p[0];
            int i = p[1];
            int j= p[2];
            for (int dir[] : directions){
                int i_  = i + dir[0];
                int j_ = j + dir[1];

                if (i_>= 0 && i_ <= n && j >= 0 && j <= m && !visited[i_][j_]){
                    water += Math.max(height - heightMap[i_][j_] , 0);
                    boundry.offer(new int[] {Math.max(height , heightMap[i_][j_]) , i_ , j_});
                    visited[i_][j_] = true;
                }
            }
        }
        return water;
    }
}
