class Solution {
    public int distinctPrimeFactors(int[] nums) {
        
        int MAX=1000;
        int[] primes=new int[MAX+1];
        for(int i=2;i*i<=MAX;i++){
            for(int j=i*i;j<=MAX;j+=i){
                primes[j]=1; 
            }
        } 
        HashSet<Integer> set=new HashSet<>();
        for(int j=0;j<nums.length;j++){
            int temp=nums[j];
            for(int i=2;i*i<=temp;i++){
                if(primes[i]==0 && temp%i==0){
                    set.add(i);
                    while(temp%i==0){
                        temp=temp/i;
                    }
                }
            }
            
            if(temp>1) set.add(temp);
        }
    return set.size();
    }
}