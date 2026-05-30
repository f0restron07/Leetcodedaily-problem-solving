class Solution {
    int[] t;
    int N;
    void upd(int p,int v,int n,int l,int r){
        if(l==r){t[n]=v;return;}
        int m=(l+r)/2;
        if(p<=m)upd(p,v,2*n,l,m);
        else upd(p,v,2*n+1,m+1,r);
        t[n]=Math.max(t[2*n],t[2*n+1]);
    }
    int qry(int ql,int qr,int n,int l,int r){
        if(ql>r||qr<l)return 0;
        if(ql<=l&&r<=qr)return t[n];
        int m=(l+r)/2;
        return Math.max(qry(ql,qr,2*n,l,m),qry(ql,qr,2*n+1,m+1,r));
    }
    public List<Boolean> getResults(int[][] queries){
        N=0;
        for(int[] q:queries)N=Math.max(N,q[1]);
        N++;
        t=new int[4*N];
        TreeSet<Integer> s=new TreeSet<>();
        s.add(0);
        List<Boolean> res=new ArrayList<>();
        for(int[] q:queries){
            if(q[0]==1){
                int x=q[1];
                Integer p=s.lower(x),nx=s.higher(x);
                s.add(x);
                upd(x,x-p,1,0,N-1);
                if(nx!=null)upd(nx,nx-x,1,0,N-1);
            }else{
                int x=q[1],sz=q[2];
                Integer p=s.floor(x);
                int mx=Math.max(qry(0,x,1,0,N-1),x-p);
                res.add(mx>=sz);
            }
        }
        return res;
    }
}