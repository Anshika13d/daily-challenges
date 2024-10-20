class Solution {
    public boolean parseBoolExpr(String s) {
        int n = s.length();
        Stack<Character> stack = new Stack<>();
        // t
        //

        for(int i=0;i<n;i++){
            char ch = s.charAt(i);
            if(ch != ')' && ch != ','){
                System.out.println(ch);
                stack.push(ch);
            }
            else if(ch == ')'){
                List<Integer> list = new ArrayList<>(); // 0
                int newC = 0; // 1
                while(!stack.isEmpty() && stack.peek() != '('){
                    list.add(stack.pop() == 'f' ? 0 : 1);
                }

                System.out.println(list);

                if(stack.peek() == '(') stack.pop();
                if(stack.peek() == '&' && list.size() > 0){
                    int and = list.get(0); //0
                    for(int j=1;j<list.size();j++){
                        int num = list.get(j);
                        and &= num;
                    }
                    newC = and; //0
                    System.out.println(newC);
                    stack.pop();
                }
                else if(stack.peek() == '|'){
                    for(int num: list){
                        newC |= num;
                    }
                    System.out.println(newC);
                    stack.pop();
                }
                else if(list.size() > 0){
                    if(list.get(0) == 0) newC = 1;
                    else newC = 0;
                    stack.pop();
                }
//! 
                if(newC == 0) {
                    stack.push('f');
                    System.out.println("pushed f");
                }
                else if(newC == 1) {
                    stack.push('t');
                    System.out.println("pushed t");
                }
            }
        }

        return stack.peek() == 't'? true : false;
    }
}
