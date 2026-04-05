class Solution {
    public int mirrorFrequency(String s) {
        HashMap<Character,Character> hm=new HashMap<>();
        for(int i=0;i<=25;i++){
            hm.put((char)('a'+i),(char)('z'-i));
        }
        for(int i=0;i<=9;i++){
            hm.put((char)('0'+i),(char)('9'-i));
        }
        int n=s.length();
         HashMap<Character,Integer> hm2=new HashMap<>();
        for(int i=0;i<n;i++){
           char c=s.charAt(i);
           hm2.put(c,hm2.getOrDefault(c,0)+1);
        }
       int ct=0;
        for(int i=0;i<n;i++){
            char c=s.charAt(i);
            char m=hm.get(c);
                ct+=Math.abs(hm2.getOrDefault(c,0)-hm2.getOrDefault(m,0));
                hm2.remove(c);
                hm2.remove(m); 
        }
    return ct;
    }
}