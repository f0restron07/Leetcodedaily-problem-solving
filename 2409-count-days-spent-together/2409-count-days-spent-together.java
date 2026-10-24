class Solution {
    public int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {
        int[] a = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int b = toDay(arriveAlice, a);
        int c = toDay(leaveAlice, a);
        int d = toDay(arriveBob, a);
        int e = toDay(leaveBob, a);
        int f = Math.max(b, d);
        int g = Math.min(c, e);
        return Math.max(0, g - f + 1);
    }
    int toDay(String s, int[] a) {
        int h = Integer.parseInt(s.substring(0, 2));
        int i = Integer.parseInt(s.substring(3));
        int j = i;
        for (int k = 0; k < h - 1; k++) {
            j += a[k];
        }
        return j;
    }
}