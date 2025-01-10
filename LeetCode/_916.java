import java.util.*;

class _916 {
    public List<String> wordSubsets(String[] words1, String[] words2) {
        List<String> subs = new ArrayList<>();
        int[] freq = new int[26];

        for(String s : words2) {
            int[] curr = new int[26];
            for(int i = 0; i < s.length(); i++) curr[s.charAt(i) - 'a']++;
            for(int i = 0; i < 26; i++) if(curr[i] > freq[i]) freq[i] = curr[i];
        }

        for(String s : words1) {
            int[] curr = new int[26];
            for(int i = 0; i < s.length(); i++) curr[s.charAt(i) - 'a']++;

            boolean uni = true;
            for(int i = 0; i < 26; i++) {
                if(curr[i] < freq[i]) {
                    uni = false;
                    break;
                }
            }
            if(uni) subs.add(s);
        }

        return subs;
    }
}