class Solution {
    public char findKthBit(int n,int k){
        if(n==1)return '0';
        int m=1<<(n-1);
        if(k==m)return '1';
        if(k<m)return findKthBit(n-1,k);
        return findKthBit(n-1,2*m-k)=='0'?'1':'0';
    }
}