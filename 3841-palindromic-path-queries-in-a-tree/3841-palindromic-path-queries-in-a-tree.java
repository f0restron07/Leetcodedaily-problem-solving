class Solution {
    public List<Boolean> palindromePath(int n, int[][] edges, String s, String[] queries) {
        List<List<Integer>> a = new ArrayList<>();
        for (int i = 0; i < n; i++) a.add(new ArrayList<>());
        for (int[] j : edges) {
            a.get(j[0]).add(j[1]);
            a.get(j[1]).add(j[0]);
        }

        int[] b = new int[n];
        int[] c = new int[n];
        int[] d = new int[n];
        int[] e = new int[n];
        int[][] f = new int[17][n];
        boolean[] g = new boolean[n];
        Deque<Integer> h = new ArrayDeque<>();

        h.push(0);
        g[0] = true;
        int o = 0;
        while (!h.isEmpty()) {
            int p = h.pop();
            b[o] = p;
            c[p] = o;
            o++;
            for (int i : a.get(p)) {
                if (!g[i]) {
                    g[i] = true;
                    f[0][i] = p;
                    e[i] = e[p] + 1;
                    h.push(i);
                }
            }
        }

        for (int i = n - 1; i >= 0; i--) {
            int q = b[i];
            d[q] += 1;
            if (q != 0) d[f[0][q]] += d[q];
        }

        for (int j = 1; j < 17; j++)
            for (int k = 0; k < n; k++)
                f[j][k] = f[j - 1][f[j - 1][k]];

        int[] r = new int[17];
        r[0] = 1;
        for (int j = 1; j < 17; j++) r[j] = r[j - 1] * 2;

        int[][] t = new int[26][2 * n];
        char[] u = s.toCharArray();
        for (int i = 0; i < n; i++)
            add(t[u[i] - 'a'], n, c[i], c[i] + d[i] - 1, 1);

        List<Boolean> v = new ArrayList<>();
        for (String i : queries) {
            String[] w = i.split(" ");
            int x = Integer.parseInt(w[1]);

            if (w[0].equals("update")) {
                char y = w[2].charAt(0);
                if (y != u[x]) {
                    add(t[u[x] - 'a'], n, c[x], c[x] + d[x] - 1, -1);
                    add(t[y - 'a'], n, c[x], c[x] + d[x] - 1, 1);
                    u[x] = y;
                }
            } else {
                int y = Integer.parseInt(w[2]);
                int z = lca(x, y, e, f, r);
                o = 0;
                for (int j = 0; j < 26; j++) {
                    int k = get(t[j], n, c[x]) + get(t[j], n, c[y]) - 2 * get(t[j], n, c[z]);
                    if (u[z] - 'a' == j) k++;
                    if (k % 2 == 1) o++;
                }
                v.add(o <= 1);
            }
        }
        return v;
    }

    private void add(int[] u, int n, int v, int w, int x) {
        for (v += n, w += n + 1; v < w; v /= 2, w /= 2) {
            if (v % 2 == 1) u[v++] += x;
            if (w % 2 == 1) u[--w] += x;
        }
    }

    private int get(int[] u, int n, int v) {
        int w = 0;
        for (v += n; v > 0; v /= 2) w += u[v];
        return w;
    }

    private int lca(int x, int y, int[] e, int[][] f, int[] r) {
        if (e[x] < e[y]) { int z = x; x = y; y = z; }
        for (int j = 16; j >= 0; j--)
            if (e[x] - e[y] >= r[j]) x = f[j][x];
        if (x == y) return x;
        for (int j = 16; j >= 0; j--)
            if (f[j][x] != f[j][y]) { x = f[j][x]; y = f[j][y]; }
        return f[0][x];
    }
}