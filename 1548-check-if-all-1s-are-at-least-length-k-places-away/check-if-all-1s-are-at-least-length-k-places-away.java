class Solution {
    public boolean kLengthApart(int[] nums, int k) {
        int i=0;
        int n=nums.length;
        while(i<n){
            if(nums[i]==1 && i==n-1) break;
            if(nums[i]==1){
                i++;
                int j=0;
                boolean b=false;
                while(i<n){
                    if(nums[i]==1) {
                        b=true;
                        break;
                    } 
                    j++;
                    i++;
                }
                if(j<k && b) return false;
            }
            else i++;
        }
    return true;
    }
}