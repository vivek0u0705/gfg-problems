class Solution {
    public boolean kSubstr(String s, int k) {
        // code here
        int n=s.length();
        HashMap<String,Integer> hm=new HashMap<>();
        int j=0;
        for(int i=0;i<s.length();){
            if(i+k>n) break;
            String sub=s.substring(i,i+k);
            hm.put(sub,hm.getOrDefault(sub,0)+1);
            i=i+k;
        }
        if(hm.size()==1) return true;
        if(hm.size()==2){
            for(String ky :hm.keySet()){
                if(hm.get(ky)==1) return true;
            }
        }
    return false;
    }
}