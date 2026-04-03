class Solution {
    int[] walls;
    
    public int maxWalls(int[] robots, int[] distance, int[] walls) {
        int n=robots.length;
        this.walls=walls;
        Arrays.sort(walls);
        
        int[][] rd=new int[n][2];
        for(int i=0;i<n;i++){rd[i][0]=robots[i];rd[i][1]=distance[i];}
        Arrays.sort(rd,(a,b)->a[0]-b[0]);
        
        int[] L=new int[n],R=new int[n],ov=new int[n];
        
        for(int i=0;i<n;i++){
            int p=rd[i][0],d=rd[i][1];
            // L[i]
            if(i==0) L[i]=cnt(p-d,p,true,true);
            else{
                int prev=rd[i-1][0];
                if(p-d>prev) L[i]=cnt(p-d,p,true,true);
                else L[i]=cnt(prev,p,false,true);
            }
            // R[i]
            if(i==n-1) R[i]=cnt(p,p+d,true,true);
            else{
                int next=rd[i+1][0];
                if(p+d<next) R[i]=cnt(p,p+d,true,true);
                else R[i]=cnt(p,next,true,false);
            }
        }
        
        // overlap[i] = L[i] ∩ R[i-1]
        for(int i=1;i<n;i++){
            int p=rd[i][0],d=rd[i][1],prev=rd[i-1][0],pd=rd[i-1][1];
            int lLo=p-d>prev?p-d:prev;
            boolean lInc=p-d>prev;
            int rHi=prev+pd<p?prev+pd:p;
            boolean rInc=prev+pd<p;
            if(lLo<rHi||(lLo==rHi&&lInc&&rInc)) ov[i]=cnt(lLo,rHi,lInc,rInc);
        }
        
        int[][] dp=new int[n][2];
        dp[0][0]=L[0];dp[0][1]=R[0];
        for(int i=1;i<n;i++){
            dp[i][0]=Math.max(dp[i-1][0]+L[i],dp[i-1][1]+L[i]-ov[i]);
            dp[i][1]=Math.max(dp[i-1][0],dp[i-1][1])+R[i];
        }
        return Math.max(dp[n-1][0],dp[n-1][1]);
    }
    
    int cnt(int lo,int hi,boolean incLo,boolean incHi){
        int l=incLo?lb(lo):ub(lo);
        int r=incHi?ub(hi):lb(hi);
        return Math.max(0,r-l);
    }
    
    int lb(int t){
        int l=0,r=walls.length;
        while(l<r){int m=(l+r)/2;if(walls[m]<t)l=m+1;else r=m;}
        return l;
    }
    
    int ub(int t){
        int l=0,r=walls.length;
        while(l<r){int m=(l+r)/2;if(walls[m]<=t)l=m+1;else r=m;}
        return l;
    }
}