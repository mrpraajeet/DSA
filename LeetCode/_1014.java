public class _1014 {
    public int maxScoreSightseeingPair(int[] values) {
        int max = Integer.MIN_VALUE, besti = values[0];
        for(int j = 1; j < values.length; j++) {
            max = Math.max(max, besti + values[j] - j);
            besti = Math.max(besti, values[j] + j);
        }
        return max;
    }
}
