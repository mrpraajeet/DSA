class _2145 {
    public int numberOfArrays(int[] diff, int low, int up) {
        int range = up - low + 1, min = 0, max = 0, curr = 0;
        for(int d : diff) {
            curr += d;
            if(curr < min) min = curr;
            else if(curr > max) max = curr;
            if(range - max + min <= 0) return 0;
        }
        return range - max + min;
    }
}