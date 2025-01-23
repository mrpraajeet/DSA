public class _1267 {
    public int countServers(int[][] grid) {
        int m = grid.length, n = grid[0].length, count = 0;
        int[] rows = new int[m], cols = new int[n];

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                rows[i] += grid[i][j];
                cols[j] += grid[i][j];
            }
        }

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == 1 && rows[i] + cols[j] > 2) {
                    count++;
                }
            }
        }

        return count;
    }
}
