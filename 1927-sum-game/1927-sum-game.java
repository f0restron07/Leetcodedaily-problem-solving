class Solution {
    public boolean sumGame(String num) {
        int n=num.length();
        int half=n/2;
        int s1=0;
        int s2=0;
        int q1=0;
        int q2=0;
        for(int i=0;i<half;i++){
            char c=num.charAt(i);
            if(c=='?'){
                q1++;
            }else{
                s1+=c-'0';
            }
        }
        for(int i=half;i<n;i++){
            char c=num.charAt(i);
            if(c=='?'){
                q2++;
            }else{
                s2+=c-'0';
            }
        }
        if((q1+q2)%2==1){
            return true;
        }
        int diff=s1-s2;
        int qd=(q2-q1)/2;
        return qd*9!=diff;
    }
}