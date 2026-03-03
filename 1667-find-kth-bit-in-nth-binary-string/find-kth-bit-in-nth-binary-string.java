class Solution {
    public char findKthBit(int n, int k) {
        String s="0";
        int i=1;
        while(i<=n){
            String ps=s;
            s=s+'1'+f(ps);
            i++;
        }
    return s.charAt(k-1);
    }
    public static String f(String str){
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<str.length();i++){
            if(str.charAt(i)=='1') sb.append('0');
            else sb.append('1');
        }
    return sb.reverse().toString();
    }
}