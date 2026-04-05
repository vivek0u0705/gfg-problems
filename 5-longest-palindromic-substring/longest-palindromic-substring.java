class Solution {
    public String longestPalindrome(String s) {
      int n=s.length();
      int l=0;
      int r=0;
      for(int i=0;i<n;i++){
        int lp=f(s,i,i);
        int rp=f(s,i,i+1);
        int len=Math.max(lp,rp);
        if(len>r-l){
            r=i+len/2;
            l=i-(len-1)/2;
        }
      }
    return s.substring(l,r+1);
    }
    public static int f(String s,int l,int r){
        while(l>=0 && r<s.length() && s.charAt(l)==s.charAt(r)){
            l--;
            r++;
        }
    return r-l-1;
    }
}