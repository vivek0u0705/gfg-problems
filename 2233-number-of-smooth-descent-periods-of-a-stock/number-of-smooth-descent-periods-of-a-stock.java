class Solution {
    public long getDescentPeriods(int[] nums) {
        long c=1;
        int i=0;
        int j=1;
        int p=nums[0];
        int n=nums.length;
        while(j<n){
            p=p-1;
            if(p!=nums[j]){
                i=j;
                p=nums[i];
            }
            c+=(j-i+1);
            j++;
        }
    return c;

    }
}