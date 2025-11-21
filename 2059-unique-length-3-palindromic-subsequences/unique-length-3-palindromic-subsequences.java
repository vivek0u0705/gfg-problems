class Solution {
    public int countPalindromicSubsequence(String s) {
        int f[]=new int[26];
        int l[]=new int[26];
        int n=s.length();
        Arrays.fill(f,-1);
        Arrays.fill(l,-1);
        for(int i=0;i<n;i++){
            int idx=s.charAt(i)-'a';
            if(f[idx]==-1) f[idx]=i;
        }
        for(int i=n-1;i>=0;i--){
            int idx=s.charAt(i)-'a';
            if(l[idx]==-1) l[idx]=i;
        }
        int ans=0;
        for(int i=0;i<26;i++){
            int j=f[i]+1;
            int k=l[i]-1;
            HashSet<Character> hs=new HashSet<>();
            for(int p=j;p<=k;p++){
                hs.add(s.charAt(p));
            }
            ans+=hs.size();
        }
    return ans;
    }
}