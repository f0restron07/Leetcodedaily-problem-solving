class Solution {
    public boolean canBeEqual(String s1,String s2) {
        char a=s1.charAt(0),b=s1.charAt(1),c=s1.charAt(2),d=s1.charAt(3);
        char e=s2.charAt(0),f=s2.charAt(1),g=s2.charAt(2),h=s2.charAt(3);
        return ((a==e&&c==g)||(a==g&&c==e))&&((b==f&&d==h)||(b==h&&d==f));
    }
}