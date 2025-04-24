import java.util.*;
import java.util.stream.Collectors;

class _2799 {
    public int countCompleteSubarrays(int[] nums) {
        Set<Integer> set = Arrays.stream(nums).boxed().collect(Collectors.toSet());
        Map<Integer,Integer> sub = new HashMap<>();
        int count = 0;

        for(int l = 0, r = 0, d = set.size(), n = nums.length; r < n; r++) {
            sub.merge(nums[r], 1, (a, b) -> a + b);
            while(sub.size() == d) {
                count += n - r;
                sub.merge(nums[l++], -1, (a, b) -> a + b <= 0 ? null : a + b);
            }
        }
        return count;
    }
}
