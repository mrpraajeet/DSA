import java.util.Set;

class _0345 {
    public String reverseVowels(String s) {
        Set<Character> v = Set.of('a','e','i','o','u','A','E','I','O','U');
        char[] ch = s.toCharArray();
        int l = 0, r = s.length() - 1;

        while(l < r) {
            while(l < r && !v.contains(ch[l])) l++;
            while(l < r && !v.contains(ch[r])) r--;

            char t = ch[l];
            ch[l++] = ch[r];
            ch[r--] = t;
        }

        return String.valueOf(ch);
    }
}