class Solution {
    public int minOperations(String s, int k) {
        int zeroCount = 0;
        int n = s.length();
        for (char c : s.toCharArray()){
            if (c == '0') zeroCount++;
        }
        if (zeroCount == 0) return 0;
        for (int m = 1; m <= n; m++){
            long totalFlip = (long) m * k;
            if ((totalFlip-zeroCount)%2 !=0 || totalFlip < zeroCount) continue;
            long maxZeroFlip = m%2==1? m*zeroCount : (m-1)*zeroCount;
            long maxOneFlip = m%2==1? (m-1)*(n-zeroCount) : m*(n-zeroCount);
            if (totalFlip <= maxOneFlip+maxZeroFlip) return m;
        }
        return -1;
    }
}