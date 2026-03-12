class Solution {

    class d{
        int[] p,r;
        d(int n){
            p=new int[n];
            r=new int[n];
            for(int i=0;i<n;i++){
                p[i]=i;
            }
        }

        int f(int x){
            if(p[x]!=x){
                p[x]=f(p[x]);
            }
            return p[x];
        }

        boolean u(int a,int b){
            int x=f(a);
            int y=f(b);
            if(x==y){
                return false;
            }
            if(r[x]<r[y]){
                p[x]=y;
            }else if(r[x]>r[y]){
                p[y]=x;
            }else{
                p[y]=x;
                r[x]++;
            }
            return true;
        }
    }

    boolean c(int n,int[][] e,int k,int x){

        d d=new d(n);
        int u=0;
        int m=0;

        for(int[] a:e){
            if(a[3]==1){
                if(a[2]<x){
                    return false;
                }
                if(!d.u(a[0],a[1])){
                    return false;
                }
                m++;
            }
        }

        for(int[] a:e){
            if(a[3]==0){
                if(a[2]>=x){
                    if(d.u(a[0],a[1])){
                        m++;
                    }
                }
            }
        }

        for(int[] a:e){
            if(a[3]==0){
                if(a[2]<x && a[2]*2>=x){
                    if(d.u(a[0],a[1])){
                        u++;
                        m++;
                        if(u>k){
                            return false;
                        }
                    }
                }
            }
        }

        return m==n-1;
    }

    public int maxStability(int n,int[][] edges,int k){

        int l=1;
        int r=200000;
        int a=-1;

        while(l<=r){

            int m=l+(r-l)/2;

            if(c(n,edges,k,m)){
                a=m;
                l=m+1;
            }else{
                r=m-1;
            }
        }

        return a;
    }
}