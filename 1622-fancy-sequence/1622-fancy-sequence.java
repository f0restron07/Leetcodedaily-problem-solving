class Fancy {
    private static final long MOD = 1_000_000_007L;
    private List<Long> seq;
    private long mult, add;

    public Fancy() {
        seq = new ArrayList<>();
        mult = 1;
        add = 0;
    }
    
    public void append(int val) {
        // Store inverse-transformed value
        long v = ((val - add) % MOD + MOD) % MOD;
        v = v * modPow(mult, MOD - 2) % MOD;
        seq.add(v);
    }
    
    public void addAll(int inc) {
        add = (add + inc) % MOD;
    }
    
    public void multAll(int m) {
        mult = mult * m % MOD;
        add = add * m % MOD;
    }
    
    public int getIndex(int idx) {
        if (idx >= seq.size()) return -1;
        return (int)((seq.get(idx) * mult + add) % MOD);
    }
    
    private long modPow(long b, long e) {
        long r = 1;
        b %= MOD;
        while (e > 0) {
            if ((e & 1) == 1) r = r * b % MOD;
            b = b * b % MOD;
            e >>= 1;
        }
        return r;
    }
}

/**
 * Your Fancy object will be instantiated and called as such:
 * Fancy obj = new Fancy();
 * obj.append(val);
 * obj.addAll(inc);
 * obj.multAll(m);
 * int param_4 = obj.getIndex(idx);
 */