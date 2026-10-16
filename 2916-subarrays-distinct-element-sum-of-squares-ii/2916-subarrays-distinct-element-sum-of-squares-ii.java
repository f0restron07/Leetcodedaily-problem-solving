class Solution {
    long[] sumD, sumSq, lazy, cnt;
    int n;
    public int sumCounts(int[] nums) {
        final long MOD=1000000007;
        n=nums.length;
        sumD=new long[4*n];
        sumSq=new long[4*n];
        lazy=new long[4*n];
        cnt=new long[4*n];
        HashMap<Integer,Integer> last=new HashMap<>();
        long ans=0;
        for(int j=0;j<n;j++){
            activate(1,0,n-1,j);
            int l=last.getOrDefault(nums[j],-1)+1;
            update(1,0,n-1,l,j,1);
            last.put(nums[j],j);
            ans=(ans+sumSq[1])%MOD;
        }
        return (int)(ans%MOD);
    }
    void apply(int node,long add){
        final long MOD=1000000007;
        sumSq[node]=(sumSq[node]+2*add%MOD*sumD[node]+add*add%MOD*cnt[node])%MOD;
        sumD[node]=(sumD[node]+add*cnt[node])%MOD;
        lazy[node]+=add;
    }
    void push(int node){
        if(lazy[node]!=0){
            apply(2*node,lazy[node]);
            apply(2*node+1,lazy[node]);
            lazy[node]=0;
        }
    }
    void pull(int node){
        final long MOD=1000000007;
        cnt[node]=cnt[2*node]+cnt[2*node+1];
        sumD[node]=(sumD[2*node]+sumD[2*node+1])%MOD;
        sumSq[node]=(sumSq[2*node]+sumSq[2*node+1])%MOD;
    }
    void activate(int node,int lo,int hi,int pos){
        if(lo==hi){
            cnt[node]=1;
            return;
        }
        push(node);
        int mid=(lo+hi)/2;
        if(pos<=mid){
            activate(2*node,lo,mid,pos);
        }else{
            activate(2*node+1,mid+1,hi,pos);
        }
        pull(node);
    }
    void update(int node,int lo,int hi,int l,int r,long add){
        if(r<lo||hi<l){
            return;
        }
        if(l<=lo&&hi<=r){
            apply(node,add);
            return;
        }
        push(node);
        int mid=(lo+hi)/2;
        update(2*node,lo,mid,l,r,add);
        update(2*node+1,mid+1,hi,l,r,add);
        pull(node);
    }
}