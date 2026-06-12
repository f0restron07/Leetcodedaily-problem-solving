class Solution {
    public int[] assignEdgeWeights(int[][] edges, int[][] queries) {
        int a=edges.length+1;
        int b=1;
        while((1<<b)<a){
            b++;
        }
        List<Integer>[] c=new List[a+1];
        for(int i=1;i<=a;i++){
            c[i]=new ArrayList<>();
        }
        for(int i=0;i<edges.length;i++){
            c[edges[i][0]].add(edges[i][1]);
            c[edges[i][1]].add(edges[i][0]);
        }
        int[] d=new int[a+1];
        int[][] e=new int[b+1][a+1];
        Arrays.fill(d,-1);
        ArrayDeque<Integer> f=new ArrayDeque<>();
        f.add(1);
        d[1]=0;
        e[0][1]=1;
        while(!f.isEmpty()){
            int g=f.poll();
            for(int k:c[g]){
                if(d[k]<0){
                    d[k]=d[g]+1;
                    e[0][k]=g;
                    f.add(k);
                }
            }
        }
        for(int i=1;i<=b;i++){
            for(int j=1;j<=a;j++){
                e[i][j]=e[i-1][e[i-1][j]];
            }
        }
        long h=1000000007L;
        long[] p=new long[a+1];
        p[0]=1;
        for(int i=1;i<=a;i++){
            p[i]=(p[i-1]*2)%h;
        }
        int q=queries.length;
        int[] r=new int[q];
        for(int i=0;i<q;i++){
            int s=queries[i][0];
            int t=queries[i][1];
            int u=lca(s,t,d,e,b);
            int v=d[s]+d[t]-2*d[u];
            if(v==0){
                r[i]=0;
            } else {
                r[i]=(int)p[v-1];
            }
        }
        return r;
    }

    private int lca(int a,int b,int[] c,int[][] d,int e){
        if(c[a]<c[b]){
            int f=a;
            a=b;
            b=f;
        }
        int g=c[a]-c[b];
        for(int i=0;i<=e;i++){
            if(((g>>i)&1)==1){
                a=d[i][a];
            }
        }
        if(a==b){
            return a;
        }
        for(int i=e;i>=0;i--){
            if(d[i][a]!=d[i][b]){
                a=d[i][a];
                b=d[i][b];
            }
        }
        return d[0][a];
    }
}