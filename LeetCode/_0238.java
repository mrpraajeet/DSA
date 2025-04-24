class _0238 {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length, suffix = 1;
        int[] ans = new int[n];

        ans[0] = 1;
        for(int i = 1; i < n; i++) {
            if(nums[i - 1] == 0) break;
            ans[i] = ans[i - 1] * nums[i - 1];
        }

        for(int i = n - 2; i >= 0; i--) {
            suffix *= nums[i + 1];
            ans[i] *= suffix;
        }

        return ans;
    }
}