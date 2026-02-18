class Solution {
    public boolean hasAlternatingBits(int n) {
        
        ArrayList<Integer> bits = new ArrayList<>();

        while (n > 0) {
            bits.add(n % 2);
            n = n / 2;
        }

        for (int i = 1; i < bits.size(); i++) {
            if (bits.get(i) == bits.get(i - 1)) {
                return false;
            }
        }
        
        return true;
    }
}
