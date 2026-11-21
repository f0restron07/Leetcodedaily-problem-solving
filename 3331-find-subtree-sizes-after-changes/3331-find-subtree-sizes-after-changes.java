class Solution {
    public int[] findSubtreeSizes(int[] parent, String s) {
        int n=parent.length;
        List<Integer>[] a=new List[n];
        for(int i=0;i<n;i++){
            a[i]=new ArrayList<>();
        }
        for(int i=1;i<n;i++){
            a[parent[i]].add(i);
        }
        int[] b=new int[n],c=new int[26],d=new int[n],e=new int[2*n];
        Arrays.fill(c,-1);
        int f=0;
        e[f++]=0;
        while(f>0){
            int g=e[--f];
            if(g>=0){
                int h=s.charAt(g)-'a';
                d[g]=c[h];
                c[h]=g;
                b[g]=1;
                e[f++]=-g-1;
                for(int i:a[g]){
                    e[f++]=i;
                }
            }else{
                g=-g-1;
                c[s.charAt(g)-'a']=d[g];
                int h=d[g]>=0?d[g]:parent[g];
                if(h>=0){
                    b[h]+=b[g];
                }
            }
        }
        return b;
    }
}