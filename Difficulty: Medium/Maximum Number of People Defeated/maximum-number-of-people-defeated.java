class Solution {
    int maxPeopleDefeated(int p) {
        // code here
        int i=1;
        int t=1;
        while(true){
            if(p<t) break;
            i++;
            t+=i*i;
        }
    return i-1;
    }
};