public class _0494 {
    public int findTargetSumWays(int[] nums, int k) {
        return exp(nums, k, 0, 0);
    }

    private int exp(int[] nums, int k, int i, int sum) {
        if(i == nums.length) return sum == k ? 1 : 0;
        return exp(nums, k, i+1, sum+nums[i]) + exp(nums, k, i+1, sum-nums[i]);
    }
}
