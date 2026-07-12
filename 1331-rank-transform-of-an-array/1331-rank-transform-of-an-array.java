class Solution {
    public int[] arrayRankTransform(int[] arr) {
        int n=arr.length;
        int[] s=arr.clone();
        Arrays.sort(s);
        HashMap<Integer,Integer> m=new HashMap<>();
        int r=1;
        for(int x:s){
            if(!m.containsKey(x)){
                m.put(x,r++);
            }
        }
        int[] a=new int[n];
        for(int i=0;i<n;i++){
            a[i]=m.get(arr[i]);
        }
        return a;
    }
}