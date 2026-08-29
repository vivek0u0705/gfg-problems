class Solution {
    int pow25=(int)Math.pow(2,25);
    public String[] largestString(int[] nums) {
        int n=nums.length;
        String[] res=new String[n];
        for(int i=0;i<n;i++){
            res[i]=get(nums[i]);

        }
    return res;
    }
    public String get(int num){
        int zct=num/pow25; // we can get extra z needed to add for >=2^25
        int rem=num%pow25; // we get the num<=2^25 
        // first find the chars for <=2^25  for rem
        int ch=97;
        StringBuilder sb=new StringBuilder();
        while(rem>0){
            int l=rem&1;
            char t=(char)ch;
            if(l==1) sb.append(t);
            rem=rem>>1;
            if(ch<122)ch=ch+1;
        }
        while(zct-->0){
            sb.append('z');
        }
    return sb.reverse().toString();
    }
}



// 2^25 < 10^8 < 2^26