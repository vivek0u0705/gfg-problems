class Solution {
    public boolean canBeEqual(String s1, String s2) {
        char[] ca=s2.toCharArray();
        int n=4;
        for(int i=0;i<n;i++){
            if(i+2<n && ca[i]!=s1.charAt(i)){
                char k=ca[i];
                ca[i]=ca[i+2];
                ca[i+2]=k;
            }
        }
    return s1.equals( new String(ca));
    }
}