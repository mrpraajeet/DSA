import java.util.stream.Collectors;

class _3223 {
    public int minimumLength(String s) {
        int i = 0, min = 0, n = s.length();
        int[] count = new int[26];
        for(; i < n; i++) count[s.charAt(i) - 'a']++;

        for(i = 0; i < 26; i++) {
            int c = count[i];
            min += c < 3 ? c : 2 - c%2;
        }
        return min;
    }

    //Alternate stylish single line but slow Streams solution
    public int _minimumLength(String s) {
        return s.chars()
            .boxed()
            .collect(Collectors.groupingBy(ch -> ch - 'a', Collectors.counting()))
            .values()
            .stream()
            .reduce(0L, (acc, c) -> acc + (c < 3 ? c : 2 - c % 2))
            .intValue();
    }
}
