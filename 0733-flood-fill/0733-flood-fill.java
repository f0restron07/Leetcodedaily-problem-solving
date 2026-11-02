class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int orignal = image[sr][sc];
        if (orignal == newColor) return image;
        dfs(orignal, image, sr, sc, newColor);
        return image;
    }
    public void dfs(int orignal,int[][]image,int sr,int sc,int newColor){
        if (sr < 0 || sc < 0 || sr >= image.length || sc >= image[0].length || image[sr][sc] != orignal) return;
        
        if(orignal==image[sr][sc]){
            image[sr][sc]=newColor;
        }
       
        dfs(orignal,image,sr-1,sc,newColor);
        dfs(orignal,image,sr+1,sc,newColor);
        dfs(orignal,image,sr,sc-1,newColor);
        dfs(orignal,image,sr,sc+1,newColor);
}
}