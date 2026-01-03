class Solution {
    public int numOfWays(int n) {
        long MOD = 1_000_000_007;

     
        long typeA = 6; 
        long typeB = 6; 

        for (int i = 2; i <= n; i++) {
            long newTypeA = (typeA * 2 + typeB * 2) % MOD;
            long newTypeB = (typeA * 2 + typeB * 3) % MOD;

            typeA = newTypeA;
            typeB = newTypeB;
        }

        return (int) ((typeA + typeB) % MOD);
    }
}
