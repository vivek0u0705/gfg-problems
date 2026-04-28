class Solution {
    public static String minWindow(String s, String t) {
        // code here
        int n=s.length();
        int si=-1;
        int[] ch=new int[26];
        int[] chh=new int[26];
        for(int j=0;j<t.length();j++) ch[t.charAt(j)-'a']++;
        int l=0;
        int minL=(int)1e9;
        for(int r=0;r<n;r++){
            char c=s.charAt(r);
            chh[c-'a']++;
            while(contains(chh,ch)){
                if(r-l+1<minL){
                    minL=r-l+1;
                    si=l;
                }
                chh[s.charAt(l)-'a']--;
                l++;
            }
        }
        if(si==-1) return "";
    return s.substring(si,si+minL);
    }
    public static boolean contains(int[] chh,int ch[]){
        for(int i=0;i<26;i++){
            if(chh[i]<ch[i]) return false;
        }
    return true;
    }
}