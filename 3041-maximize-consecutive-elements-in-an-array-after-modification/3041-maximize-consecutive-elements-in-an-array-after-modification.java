class Solution {
    public int maxSelectedElements(int[] nums) {
        Arrays.sort(nums);
        int[] a=new int[1000003];
        int n=nums.length,b=0;
        for(int i=0;i<n;i++){
            int c=nums[i];
            a[c+1]=a[c]+1;
            a[c]=a[c-1]+1;
            b=Math.max(b,Math.max(a[c],a[c+1]));
        }
        return b;
    }
}