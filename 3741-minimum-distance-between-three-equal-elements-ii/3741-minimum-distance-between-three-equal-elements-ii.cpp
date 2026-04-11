class Solution{
public:
    int minimumDistance(vector<int>& nums){
        int n=nums.size(),a=INT_MAX;
        vector<int> b(n+1,-1),c(n+1,-1);
        for(int i=0;i<n;i++){
            int v=nums[i];
            if(b[v]!=-1&&c[v]!=-1){
                a=min(a,i-c[v]);
            }
            c[v]=b[v];
            b[v]=i;
        }
        return a==INT_MAX?-1:2*a;
    }
};