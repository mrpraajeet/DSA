class _0151 {
    public String reverseWords(String s) {
        String[] r = s.split(" +");
        StringBuilder sb = new StringBuilder();
        for(int i = r.length - 1; i >= 0; i--) sb.append(r[i]).append(" ");
        return sb.toString().trim();
    }
}