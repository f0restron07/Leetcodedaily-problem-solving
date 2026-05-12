class Solution {
    private boolean isPossible(int[][] tasks,int m){
        for(int i=0;i<tasks.length;i++){
            if(m >= tasks[i][1]){
                m = m - tasks[i][0];
            }
            else{
                return false;
            }
        }
        return true;
    }
    public int minimumEffort(int[][] tasks) {
        int n = tasks.length;
        Arrays.sort(tasks, (a, b) -> {
            int diffA = a[1] - a[0];
            int diffB = b[1] - b[0];
            return diffB - diffA; // descending order
        });
        int l = -1,r = 0;
        for(int i=0;i<n;i++){
            l = Math.max(l,tasks[i][1]);
            r = r + tasks[i][1];
        } 
        int ans = r;
        while(l<=r){
            int m = (l+r)/2; 
            if(isPossible(tasks, m)){
                ans = m;
                r = m-1;
            }
            else{
                l = m+1;
            }
        }
        return ans;
    }
}