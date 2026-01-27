class Solution {
    public int minCost(int n, int[][] edges) {
        int[][][] adj= buildGraph(n,edges);
        int[] dist=new int[n];
        Arrays.fill(dist,Integer.MAX_VALUE);

        dist[0]=0;
        Queue<int[]> pq=new PriorityQueue<>((a,b)->a[1]-b[1]);
        pq.offer(new int[]{0,0});

        while(!pq.isEmpty()){
            int[] top=pq.poll();
            int u=top[0];
            int d=top[1];

            if(d>dist[u])   continue;
            if(u==n-1) return d;

            for(int[] next:adj[u] ){
                int v=next[0];
                int newD=d+next[1];
                if(newD<dist[v]){
                    dist[v]=newD;
                    pq.offer(new int[]{v,newD});
                }
            }
        }
        return -1;
    }
    private static int[][][] buildGraph(int n, int[][] edges) {
        int[] degree = new int[n];
        for(int[] edge : edges) {degree[edge[0]]++; degree[edge[1]]++;}
        int[][][] adj = new int[n][][];
        for(int i = 0; i < n; i++) adj[i] = new int[degree[i]][];
        for(int[] edge : edges) adj[edge[0]][--degree[edge[0]]] = new int[] {edge[1], edge[2]};
        for(int[] edge : edges) adj[edge[1]][--degree[edge[1]]] = new int[] {edge[0], edge[2]*2};
        return adj;
    }
}