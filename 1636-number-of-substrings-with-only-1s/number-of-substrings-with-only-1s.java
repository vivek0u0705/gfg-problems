class Solution {
    static int m=1000000007;
    public int numSub(String s) {
        HashMap<Integer,Integer> hm=new HashMap<>();
        int l=0,r=0;
        int c=0;
        while(l<s.length()){
            c=0;
            if(s.charAt(l)=='1'){
                r=l;
                while(r<s.length() && s.charAt(r)=='1'){ 
                   r++;
                }
                c=r-l;
                hm.put(c,hm.getOrDefault(c,0)+1);
                l=r;
            }
            else l++;
           
        }
        long ans=0;
        for(int k:hm.keySet()){
            if(k>0){
                long p= ((long)k*(k+1)/2)*hm.get(k);
                ans=(ans + p )%m;
            }
        }
    return (int)ans;
    }
}