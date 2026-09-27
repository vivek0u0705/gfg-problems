class Solution {
    public String reverseParentheses(String s) {
        int n=s.length();
        Stack<String> st=new Stack<>();
        for(char ch:s.toCharArray()){
            if(ch==')'){
                String sub="";
                while(!st.isEmpty() && !st.peek().equals("(")){
                    String sb=new StringBuilder(st.pop()).reverse().toString();
                    sub+=sb;
                }
                if(!st.isEmpty() && st.peek().equals("(")) st.pop();
                st.push(sub);
            }
            else st.push(ch+"");
        }
        String ans="";
        while(!st.isEmpty()){
            ans=st.pop()+ans;
        }
    return ans;
    }
}
// when '('  insert into stack
//when ')' pop all upto reach '(' then make that string add again into stack without brackets
//while poping every string take it reverse