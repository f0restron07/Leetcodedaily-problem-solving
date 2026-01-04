class Solution {
    public int sumFourDivisors(int[] nums) {
        int totalSum = 0;
        for(int num : nums){
            int sum = 0;
            int count = 0;
            for(int d = 1; d*d <= num;d++) {
                if(num % d == 0) {
                    int d1 = d;
                    int d2 = num/d;
                    sum += d1;
                    count++;
                    if(d1 != d2){
                        sum += d2;
                        count++;
                    }
                }
            }
            if(count == 4){
                totalSum += sum;
            }
        }
        return totalSum;
    }
}