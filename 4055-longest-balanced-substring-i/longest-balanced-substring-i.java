class Solution {
    public int longestBalanced(String s) {
        int n=s.length();
        int max=0;
        for(int i=0;i<n;i++){
            int[] ca=new int[26];
            for(int j=i;j<n;j++){
                char c=s.charAt(j);
                ca[c-'a']++;
                int var=ca[c-'a'];
                int ct=0;
                for(int k=0;k<26;k++){
                    if(var==ca[k]) ct=ct+ca[k];
                }
                if(j-i+1==ct){
                    max=Math.max(max,j-i+1);
                }
            }
        }
    return max;
    }
}