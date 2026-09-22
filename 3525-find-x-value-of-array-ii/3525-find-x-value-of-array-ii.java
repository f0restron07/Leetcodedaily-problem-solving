class Solution {
    int k;
    int n;
    int[] prod;
    int[][] cnt;
    int[] a;

    public int[] resultArray(int[] nums, int k, int[][] queries) {
        this.k = k;
        this.n = nums.length;
        this.a = nums.clone();
        prod = new int[4 * n];
        cnt = new int[4 * n][];
        build(1, 0, n - 1);
        int[] res = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int idx = queries[i][0];
            int val = queries[i][1];
            int start = queries[i][2];
            int x = queries[i][3];
            update(1, 0, n - 1, idx, val);
            int[] r = query(1, 0, n - 1, start, n - 1);
            res[i] = r[x];
        }
        return res;
    }

    void merge(int node) {
        int l = 2 * node, rt = 2 * node + 1;
        int lp = prod[l];
        prod[node] = (int) (((long) lp * prod[rt]) % k);
        int[] c = new int[k];
        for (int r = 0; r < k; r++) {
            c[r] += cnt[l][r];
        }
        for (int rr = 0; rr < k; rr++) {
            if (cnt[rt][rr] > 0) {
                c[(int) (((long) lp * rr) % k)] += cnt[rt][rr];
            }
        }
        cnt[node] = c;
    }

    void build(int node, int lo, int hi) {
        if (lo == hi) {
            int v = a[lo] % k;
            prod[node] = v;
            cnt[node] = new int[k];
            cnt[node][v]++;
            return;
        }
        int mid = (lo + hi) / 2;
        build(2 * node, lo, mid);
        build(2 * node + 1, mid + 1, hi);
        merge(node);
    }

    void update(int node, int lo, int hi, int pos, int val) {
        if (lo == hi) {
            int v = val % k;
            prod[node] = v;
            cnt[node] = new int[k];
            cnt[node][v]++;
            return;
        }
        int mid = (lo + hi) / 2;
        if (pos <= mid) {
            update(2 * node, lo, mid, pos, val);
        } else {
            update(2 * node + 1, mid + 1, hi, pos, val);
        }
        merge(node);
    }

    int[] query(int node, int lo, int hi, int ql, int qr) {
        if (ql <= lo && hi <= qr) {
            int[] r = new int[k + 1];
            for (int i = 0; i < k; i++) {
                r[i] = cnt[node][i];
            }
            r[k] = prod[node];
            return r;
        }
        int mid = (lo + hi) / 2;
        if (qr <= mid) {
            return query(2 * node, lo, mid, ql, qr);
        }
        if (ql > mid) {
            return query(2 * node + 1, mid + 1, hi, ql, qr);
        }
        int[] lc = query(2 * node, lo, mid, ql, qr);
        int[] rc = query(2 * node + 1, mid + 1, hi, ql, qr);
        int lp = lc[k];
        int[] c = new int[k + 1];
        for (int r = 0; r < k; r++) {
            c[r] += lc[r];
        }
        for (int rr = 0; rr < k; rr++) {
            if (rc[rr] > 0) {
                c[(int) (((long) lp * rr) % k)] += rc[rr];
            }
        }
        c[k] = (int) (((long) lp * rc[k]) % k);
        return c;
    }
}