class Solution {
    public int bitwiseComplement(int num) {
        if(num==0) return 1;
       String str=Integer.toBinaryString(num);
       StringBuilder sb=new StringBuilder(str);
       int n=sb.length();
       int i=0;
       str="";
       while(i<n){
        if(sb.charAt(i)=='0') str+='1';
        else str+='0';
        i++;
       }
       int t=Integer.parseInt(str,2);
    return t;
    }
}