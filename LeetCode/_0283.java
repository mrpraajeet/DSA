class _0283 {
    public void moveZeroes(int[] nums) {
        int r = 0, w = 0, n = nums.length;
        for(; r < n; r++) if(nums[r] != 0) nums[w++] = nums[r];
        for(; w < n; w++) nums[w] = 0;
    }
}