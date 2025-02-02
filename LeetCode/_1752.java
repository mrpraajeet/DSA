class _1752 {
    public boolean check(int[] nums) {
        int dips = 0, n = nums.length, i = 1;

        for(; i < n && dips < 2; i++) if(nums[i] < nums[i - 1]) dips++;

        return dips == 0 || (dips == 1 && nums[0] >= nums[n - 1]);
    }
}