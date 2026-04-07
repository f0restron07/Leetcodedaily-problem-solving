class Robot {
    private int w,h,k;
    private int currPos;
    private boolean isFirst;

    public Robot(int width, int height) {
        w = width;
        h = height;
        k = 2 * (w + h - 2);
        currPos = 0;
        isFirst = true;
    }
    
    public void step(int num){
        isFirst = false;
        currPos = (currPos + num) % k;
    }
    
    public int[] getPos() {
        if(0 <= currPos && currPos < w) return new int[]{currPos,0};
        if(w <= currPos && currPos < w + h - 1) return new int[]{w - 1,currPos - w + 1};
        if(w + h - 1 <= currPos && currPos < 2 * w + h - 2) return new int[]{2 * w + h - 3 - currPos,h - 1};
        int y = currPos == 0 ? 0 : k - currPos;
        return new int[]{0,y};
    }
    
    public String getDir() {
        if(currPos == 0) return isFirst ? "East" : "South";
        if(0 <= currPos && currPos < w) return "East";
        if(w <= currPos && currPos < w + h - 1) return "North";
        if(w + h - 1 <= currPos && currPos < 2 * w + h - 2) return "West";
        return "South";
    }
}