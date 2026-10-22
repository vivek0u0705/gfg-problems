
class Solution {
    public int sortableIntegers(int[] nums) {
        int n = nums.length;
        if(n==1) return 1;
        int[] sorted = nums.clone();
        Arrays.sort(sorted);
        int res = 0;
        for(int k=1; k<=n; k++){//for differnt sizes of subarray
            if(n%k!=0) continue;
            boolean flag = true;
            for(int i=0; i<n; i+=k){//defining different subarrays
                if(!isRotation(i, i+k, nums, sorted)){
                    flag = false;
                    break;
                }
            }
            if(flag){
                //System.out.println(k);
                res+=k;
            } 
        }
        return res;
    }

    public boolean isRotation(int l, int r, int[] nums, int[] sorted){
        StringBuilder temp1 = new StringBuilder();
        StringBuilder temp2 = new StringBuilder();
        for(int i=l; i<r; i++){
            temp1.append(nums[i]+",");
            temp2.append(sorted[i]+",");
        }
        String A = temp1.toString();
        String B = temp2.toString();
        return (B+B).contains(A);
    }
}

