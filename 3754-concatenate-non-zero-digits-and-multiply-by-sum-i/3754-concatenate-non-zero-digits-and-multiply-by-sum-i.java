class Solution {
    public long sumAndMultiply(int n) {
        String str=Integer.toString(n);
        StringBuilder sb=new StringBuilder();
        for (char c : str.toCharArray()) {
            if (c != '0') {
                sb.append(c);
            }
        }
        if (sb.length() == 0) {
            return 0;
        }
        int x=Integer.parseInt(sb.toString());
        int sum=0;
        int temp=x;
        while (temp != 0) {
            int digit = temp % 10;
            sum += digit;
            temp/= 10;
        }
        long ggs=(long)x*sum;
        return ggs;
    }
}