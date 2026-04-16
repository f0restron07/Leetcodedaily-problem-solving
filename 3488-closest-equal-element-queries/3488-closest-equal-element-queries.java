class Solution {
    public List<Integer> solveQueries(int[] a, int[] q) {
        int n=a.length;
        Map<Integer,List<Integer>> m=new HashMap<>();
        
   
        for(int i=0;i<n;i++){
            m.computeIfAbsent(a[i],k->new ArrayList<>()).add(i);
        }
        

        int[] dist=new int[n];
        Arrays.fill(dist,-1);
        
        for(List<Integer> l:m.values()){
            int sz=l.size();
            if(sz==1) continue;
            
            for(int j=0;j<sz;j++){
                int curr=l.get(j);
                int left=l.get((j-1+sz)%sz);
                int right=l.get((j+1)%sz);
                
    
                int d1=Math.min(Math.abs(curr-left),n-Math.abs(curr-left));
                int d2=Math.min(Math.abs(curr-right),n-Math.abs(curr-right));
                
                dist[curr]=Math.min(d1,d2);
            }
        }
        
        List<Integer> ans=new ArrayList<>();
        for(int i:q){
            ans.add(dist[i]);
        }
        return ans;
    }
}