class Solution {
    public int sumFourDivisors(int[] nums) {
        int result = 0;
        for (int num : nums) {
            int sum = 0, count = 0;
            for (int i = 1; i * i <= num; i++) {
                if (num % i == 0) {
                    count++;
                    sum += i;
                    if (i != num / i) {
                        count++;
                        sum += num / i;
                    }
                }
                if (count > 4) break;
            }
            if (count == 4) result += sum;
        }
        return result;
    }
}