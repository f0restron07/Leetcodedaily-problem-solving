class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        String s="123456789";
        List<Integer> res=new ArrayList<>();
        for(int len=2;len<=9;len++){
            for(int i=0;i+len<=9;i++){
                int v=Integer.parseInt(s.substring(i,i+len));
                if(v>=low&&v<=high){
                    res.add(v);
                }
            }
        }
        Collections.sort(res);
        return res;
    }
}