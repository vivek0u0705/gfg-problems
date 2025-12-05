class Solution {
    public int countPartitions(int[] nums) {
        int ts=0;
        for(int i:nums){
            ts+=i;
        }
        int c=0;
        int cs=0;
        for(int i=0;i<nums.length-1;i++){
            cs=cs+nums[i];
            ts=ts-nums[i];
            if(Math.abs(cs-ts)%2==0) c++;
        }
    return c;
    }
}