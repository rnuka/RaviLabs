package practice.coding.histograms;

import java.util.PriorityQueue;

/*
https://leetcode.com/problems/trapping-rain-water-ii/

Given an m x n matrix of positive integers representing the height of each unit cell in a 2D elevation map,
compute the volume of water it is able to trap after raining.

Note: Both m and n are less than 110. The height of each unit cell is greater than 0 and is less than 20,000.

Example:
Input: Given the following 3x6 height map:
[
  [1,4,3,1,3,2],
  [3,2,1,3,2,4],
  [2,3,3,2,3,1]
]

Output: 4. (Explanation: Trapped in second row between second (1unit), third (2units) and fifth column (1unit)
 */

/*
Approach: Start from outer ring and move towards center.
 */
public class TrapRainWater2D {
    public int trapRainWater(int[][] heightMap) {
        class Cell{
            int x;
            int y;
            int h;
            Cell(int x, int y, int height){
                this.x = x;
                this.y = y;
                h = height;
            }
        }
        if (heightMap == null || heightMap.length == 0 || heightMap[0].length == 0) {
            return 0;
        }

        int m = heightMap.length;
        int n = heightMap[0].length;

        PriorityQueue<Cell> pq = new PriorityQueue<>((v1,v2)->v1.h - v2.h);
        boolean[][] visited = new boolean[m][n];

        //Add top row and bottom row to queue
        for(int i = 0; i < n; i++){
            visited[0][i] = true;
            visited[m-1][i] = true;
            pq.offer( new Cell(0, i, heightMap[0][i]));
            pq.offer(new Cell(m-1, i, heightMap[m-1][i]));
        }

        //Add first column and last column (1 to m-2 rows cells)
        for(int i = 1; i < m-1; i++){
            visited[i][0] = true;
            visited[i][n-1] = true;
            pq.offer(new Cell(i, 0, heightMap[i][0]));
            pq.offer(new Cell(i, n-1, heightMap[i][n-1]));
        }


        int[] xs = {0,  0, 1, -1};
        int[] ys = {1, -1, 0,  0};

        int sum = 0;

        //Traverse through priority queue and calculate sum. If new cells are uncovered, then add them to priority queue.
        while (!pq.isEmpty()) {
            Cell cell = pq.poll();
            //For each cell, traverse four surroundings and see if any water can be trapped.
            //Add new uncovered cells to priority queue.
            for (int i = 0; i < 4; i++) {
                int nx = cell.x + xs[i];
                int ny = cell.y + ys[i];
                if (nx >= 0 && nx < m && ny >= 0 && ny < n && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    sum += Math.max(0, cell.h - heightMap[nx][ny]);
                    pq.offer(new Cell(nx, ny, Math.max(heightMap[nx][ny], cell.h)));
                }
            }
        }
        return sum;
    }

    public void testcase1(){
        int[][] heights = {{2,4,1,2},{4,1,4,4},{8,1,10,1},{1,4,3,4}};
        System.out.println("maximum water can be trapped is ::"+trapRainWater(heights));
    }

    public void testbed(){
        testcase1();
    }

    public static void main(String args[]){
        TrapRainWater2D t = new TrapRainWater2D();
        t.testbed();
    }
}
