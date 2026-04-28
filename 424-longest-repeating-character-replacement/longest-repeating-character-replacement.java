class Solution {
    public int characterReplacement(String s, int k) {
        char[] c=s.toCharArray();
        Map<Character,Integer> m=new HashMap<>();
        int mLen=0;
        int ans=0;
        int l=0;
        for(int r=0;r<c.length;r++){
            m.put(c[r],m.getOrDefault(c[r],0)+1);
            mLen=Math.max(mLen,m.get(c[r])); 
            while((r-l+1)-mLen>k){
                m.put(c[l],m.get(c[l])-1);
                if(m.get(c[l])==0) m.remove(c[l]);
                mLen=0;
                for(Character key:m.keySet()) mLen=Math.max(mLen,m.get(key));
                l++;
            }
            ans=Math.max(ans,r-l+1);
        }
    return ans;
    }
}