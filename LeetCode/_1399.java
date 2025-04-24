class _1399 {
    public int countLargestGroup(int n) {
        int[] sums = new int[37];
        for(int i = 1; i <= n; i++) sums[sumDigits(i)]++;

        int largest = 0, count = 0;
        for(int i : sums) {
            if(i > largest) {
                largest = i;
                count = 1;
            } else if(i == largest) {
                count++;
            }
        }
        return count;
    }

    private int sumDigits(int i) {
        int sum = 0;
        while(i > 0) {
            sum += i % 10;
            i /= 10;
        }
        return sum;
    }
}