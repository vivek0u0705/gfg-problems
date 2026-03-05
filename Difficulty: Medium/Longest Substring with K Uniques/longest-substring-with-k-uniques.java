class Solution {
    public int longestKSubstr(String s, int k) {
        // code here
        HashMap<Character,Integer> hm=new HashMap<>();
        int n=s.length();
        int m=-1;
        int l=0;
        for(int r=0;r<n;r++){
            char c=s.charAt(r);
            hm.put(c,hm.getOrDefault(c,0)+1);
            while(l<r && hm.size()>k){
                char la=s.charAt(l);
                hm.put(la,hm.get(la)-1);
                if(hm.get(la)==0) hm.remove(la);
                l++;
            }
            if(hm.size()==k) m=Math.max(m,r-l+1);
        }
    return m;
    }
}