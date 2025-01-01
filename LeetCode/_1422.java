class _1422 {
    public int maxScore(String s) {
        int max = 0, zeros = 0;
        int[] ones = new int[s.length()];

        for(int i = s.length() - 2; i >= 0; i--) {
            ones[i] = ones[i + 1] + s.charAt(i + 1) - '0';
        }

        for(int i = 0; i < s.length() - 1; i++) {
            if(s.charAt(i) - '0' == 0) zeros++;
            max = Math.max(max, zeros + ones[i]);
        }

        return max;
    }
}
