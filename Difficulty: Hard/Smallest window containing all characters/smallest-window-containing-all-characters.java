class Solution {
    public static String minWindow(String s, String t) {
        // code here
        int n=s.length();
        int ml=(int)1e9;
        int si=-1;
        int[] ch=new int[256];
        for(int j=0;j<t.length();j++) ch[t.charAt(j)]++;
        int ct=0;
        int l=0;
        for(int r=0;r<n;r++){
            char c=s.charAt(r);
            if(ch[c]>0) ct++;
            ch[c]--;
            while(l<=r && ct==t.length()){
                if(r-l+1<ml){
                    ml=r-l+1;
                    si=l;
                }
                ch[s.charAt(l)]++;
                if(ch[s.charAt(l)]>0) ct=ct-1;
                l++;
            }
        }
        if(si==-1) return "";
    return s.substring(si,si+ml);
    }
}