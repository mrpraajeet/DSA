class _3042 {
    public int countPrefixSuffixPairs(String[] words) {
        int count = 0, n = words.length;

        for(int i = 0; i < n - 1; i++) {
            for(int j = i + 1; j < n; j++) {
                if(isPrefixAndSuffix(words[i], words[j])) {
                    count++;
                }
            }
        }

        return count;
    }

    private boolean isPrefixAndSuffix(String str1, String str2) {
        int n1 = str1.length(), n2 = str2.length();
        if(n1 > n2) return false;

        for(int i = 0; i < n1; i++) {
            int c = str1.charAt(i);
            if(c != str2.charAt(i) || c != str2.charAt(n2 - n1 + i)) {
                return false;
            }
        }

        return true;
    }
}