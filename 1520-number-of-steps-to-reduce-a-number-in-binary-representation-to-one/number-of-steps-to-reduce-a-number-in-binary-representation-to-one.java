class Solution {
    public int numSteps(String s) {
        char ca[]=s.toCharArray();
        int n=s.length();
        int i=n-1;
        int st=0;
        while(i>0){
            int t=(ca[i]-'0') & 1;
            if(t==1){
                ca=f(ca,i);
                if(ca.length!=n) i++;
            }
            else{
                i--;
            }
            st++;
        }
    return st;
    }
    public static char[] f(char[] ca,int len){
        int i=len;
        while(i>=0){
            if(ca[i]=='0'){
                ca[i]='1';
                return ca;
            }
            else{
                ca[i]='0';
            }
            i--;
        }
            char[] newc=new char[ca.length+1];
            Arrays.fill(newc,'0');
            newc[0]='1';
        return newc;
    }
}