class Solution {
    public boolean checkStrings(String s1, String s2) {
        HashMap<Character,Integer> hm0=new HashMap<>(); 
        HashMap<Character,Integer> hm1=new HashMap<>(); 
        int n=s2.length();
        for(int i=0;i<n;i++){
            char c=s2.charAt(i);
            if(i%2==0) hm0.put(c,hm0.getOrDefault(c,0)+1);
            else hm1.put(c,hm1.getOrDefault(c,0)+1);
        }
        for(int i=0;i<n;i++){
            char c=s1.charAt(i);
            if(i%2==0){
                if(!hm0.containsKey(c)) return false;
                hm0.put(c,hm0.get(c)-1);
                if(hm0.get(c)==0) hm0.remove(c);
            }
            else{
                if(!hm1.containsKey(c)) return false;
                hm1.put(c,hm1.get(c)-1);
                if(hm1.get(c)==0) hm1.remove(c);
            }
        }
    return true;
    }
}