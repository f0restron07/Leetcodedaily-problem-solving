class Solution {
    public int scoreOfParentheses(String s) {
        Deque<Integer> stack=new ArrayDeque<>();
        stack.push(0);
        for(char c:s.toCharArray()){
            if(c=='('){
                stack.push(0);
            }else{
                int v=stack.pop();
                int add=Math.max(2*v,1);
                stack.push(stack.pop()+add);
            }
        }
        return stack.pop();
    }
}