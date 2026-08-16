package com.rrachet.dsaforge.graphs;

/** Counts connected land components with DFS. Time O(rows*cols), space O(rows*cols) worst-case stack. */
public final class NumberOfIslands {
    private NumberOfIslands() {}
    public static int count(char[][] grid) {
        if (grid.length == 0) return 0; int islands = 0;
        for (int r = 0; r < grid.length; r++) for (int c = 0; c < grid[r].length; c++) if (grid[r][c] == '1') { islands++; sink(grid, r, c); }
        return islands;
    }
    private static void sink(char[][] g, int r, int c) {
        if (r < 0 || r >= g.length || c < 0 || c >= g[r].length || g[r][c] != '1') return;
        g[r][c] = '0'; sink(g,r+1,c); sink(g,r-1,c); sink(g,r,c+1); sink(g,r,c-1);
    }
}
