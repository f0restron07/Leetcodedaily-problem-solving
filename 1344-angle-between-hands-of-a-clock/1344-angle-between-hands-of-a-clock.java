class Solution {
    public double angleClock(int hour, int minutes) {
        double m=minutes*6.0;
        double h=(hour%12)*30.0+minutes*0.5;
        double d=Math.abs(h-m);
        return Math.min(d,360.0-d);
    }
}