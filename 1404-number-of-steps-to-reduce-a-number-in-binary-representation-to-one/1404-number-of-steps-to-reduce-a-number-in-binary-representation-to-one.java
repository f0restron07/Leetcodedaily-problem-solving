class Solution {
    public int numSteps(String s) {
        int i=s.length()-1;
        int count = 0;
        boolean one = false;
        while(i>0){
            char ch = s.charAt(i);
            if(ch=='1' || one){
                one = false;
                count+=2;
                i--;
                while(i>=0 && s.charAt(i)=='1'){
                    i--;
                    count++;
                }
                if(i>=0){
                    one = true;
                }
            }else if(ch=='0'){
                count++;
                i--;
            }
            
        }
        return count;
    }
}