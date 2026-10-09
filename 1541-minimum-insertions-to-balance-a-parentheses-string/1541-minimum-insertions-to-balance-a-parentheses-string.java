class Solution {
    public int minInsertions(String s) {
        int open=0;
        int ins=0;
        int i=0;
        int n=s.length();
        while(i<n){
            char c=s.charAt(i);
            if(c=='('){
                open++;
                i++;
            }else{
                if(i+1<n&&s.charAt(i+1)==')'){
                    i+=2;
                }else{
                    ins++;
                    i++;
                }
                if(open>0){
                    open--;
                }else{
                    ins++;
                }
            }
        }
        return ins+open*2;
    }
}