class Solution {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        HashMap<Integer,Integer> rows=new HashMap<>();
        for(int[] r:reservedSeats){
            int seat=r[1];
            if(seat>=2&&seat<=9){
                rows.merge(r[0],1<<(seat-2),(a,b)->a|b);
            }
        }
        long total=(long)n*2;
        for(int mask:rows.values()){
            int left=0b1111;
            int mid=0b111100;
            int right=0b11110000;
            boolean l=(mask&left)==0;
            boolean m=(mask&mid)==0;
            boolean rt=(mask&right)==0;
            int got;
            if(l&&rt){
                got=2;
            }else if(l||m||rt){
                got=1;
            }else{
                got=0;
            }
            total-=(2-got);
        }
        return (int)total;
    }
}