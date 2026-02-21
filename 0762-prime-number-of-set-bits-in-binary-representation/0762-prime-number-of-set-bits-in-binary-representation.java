class Solution {
    public int countPrimeSetBits(int left, int right) {
        int result = 0;
        final boolean[] primes = {
            false, false, true, true, false,
            true, false, true, false, false,
            false, true, false, true, false,
            false, false, true, false, true,
            false, false, true, false, false,
            false, false, false, true, false,
            true
        };
        for(; left<=right; left++) {
            if(primes[Integer.bitCount(left)]) 
                result++;
        }
        return result;
    }
}