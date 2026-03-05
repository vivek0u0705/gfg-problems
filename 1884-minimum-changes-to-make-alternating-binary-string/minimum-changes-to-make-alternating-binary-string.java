class Solution {
    public int minOperations(String s) {
        int c1=0;
        int n=s.length();
        char ca[]=s.toCharArray();
        for(int i=1;i<n;i++){
            if(ca[i-1]==ca[i]){
                c1++;
                if(ca[i]=='1') ca[i]='0';
                else ca[i]='1';
            }
        }
        char nca[]=s.toCharArray();
        if(nca[0]=='0') nca[0]='1';
        else nca[0]='0';
        int c2=1;
        for(int i=1;i<n;i++){
            if(nca[i-1]==nca[i]){
                c2++;
                if(nca[i]=='1') nca[i]='0';
                else nca[i]='1';
                
            }
        }
    return Math.min(c1,c2);
    }
}