class Solution {
    public String decodeCiphertext(String encodedText, int rows) {
        int a=encodedText.length();
        if(a==0){
            return "";
        }
        int b=a/rows;
        StringBuilder c=new StringBuilder();
        for(int i=0;i<b;i++){
            for(int j=0;j<rows&&i+j<b;j++){
                int d=j*b+i+j;
                c.append(encodedText.charAt(d));
            }
        }
        int e=c.length()-1;
        while(e>=0&&c.charAt(e)==' '){
            e--;
        }
        return c.substring(0,e+1);
    }
}