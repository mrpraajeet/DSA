class _2657 {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int n = A.length;
        int[] freq = new int[n+1], common = new int[n];
        freq[A[0]]++;
        if(++freq[B[0]] == 2) common[0]++;

        for(int i = 1; i < n; i++) {
            common[i] = common[i-1];
            if(++freq[A[i]] == 2) common[i]++;
            if(++freq[B[i]] == 2) common[i]++;
        }

        return common;
    }
}