class Solution {
    public String smallestSubsequence(String s) {
        int n=s.length();
        int[] last=new int[26];
        for(int i=0;i<n;i++){
            last[s.charAt(i)-'a']=i;
        }
        // for(int i=0;i<26;i++){
        //     if(last[i]!=0) System.out.println(last[i]);
        // }
        Stack<Character> st=new Stack<>();
        HashSet<Character> hs=new HashSet<>();
        for(int i=0;i<n;i++){
            char ch=s.charAt(i);
            if(hs.contains(ch)) continue;
            while(!st.isEmpty() && st.peek()>ch && last[st.peek()-'a']>i){
                hs.remove(st.peek());
                st.pop();
            }
            hs.add(ch);
            st.push(ch);
        }
        String res="";
        while(!st.isEmpty()){
            res=st.peek()+res;
            st.pop();
        }
    return res;
    }
}