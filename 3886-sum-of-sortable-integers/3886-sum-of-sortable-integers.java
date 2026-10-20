class Solution {
    public int sortableIntegers(int[] nums) {
        int n=nums.length;
        int[] sorted=nums.clone();
        Arrays.sort(sorted);
        long sum=0;
        for(int k=1;k<=n;k++){
            if(n%k!=0){
                continue;
            }
            boolean ok=true;
            for(int start=0;start<n&&ok;start+=k){
                if(!rotationKMP(nums,sorted,start,k)){
                    ok=false;
                }
            }
            if(ok){
                sum+=k;
            }
        }
        return (int)sum;
    }
    boolean rotationKMP(int[] a,int[] b,int start,int k){
        int[] pat=new int[k];
        for(int i=0;i<k;i++){
            pat[i]=b[start+i];
        }
        int[] lps=new int[k];
        for(int i=1,len=0;i<k;){
            if(pat[i]==pat[len]){
                lps[i++]=++len;
            }else if(len>0){
                len=lps[len-1];
            }else{
                lps[i++]=0;
            }
        }
        int j=0;
        for(int i=0;i<2*k;i++){
            int c=a[start+(i%k)];
            while(j>0&&c!=pat[j]){
                j=lps[j-1];
            }
            if(c==pat[j]){
                j++;
            }
            if(j==k){
                return true;
            }
        }
        return false;
    }
}