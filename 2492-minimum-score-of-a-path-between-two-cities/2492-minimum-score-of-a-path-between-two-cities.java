class Solution {
    public int minScore(int n, int[][] roads) {
        // dij
        // graph
        HashMap<Integer, List<int[]>> graph = new HashMap<>();
        for (int[] f: roads) {
            graph.putIfAbsent(f[0], new ArrayList<>());
            graph.putIfAbsent(f[1], new ArrayList<>());
            graph.get(f[0]).add(new int[]{f[1], f[2]});
            graph.get(f[1]).add(new int[]{f[0], f[2]});
        }

        PriorityQueue<Node> minheap = new PriorityQueue<>((a, b) -> a.cost - b.cost); // <nei: cost>

        minheap.add(new Node(1, Integer.MAX_VALUE));
        
        int mincost = Integer.MAX_VALUE;
        boolean[] vis = new boolean[n + 1];
        while (!minheap.isEmpty()) {

            Node cur = minheap.poll();

            mincost = Math.min(mincost, cur.cost); 

            if (vis[cur.val] == true) continue;
            vis[cur.val] = true;

            if (graph.get(cur.val) != null) {
                for (int[] nei: graph.get(cur.val)) {

                    int curmincost = Math.min(nei[1], cur.cost);

                    minheap.add(new Node(nei[0], curmincost));
                }
            }
        }
        return mincost;
    }
    class Node {
        int val;
        int cost;
        
        public Node(int val, int cost) {
            this.val = val;
            this.cost = cost;
        }
    }
}