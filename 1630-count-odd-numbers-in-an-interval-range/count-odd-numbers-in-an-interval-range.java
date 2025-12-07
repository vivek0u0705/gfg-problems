class Solution {
    public int countOdds(int low, int high) {
        int t=0;
         if(low%2==1) t++;
         if(high%2==1) t++;
        if(low%2==1 && high%2==1) {
            t+=(high-low)/2 - 1;
            return t;
        }
     return t+(high-low)/2;
    }
}