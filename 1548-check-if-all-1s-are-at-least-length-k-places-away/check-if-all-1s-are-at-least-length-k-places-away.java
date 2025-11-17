class Solution {
    public boolean kLengthApart(int[] nums, int k) {
        boolean b=false;
        int z=0;
         for (int x : nums) {
        if (x == 1) {
            if(b==false) b=true;
            else if (z < k && b) return false;
            z = 0;
        } else {
            z++;
        }
    }
    return true;
    }
}