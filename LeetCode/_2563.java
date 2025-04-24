import java.util.Arrays;

class _2563 {
    public long countFairPairs(int[] nums, int lower, int upper) {
        Arrays.sort(nums);
        return count(nums, upper) - count(nums, lower - 1);
    }

    private long count(int[] nums, int k) {
        long pairs = 0;
        int l = 0, r = nums.length - 1;
        while(l < r) {
            if(nums[l] + nums[r] > k) r--;
            else pairs += r - l++;
        }
        return pairs;
    }
}