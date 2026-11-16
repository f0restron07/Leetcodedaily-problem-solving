class Solution {
    public String digitSum(String s, int k) {
        while(s.length()>k){
            StringBuilder a=new StringBuilder();
            int n=s.length(),b=0;
            for(int i=0;i<n;i++){
                b+=s.charAt(i)-'0';
                if(i%k==k-1||i==n-1){
                    a.append(b);
                    b=0;
                }
            }
            s=a.toString();
        }
        return s;
    }
}