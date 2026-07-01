class Solution{
    int[]f;
    int r(int x){
        while(f[x]!=x){f[x]=f[f[x]];x=f[x];}
        return x;
    }
    public int maximumSafenessFactor(List<List<Integer>>a){
        int b=a.size();
        int[][]c=new int[b][b];
        for(int[]d:c){Arrays.fill(d,-1);}
        ArrayDeque<int[]>e=new ArrayDeque<>();
        for(int i=0;i<b;i++){
            for(int j=0;j<b;j++){
                if(a.get(i).get(j)==1){c[i][j]=0;e.add(new int[]{i,j});}
            }
        }
        int[]g={-1,1,0,0};
        int[]h={0,0,-1,1};
        while(!e.isEmpty()){
            int[]k=e.poll();
            for(int l=0;l<4;l++){
                int m=k[0]+g[l];
                int o=k[1]+h[l];
                if(m>=0&&m<b&&o>=0&&o<b&&c[m][o]==-1){
                    c[m][o]=c[k[0]][k[1]]+1;
                    e.add(new int[]{m,o});
                }
            }
        }
        f=new int[b*b];
        for(int i=0;i<b*b;i++){f[i]=i;}
        boolean[]q=new boolean[b*b];
        int s=0;
        for(int i=0;i<b;i++){
            for(int j=0;j<b;j++){
                if(c[i][j]>s){s=c[i][j];}
            }
        }
        List<List<Integer>>t=new ArrayList<>();
        for(int i=0;i<=s;i++){t.add(new ArrayList<>());}
        for(int i=0;i<b;i++){
            for(int j=0;j<b;j++){
                t.get(c[i][j]).add(i*b+j);
            }
        }
        for(int u=s;u>=0;u--){
            for(int v:t.get(u)){
                q[v]=true;
                int w=v/b;
                int x=v%b;
                for(int y=0;y<4;y++){
                    int k=w+g[y];
                    int l=x+h[y];
                    if(k>=0&&k<b&&l>=0&&l<b&&q[k*b+l]){
                        f[r(k*b+l)]=r(v);
                    }
                }
            }
            if(q[0]&&q[b*b-1]&&r(0)==r(b*b-1)){return u;}
        }
        return 0;
    }
}