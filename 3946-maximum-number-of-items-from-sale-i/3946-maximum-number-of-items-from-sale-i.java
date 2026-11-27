class Solution {
    public int maximumSaleItems(int[][] items, int budget) {
        int n=items.length;
        int[] a=new int[1501];
        int b=1500;
        for(int i=0;i<n;i++){
            a[items[i][0]]++;
            b=Math.min(b,items[i][1]);
        }
        int[] c=new int[budget+1];
        for(int i=0;i<n;i++){
            int d=0;
            for(int j=items[i][0];j<=1500;j+=items[i][0]){
                d+=a[j];
            }
            for(int j=budget;j>=items[i][1];j--){
                c[j]=Math.max(c[j],c[j-items[i][1]]+d);
            }
        }
        int e=0;
        for(int i=0;i<=budget;i++){
            e=Math.max(e,c[i]+(budget-i)/b);
        }
        return e;
    }
}