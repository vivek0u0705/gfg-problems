class Solution {
    public int bitwiseComplement(int num) {
        if(num==0) return 1;
       int t=(int)(Math.log(num)/Math.log(2))+1;
       int bit=0;
       int i=0;
       while(i<t){
        bit=bit<<1;
        bit=bit|1;
        i++;
       }
       
    return num^bit;
    }
}