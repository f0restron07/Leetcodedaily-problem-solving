class Solution {
    public int numOfSubarrays(int[] arr) {
        int a=1,b=0,c=0;
        long d=0,e=1000000007;
        for(int i=0;i<arr.length;i++){
            c=(c+arr[i])%2;
            if(c==1){
                d+=a;
                b++;
            }else{
                d+=b;
                a++;
            }
        }
        return (int)(d%e);
    }
}