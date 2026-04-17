class Solution {
    boolean canFormPalindrome(String s) {
        // code here
        int n=s.length();
        HashMap<Character,Integer> hm=new HashMap<>();
        for(int i=0;i<n;i++){
            char c=s.charAt(i);
            hm.put(c,hm.getOrDefault(c,0)+1);
        }
        int ct=0;
        for(Character k:hm.keySet()){
            if(hm.get(k)%2==1) ct++;
            if(ct>1) return false;
        }
    return true;
    }
}