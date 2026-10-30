class Solution {
    public int shortestPath(int n, int[][] edges, String labels, int k) {
        List<int[]>[] a = new List[n];
        for (int i = 0; i < n; i++) a[i] = new ArrayList<>();
        for (int[] i : edges) a[i[0]].add(new int[]{i[1], i[2]});
        int[][] b = new int[n][k + 1];
        for (int[] i : b) Arrays.fill(i, Integer.MAX_VALUE);
        b[0][1] = 0;
        PriorityQueue<int[]> c = new PriorityQueue<>((d, e) -> d[0] - e[0]);
        c.add(new int[]{0, 0, 1});
        while (!c.isEmpty()) {
            int[] f = c.poll();
            if (f[1] == n - 1) return f[0];
            if (f[0] > b[f[1]][f[2]]) continue;
            for (int[] i : a[f[1]]) {
                int g = labels.charAt(i[0]) == labels.charAt(f[1]) ? f[2] + 1 : 1;
                int h = f[0] + i[1];
                if (g <= k && h < b[i[0]][g]) {
                    b[i[0]][g] = h;
                    c.add(new int[]{h, i[0], g});
                }
            }
        }
        return -1;
    }
}