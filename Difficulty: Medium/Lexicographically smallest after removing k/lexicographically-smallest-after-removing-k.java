class Solution {
    public String lexicographicallySmallest(String s, int k) {
        // code here
        int n=s.length();
        if(n<k) return "-1";
        if((n&(n-1))==0){ // is 2 power
            k=k/2;
        }
        else{
            k=k*2;
        }
        if(n<=k) return "-1";
        int len=n-k;
        Stack<Character> st=new Stack<>();
        for(int i=0;i<n;i++){
            char c=s.charAt(i);
            while(!st.isEmpty() && (st.peek()>c &&
                                (n-i)+(st.size()-1)>=len)){
                st.pop();
            }
            st.push(c);
        }
        if(st.isEmpty()) return "-1";
        String str="";
        while(!st.isEmpty()){
            str=st.pop() + str;
        }
        String fs="";
        for(int i=0;i<len;i++){
            fs+=str.charAt(i);
        }
    return fs;
    }
}