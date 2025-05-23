import java.util.Set;

public class _1456 {
    public int maxVowels(String s, int k) {
        int i = 0, j = 0, vc = 0, vm = 0, n = s.length();
        Set<Character> vowels = Set.of('a','e','i','o','u');

        while(j < k) if(vowels.contains(s.charAt(j++))) vc++;
        if(vc == k) return k;
        vm = vc;

        while(j < n) {
            if(vowels.contains(s.charAt(j++))) vc++;
            if(vowels.contains(s.charAt(i++))) vc--;
            if(vc > vm) vm = vc;
        }

        return vm;
    }
}
