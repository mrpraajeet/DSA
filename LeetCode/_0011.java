class _0011 {
    public int maxArea(int[] h) {
        int l = 0, r = h.length - 1, a = 0;
        while(l < r) a = Math.max(a, h[l]<h[r] ? h[l]*(r-l++) : h[r]*(-l+r--));
        return a;
    }
}