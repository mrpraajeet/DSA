import java.util.*;

public class _2559 {
    public int[] vowelStrings(String[] words, int[][] queries) {
        int[] vowel = new int[words.length + 1];
        vowel[0] = 0;
        Set<Character> vowels = Set.of('a','e','i','o','u');
        int[] ans = new int[queries.length];

        for(int i = 1; i < words.length + 1; i++) {
            String w = words[i - 1];
            vowel[i] = vowel[i - 1];
            if(vowels.contains(w.charAt(0)) && vowels.contains(w.charAt(w.length() - 1))) {
                vowel[i]++;
            }
        }

        for(int i = 0; i < queries.length; i++) {
            ans[i] = vowel[queries[i][1] + 1] - vowel[queries[i][0]];
        }

        return ans;
    }
}
