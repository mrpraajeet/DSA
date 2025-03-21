public class _3191 {
    public int minOperations(int[] nums) {
        int ops = 0, n = nums.length;

        for(int i = 0; i < n - 2; i++) {
            if(nums[i] == 0) {
                ops++;
                nums[i + 1] ^= 1;
                nums[i + 2] ^= 1;
            }
        }

        if(nums[n - 2] == 0 || nums[n - 1] == 0) return -1;
        return ops;
    }
}
