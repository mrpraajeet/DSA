class _0605 {
    public boolean canPlaceFlowers(int[] fb, int n) {
        if(n == 0) return true;

        for(int i = 0; i < fb.length;) {
            if((i == 0 || fb[i - 1] == 0) && fb[i] == 0 && (i == fb.length - 1 || fb[i + 1] == 0)) {
                if(--n == 0) return true;
                i++;
            }
            i++;
        }

        return n == 0;
    }
}