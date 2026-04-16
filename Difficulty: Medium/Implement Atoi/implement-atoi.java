class Solution {
    public int myAtoi(String s) {
        // code here
        s=s.trim();
        int n=s.length();
        int i=0;
        int sn=1;
        if(s.charAt(i)=='-'){
            sn=-1;
            i++;
        }
        else if(s.charAt(i)=='+'){
            sn=1;
            i++;
        }
        long num=0;
        while(i<n && Character.isDigit(s.charAt(i))){
            num=num*10+s.charAt(i)-'0';
            if(sn==1 && num>Integer.MAX_VALUE) return Integer.MAX_VALUE;
            if(sn==-1 && num>(long)Integer.MAX_VALUE+1) return Integer.MIN_VALUE;
            i++;
        }
    return sn*(int)num;
    }
}