package com.chivalry.java.basic.paiza;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class WorkTest {
    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int N = sc.nextInt();
//
//        if (N >= 1 && N <= 10000) {
//            int[][] jobs = new int[N][2];
//            for (int i = 0; i < N; i++) {
//                jobs[i][0] = sc.nextInt();
//                jobs[i][1] = sc.nextInt();
//            }
//            Arrays.sort(jobs, Comparator.comparingInt(a -> a[0]));
//            int maxDays = 0;
//            int currentDays = 0;
//            int currentDate = 0;
//            for (int i = 0; i < N; i++) {
//                if (jobs[i][0] <= currentDate) {
//                    currentDays += jobs[i][1] - currentDate + 1;
//                } else {
//                    currentDays = jobs[i][1] - jobs[i][0] + 1;
//                }
//                currentDate = jobs[i][1] + 1;
//                maxDays = Math.max(maxDays, currentDays);
//            }
//            System.out.println(maxDays);
//        }


        Scanner sc = new Scanner(System.in);
        int h = sc.nextInt();
        int w = sc.nextInt();
        sc.nextLine();
        char[][] grid = new char[h][w];
        int startRow = 0;
        int startCol = 0;
        for (int i = 0; i < h; i++) {
            String line = sc.nextLine();
            for (int j = 0; j < w; j++) {
                grid[i][j] = line.charAt(j);
                if (grid[i][j] == 'S') {
                    startRow = i;
                    startCol = j;
                }
            }
        }
        boolean[][] visited = new boolean[h][w];
        boolean canEscape = dfs(grid, visited, startRow, startCol);
        System.out.println(canEscape ? "YES" : "NO");
    }

    private static boolean dfs(char[][] grid, boolean[][] visited, int row, int col) {
        if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length) {
            return true;
        }
        if (grid[row][col] == '#' || visited[row][col]) {
            return false;
        }
        visited[row][col] = true;
        return dfs(grid, visited, row - 1, col) ||
                dfs(grid, visited, row + 1, col) ||
                dfs(grid, visited, row, col - 1) ||
                dfs(grid, visited, row, col + 1);
    }
}
