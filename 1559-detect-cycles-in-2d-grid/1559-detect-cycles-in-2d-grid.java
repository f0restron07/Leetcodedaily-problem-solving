 class Solution {
    class DSU {
      int[] parent;

      DSU(int n) {
        this.parent = new int[n];
        java.util.Arrays.fill(parent, -1);
      }

      int find(int x) {
        if (parent[x] < 0)
          return x;
        return parent[x] = find(parent[x]);
      }

      boolean union(int a, int b) {
        if ((a = find(a)) != (b = find(b))) {
          if (parent[a] <= parent[b]) {
            parent[a] += parent[b];
            parent[b] = a;
          } else {
            parent[b] += parent[a];
            parent[a] = b;
          }
          return false;
        }
        return true;
      }
    }

    int[][] dirs = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

    public boolean containsCycle(char[][] grid) {

      int m = grid.length;
      int n = grid[0].length;
      var dsu = new DSU(n * m);

      for (int i = 0; i < m; i++) {

        for (int j = 0; j < n; j++) {

          var c = grid[i][j];

          for (var d : dirs) {

            int u = d[0] + i;
            int v = d[1] + j;
            if (u < 0 || v < 0 || u >= m || v >= n || grid[u][v] != c)
              continue;
            if (dsu.union(u * n + v, i * n + j))
              return true;
          }
          grid[i][j] = '.';

        }
      }
      return false;
    }
  }