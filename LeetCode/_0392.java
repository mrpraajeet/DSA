class _0392 {
    public boolean isSubsequence(String s, String t) {
        int i1 = 0, i2 = 0, n1 = s.length(), n2 = t.length();
        while(i1 < n1 && i2 < n2) if(s.charAt(i1) == t.charAt(i2++)) i1++;
        return i1 == n1;
    }
}