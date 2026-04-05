class Solution {
    public String shortestPalindrome(String s) {
        int n=s.length();
        String r=new StringBuilder(s).reverse().toString();
        String str=s+"#"+r;
        int[] lps=new int[str.length()];
        int len=build(str,lps);
        String rem=s.substring(len);
        String rev=new StringBuilder(rem).reverse().toString();
    return rev+s;
    }
    public static int build(String s,int lps[]) {
        int n=s.length();
        int len=0;
        int i=1;
        while(i<n){
            if(s.charAt(i)==s.charAt(len)){
                len++;
                lps[i]=len;
                i++;
            }
            else{
                if(len!=0){
                    len=lps[len-1];
                }
                else if(len==0){
                    lps[i]=0;
                    i++;
                }
            }
        }
    return lps[n-1];
    }
}