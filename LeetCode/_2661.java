public class _2661 {
    public int firstCompleteIndex(int[] arr, int[][] mat) {
        int m = mat.length, n = mat[0].length;
        int[] prow = new int[m], pcol = new int[n];
        int[][] pos = new int[m * n + 1][2];

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                pos[mat[i][j]] = new int[] {i, j};
            }
        }

        for(int i = 0; i < m * n; i++) {
            if(++prow[pos[arr[i]][0]] == n || ++pcol[pos[arr[i]][1]] == m) {
                return i;
            }
        }

        return -1;
    }
}
