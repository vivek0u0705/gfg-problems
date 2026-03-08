class Solution {
    public String findDifferentBinaryString(String[] nums) {
        int n=nums.length;
        HashSet<String> hs=new HashSet<>();
        for(int i=0;i<n;i++){
            hs.add(nums[i]);
        }
        int i=0;
        int len=(int)Math.pow(2,n);
        while(i<len){
            String str=f(i,n);
            if(!hs.contains(str)) return str;
            i++;
        }
    return "";
    }
    public static String f(int num,int n){
        String str=Integer.toBinaryString(num);
        while(str.length()!=n){
            str='0'+str;
        }
    return str;
    }
}