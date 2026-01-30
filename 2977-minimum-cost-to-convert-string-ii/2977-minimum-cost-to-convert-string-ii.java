class Solution {
    public long minimumCost(String source, String target, String[] original, String[] changed, int[] cost) {
        // Map strings to indices for Floyd-Warshall
        Map<String, Integer> strToIdx = new HashMap<>();
        int idx = 0;
        for (String s : original) if (!strToIdx.containsKey(s)) strToIdx.put(s, idx++);
        for (String s : changed) if (!strToIdx.containsKey(s)) strToIdx.put(s, idx++);
        
        int V = idx;
        long INF = (long) 1e18;
        long[][] dist = new long[V][V];
        for (long[] row : dist) Arrays.fill(row, INF);
        for (int i = 0; i < V; i++) dist[i][i] = 0;
        
        // Build graph
        for (int i = 0; i < cost.length; i++) {
            int u = strToIdx.get(original[i]);
            int v = strToIdx.get(changed[i]);
            dist[u][v] = Math.min(dist[u][v], cost[i]);
        }
        
        // Floyd-Warshall
        for (int k = 0; k < V; k++)
            for (int i = 0; i < V; i++)
                for (int j = 0; j < V; j++)
                    if (dist[i][k] < INF && dist[k][j] < INF)
                        dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
        
        // Collect all unique lengths
        Set<Integer> lengths = new TreeSet<>();
        for (String s : original) lengths.add(s.length());
        
        int n = source.length();
        long[] dp = new long[n + 1];
        Arrays.fill(dp, INF);
        dp[0] = 0;
        
        for (int i = 0; i < n; i++) {
            if (dp[i] == INF) continue;
            
            // Skip if characters match
            if (source.charAt(i) == target.charAt(i)) {
                dp[i + 1] = Math.min(dp[i + 1], dp[i]);
            }
            
            // Try all transformation lengths
            for (int len : lengths) {
                if (i + len > n) break;
                
                String srcSub = source.substring(i, i + len);
                String tgtSub = target.substring(i, i + len);
                
                if (srcSub.equals(tgtSub)) {
                    dp[i + len] = Math.min(dp[i + len], dp[i]);
                } else if (strToIdx.containsKey(srcSub) && strToIdx.containsKey(tgtSub)) {
                    int u = strToIdx.get(srcSub);
                    int v = strToIdx.get(tgtSub);
                    if (dist[u][v] < INF) {
                        dp[i + len] = Math.min(dp[i + len], dp[i] + dist[u][v]);
                    }
                }
            }
        }
        
        return dp[n] == INF ? -1 : dp[n];
    }
}