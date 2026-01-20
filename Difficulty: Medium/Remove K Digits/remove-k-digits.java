class Solution {
    public String removeKdig(String s, int k) {
        // code here
        Stack<Character> st=new Stack<>();
        for(char c :s.toCharArray()){
            while(!st.isEmpty() && st.peek()>c && k>0){
                st.pop();
                k--;
            }
            st.push(c);
        }
        while(!st.isEmpty() && k>0){
            st.pop();
            k--;
        }
        StringBuilder sb=new StringBuilder();
        while(!st.isEmpty()){
            sb.append(st.pop());
        }
        sb.reverse();
    int idx=-1;
    for(int i=0;i<sb.length();i++){
        if(sb.charAt(i)!='0'){
            idx=i;
            break;
        }
    }
    if(idx==-1) return "0";
     return sb.substring(idx,sb.length()).toString();
    }
}