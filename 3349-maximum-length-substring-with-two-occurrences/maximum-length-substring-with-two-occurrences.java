class Solution {
    public int maximumLengthSubstring(String s) {
        char[] ch=new char[26];
        int l=0;
        int m=0;
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            ch[c-'a']++;
            while(ch[c-'a']>2){
                int lc=s.charAt(l);
                ch[lc-'a']--;
                l++;
            }
            m=Math.max(m,i-l+1);
        }
    return m;
    }
}