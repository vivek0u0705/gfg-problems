class Solution {
    public int smallestSubstring(String s) {
        // code here
        HashMap<Character,Integer> hm=new HashMap<>();
        int n=s.length();
        int min=(int)1e9;
        int l=0;
        for(int r=0;r<n;r++){
            char c=s.charAt(r);
            hm.put(c,hm.getOrDefault(c,0)+1);
            while(hm.size()==3){
                if(hm.size()==3) min=Math.min(min,r-l+1);
                hm.put(s.charAt(l),hm.getOrDefault(s.charAt(l),0)-1);
                if(hm.get(s.charAt(l))==0) hm.remove(s.charAt(l));
                l++;
            }
        }
        if(min==(int)1e9) return -1;
    return min;
    }
};
