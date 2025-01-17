class _2683 {
    public boolean doesValidArrayExist(int[] derived) {
        int xor = 0;
        for(int i : derived) xor ^= i;
        return xor == 0;

        //return Arrays.stream(derived).reduce(0, (a, i) -> a ^ i) == 0;
    }
}