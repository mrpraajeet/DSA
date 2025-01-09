class _2185 {
    public int prefixCount(String[] words, String pref) {
        char[] pre = pref.toCharArray();
        int count = 0, n = pre.length;

        for(String word : words) {
            if(n > word.length()) continue;

            boolean prefix = true;
            for(int i = 0; i < n; i++) {
                if(pre[i] != word.charAt(i)) {
                    prefix = false;
                    break;
                }
            }

            if(prefix) count++;
        }

        return count;
    }
}