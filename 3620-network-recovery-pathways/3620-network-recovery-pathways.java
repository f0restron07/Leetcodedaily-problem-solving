import java.util.*;

class Solution {
    public int findMaxPathScore(int[][] edges, boolean[] online, long k) {
        int n = online.length;
        
        List<int[]>[] adj = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }
        
        int minCost = Integer.MAX_VALUE;
        int maxCost = Integer.MIN_VALUE;
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int cost = edge[2];
            adj[u].add(new int[]{v, cost});
            minCost = Math.min(minCost, cost);
            maxCost = Math.max(maxCost, cost);
        }
        
        int[] inDegree = new int[n];
        for (int[] edge : edges) {
            inDegree[edge[1]]++;
        }
        
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }
        
        List<Integer> topoOrder = new ArrayList<>();
        while (!queue.isEmpty()) {
            int curr = queue.poll();
            topoOrder.add(curr);
            for (int[] next : adj[curr]) {
                int v = next[0];
                if (--inDegree[v] == 0) {
                    queue.offer(v);
                }
            }
        }
        
        int low = minCost, high = maxCost;
        int ans = -1;
        
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (isValid(n, adj, online, topoOrder, k, mid)) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        
        return ans;
    }
    
    private boolean isValid(int n, List<int[]>[] adj, boolean[] online, List<Integer> topoOrder, long k, int minAllowedCost) {
        long[] dp = new long[n];
        Arrays.fill(dp, Long.MAX_VALUE);
        dp[0] = 0;
        
        for (int u : topoOrder) {
            if (dp[u] == Long.MAX_VALUE) continue;
            
            if (u != 0 && u != n - 1 && !online[u]) {
                continue;
            }
            
            for (int[] edge : adj[u]) {
                int v = edge[0];
                int cost = edge[1];
                
                if (cost >= minAllowedCost) {
                    if (dp[u] + cost < dp[v]) {
                        dp[v] = dp[u] + cost;
                    }
                }
            }
        }
        
        return dp[n - 1] <= k;
    }
}