class Solution {
    public int minOperations(int[] nums) {
        int len=(int)1e5+4;
        int[] ckP=new int[len];
        ckP[0]=1;
        ckP[1]=1;    // 1 is not primee
        for(int i=2;i*i<len;i++){
            if(ckP[i]==0){
                for(int j=i*i;j<len;j=j+i){
                    ckP[j]=1;
                }
            }
        }
        int n=nums.length;
        int ans=0;
        for(int i=0;i<n;i++){
            int t=nums[i];
            if(i%2==0){ // ind 0  set prime
                    int ct=t;
                    while(ct<len && ckP[ct]==1){
                        ct++;
                    }
                    ans+=ct-t;
            }
            else{ // idx 1  set not prime
                int ct=t;
                    while(ct<len && ckP[ct]==0){
                        ct++;
                    }
                ans+=ct-t;
            }
        }
    return ans;
    }
}