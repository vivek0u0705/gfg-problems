class Solution {
    Long dp[][][][];
    public long maxAlternatingSum(int[] nums) {
        int n=nums.length;
        // if(n==1) return nums[0];
        dp=new Long[n][2][2][2];
        long ans=-(long)1e18;
        for(int i=0;i<n;i++) {
            ans=Math.max(ans,f(i,nums,0,0,0)); 
            // states (idx,par,deleted or not, atleast one taken)
            // need to check for every staring idx 
        }
    return ans;
    }
    public long f(int i,int[] nums,int par,int del,int ct){
        if(i==nums.length) return ct==1?0:-(long)1e18;

        if(dp[i][par][del][ct]!=null) return dp[i][par][del][ct];

        long nt=-(long)1e18;
        if(del==0) nt=f(i+1,nums,par,1,ct);

        long t=0;
        if(par==0){
            t+=nums[i]+f(i+1,nums,1,del,ct|1);
        }
        else{
            t=-nums[i]+f(i+1,nums,0,del,ct|1);
        }
        
        long stop=(ct==1)?0:-(long)1e18;
    return dp[i][par][del][ct]=Math.max(stop,Math.max(nt,t));
    }
}



// Short notes

// i → current index
// par → 0:+, 1:-
// del → 0:not deleted, 1:deleted
// ct → 0:nothing selected, 1:started

// At each index:
// 1. Take → add/subtract based on par
// 2. Delete → only if del == 0
// 3. Stop → only if ct == 1
// ct | 1

// → marks that we selected an element.
// stop = ct == 1 ? 0 : -INF;

// → allows ending the subarray only after selecting something.
// i == n

// → ct==1 valid, otherwise invalid.
// Outer loop: try every possible starting index.
// Complexity: O(n) time, O(n) space.