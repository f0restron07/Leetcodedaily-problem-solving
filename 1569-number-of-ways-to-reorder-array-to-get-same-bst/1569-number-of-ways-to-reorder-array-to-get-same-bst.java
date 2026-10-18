class Solution {
    long MOD=1000000007;
    long[][] C;
    public int numOfWays(int[] nums) {
        int n=nums.length;
        C=new long[n+1][n+1];
        for(int i=0;i<=n;i++){
            C[i][0]=1;
            for(int j=1;j<=i;j++){
                C[i][j]=(C[i-1][j-1]+C[i-1][j])%MOD;
            }
        }
        List<Integer> list=new ArrayList<>();
        for(int x:nums){
            list.add(x);
        }
        long ways=count(list);
        return (int)((ways-1+MOD)%MOD);
    }
    long count(List<Integer> nums){
        int n=nums.size();
        if(n<=2){
            return 1;
        }
        int root=nums.get(0);
        List<Integer> left=new ArrayList<>();
        List<Integer> right=new ArrayList<>();
        for(int i=1;i<n;i++){
            if(nums.get(i)<root){
                left.add(nums.get(i));
            }else{
                right.add(nums.get(i));
            }
        }
        long l=count(left);
        long r=count(right);
        return C[left.size()+right.size()][left.size()]*l%MOD*r%MOD;
    }
}