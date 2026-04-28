class Solution {
    public int longestSubstr(String s, int k) {
        // code here
        int[] arr=new int[26];
        int n=s.length();
        int l=0;
        int m=-(int)1e9;
        int mLen=0;
        for(int r=0;r<n;r++){
            char ca=s.charAt(r);
            arr[ca-'A']++;
            mLen=Math.max(mLen,arr[ca-'A']);
            while(r-l+1-mLen > k){
                char lc=s.charAt(l);
                arr[lc-'A']--;
                l++;
            }
            m=Math.max(m,r-l+1);
        }
    return m;
    }
}
