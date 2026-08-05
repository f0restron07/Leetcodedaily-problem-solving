class Solution {
    public List<Integer> remainingMethods(int n, int k, int[][] invocations) {
        List<List<Integer>> g=new ArrayList<>();
        for(int i=0;i<n;i++){
            g.add(new ArrayList<>());
        }
        for(int[] e:invocations){
            g.get(e[0]).add(e[1]);
        }
        boolean[] sus=new boolean[n];
        Deque<Integer> st=new ArrayDeque<>();
        st.push(k);
        sus[k]=true;
        while(!st.isEmpty()){
            int u=st.pop();
            for(int v:g.get(u)){
                if(!sus[v]){
                    sus[v]=true;
                    st.push(v);
                }
            }
        }
        for(int[] e:invocations){
            if(!sus[e[0]]&&sus[e[1]]){
                List<Integer> all=new ArrayList<>();
                for(int i=0;i<n;i++){
                    all.add(i);
                }
                return all;
            }
        }
        List<Integer> res=new ArrayList<>();
        for(int i=0;i<n;i++){
            if(!sus[i]){
                res.add(i);
            }
        }
        return res;
    }
}