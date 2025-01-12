class _1400 {
    public boolean canConstruct(String s, int k) {
        int n = s.length(), i = 0, odd = 0;

        if(n < k) return false;
        if(n == k) return true;

        int[] count = new int[26];
        for(; i < n; i++) count[s.charAt(i) - 'a']++;

        for(i = 0; i < 26; i++) odd += count[i] % 2;
        return odd <= k;
    }
}