class Solution {
    int[] arr;
    int[] starts;
    int[] nxt;
    List<List<Integer>> iv;
    long[][] bestScore;
    int[][][] bestIdx;
    boolean[][] done;
    int n;

    public int[] maximumWeight(List<List<Integer>> intervals) {
        iv=intervals;
        n=intervals.size();
        Integer[] order=new Integer[n];
        for(int i=0;i<n;i++){
            order[i]=i;
        }
        Arrays.sort(order,(a,b)->{
            int la=iv.get(a).get(0),lb=iv.get(b).get(0);
            if(la!=lb) return Integer.compare(la,lb);
            return Integer.compare(iv.get(a).get(1),iv.get(b).get(1));
        });
        arr=new int[n];
        starts=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=order[i];
            starts[i]=iv.get(arr[i]).get(0);
        }
        nxt=new int[n];
        for(int i=0;i<n;i++){
            int e=iv.get(arr[i]).get(1);
            nxt[i]=upperBound(starts,e);
        }
        bestScore=new long[n+1][5];
        bestIdx=new int[n+1][5][];
        done=new boolean[n+1][5];
        int[] res=dp(0,4);
        return res;
    }

    int upperBound(int[] a,int key){
        int lo=0,hi=a.length;
        while(lo<hi){
            int mid=(lo+hi)/2;
            if(a[mid]<=key) lo=mid+1;
            else hi=mid;
        }
        return lo;
    }

    long scoreOf(int[] idx){
        long s=0;
        for(int x:idx) s+=iv.get(x).get(2);
        return s;
    }

    int[] dp(int i,int j){
        if(i>=n||j==0) return new int[0];
        if(done[i][j]) return bestIdx[i][j];
        done[i][j]=true;
        int[] skip=dp(i+1,j);
        long skipScore=scoreOf(skip);
        int[] sub=dp(nxt[i],j-1);
        int[] take=new int[sub.length+1];
        for(int t=0;t<sub.length;t++) take[t]=sub[t];
        take[sub.length]=arr[i];
        Arrays.sort(take);
        long takeScore=scoreOf(take);
        int[] best;
        if(takeScore>skipScore){
            best=take;
        }else if(takeScore<skipScore){
            best=skip;
        }else{
            best=lexSmaller(take,skip)?take:skip;
        }
        bestIdx[i][j]=best;
        bestScore[i][j]=scoreOf(best);
        return best;
    }

    boolean lexSmaller(int[] a,int[] b){
        int m=Math.min(a.length,b.length);
        for(int i=0;i<m;i++){
            if(a[i]!=b[i]) return a[i]<b[i];
        }
        return a.length<=b.length;
    }
}