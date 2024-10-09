class Solution {
    public int minAddToMakeValid(String s) {
        int n = s.length();
        Stack<Character> stack = new Stack<>();

        for(char ch: s.toCharArray()){
        
            if(!stack.isEmpty() && ch == ')' && stack.peek() == '('){
                stack.pop();
            }
            else{
                stack.push(ch);
            }
        }

        return stack.size();
    }
}
