class Solution {
    public long minNumberOfSeconds(int mh, int[] wt) {

        int n = wt.length;

        PriorityQueue<long[]> pq = new PriorityQueue<>(
            (a,b)->Long.compare(a[3], b[3])
        );

        for(int i=0;i<n;i++){
            pq.offer(new long[]{i, wt[i], 1, wt[i]});
        }

        long ans = 0;

        while(mh > 0){
            long[] cur = pq.poll();

            int i = (int)cur[0];
            long w = cur[1];
            long k = cur[2];
            long finish = cur[3];

            ans = Math.max(ans, finish);

            k++;
            finish += w * k;

            pq.offer(new long[]{i, w, k, finish});

            mh--;
        }

        return ans;
    }
}