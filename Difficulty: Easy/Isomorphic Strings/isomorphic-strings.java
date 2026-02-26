class Solution {
    public boolean areIsomorphic(String s1, String s2) {
        // code here
        HashMap<Character,Character> hm1=new HashMap<>();
        HashMap<Character,Character> hm2=new HashMap<>();
        int n=s1.length();
        for(int i=0;i<n;i++){
            char c1=s1.charAt(i);
            char c2=s2.charAt(i);
            if(!hm1.containsKey(c1)){
                hm1.put(c1,c2);
            }
            else{
                 if(hm1.get(c1)!=c2) return false;
            }
            
            if(!hm2.containsKey(c2)){
                hm2.put(c2,c1);
            }
            else{
                if(hm2.get(c2)!=c1) return false;
            }
        }
    return true;
    }
}