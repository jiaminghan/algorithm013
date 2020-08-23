package com.company.leetcode.mid;

public class NumIslands {
    public int numIslands(char[][] grid) {
        int islands = 0;
        for(int row = 0; row < grid.length; row++){
            for(int column = 0; column < grid[row].length; column++){
                if(grid[row][column] == '1'){
                    islands++;
                    changeRecursively(grid, row, column);
                }
            }
        }
        return islands;
    }

    private void changeRecursively(char[][] grid, int row, int column){
        if(row < 0 ||row >= grid.length
                || column < 0 || column >= grid[row].length
                || grid[row][column] == '0'){
            return;
        }
        if(grid[row][column] == '1'){
            grid[row][column] = '0';
            changeRecursively(grid, row-1, column);
            changeRecursively(grid, row+1, column);
            changeRecursively(grid, row, column-1);
            changeRecursively(grid, row, column+1);
        }
    }
}
