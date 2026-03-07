class Solution {
    public int minFlips(String s) {
        int c1=0;
        int c2=0;
        int n=s.length();
        s=s+s;
        int l=0;
        int m=(int)1e9;
        for(int i=0;i<2*n;i++){
            char ch=s.charAt(i);
            //010101
            if(i%2==0){
                if(ch!='0')c1++;
            }
            else{
                if(ch!='1')c1++;
            }
            //101010
            if(i%2==0){
                if(ch!='1')c2++;
            }
            else{
                if(ch!='0') c2++;
            }
            if(i-l+1>n){
                char cha=s.charAt(i);
                //010101
                if(l%2==0){
                    if(cha!='0')c1--;
                }
                else{
                    if(cha!='1') c1--;
                }
                //101010
                if(l%2==0){
                    if(cha!='1')c2--;
                }
                else{
                    if(cha!='0')c2--;
                }
            l++;
            }
            if(i-l+1==n) m=Math.min(m,Math.min(c1,c2));
        }
    return m;
    
    }
}