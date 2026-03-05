class Solution {
    public int minOperations(String s) {
        int count0=0;
        StringBuilder sb=new StringBuilder(s);
        char cur=sb.charAt(0);
        char next='9';
        for(int i=1;i<sb.length();i++){
            next=sb.charAt(i);
            if(cur=='0'){
                if(next=='0'){
                    count0++;
                    sb.setCharAt(i,'1');
                }
            }
            else if(cur=='1'){
                if(next=='1'){
                    count0++;
                    sb.setCharAt(i,'0');
                }
            }
            cur=sb.charAt(i);
        }
        int count1=1;
        StringBuilder sb1=new StringBuilder(s);
        if(sb1.charAt(0)=='0') cur='1';
        else cur='0';
        for(int i=1;i<sb1.length();i++){
            next=sb1.charAt(i);
            if(cur=='0'){
                if(next=='0'){
                    count1++;
                    sb1.setCharAt(i,'1');
                }
            }
            else if(cur=='1'){
                if(next=='1'){
                    count1++;
                    sb1.setCharAt(i,'0');
                }
            }
            cur=sb1.charAt(i);
        }
        return Math.min(count0,count1);
    }
}