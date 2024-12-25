import java.util.*;

class _3264 {
    public int[] getFinalState(int[] nums, int k, int x) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> {
                if(a[0] < b[0]) return -1;
                if(a[0] > b[0]) return 1;
                if(a[1] < b[1]) return -1;
                return 1;
            }
        );

        for(int i = 0; i < nums.length; i++) 
            pq.add(new int[] {nums[i], i});

        while(k-- > 0) {
            int[] min = pq.poll();
            min[0] *= x;
            pq.add(min);
        }

        int[] res = new int[nums.length];

        while(!pq.isEmpty()) {
            int[] min = pq.poll();
            res[min[1]] = min[0];
        }
        
        return res;
    }
}