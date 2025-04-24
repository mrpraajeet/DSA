import java.util.*;

class _1431 {
    public List<Boolean> kidsWithCandies(int[] candies, int x) {
        int g = 0;
        for(int c : candies) if(c > g) g = c;

        List<Boolean> res = new ArrayList<>();
        for(int c : candies) res.add(c + x >= g);
        return res;
    }
}