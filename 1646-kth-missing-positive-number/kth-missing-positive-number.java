class Solution {
    public int findKthPositive(int[] arr, int k) {
        LinkedHashSet<Integer> hs1=new LinkedHashSet<>();
        HashSet<Integer> hs=new HashSet<>();
        int m=Integer.MAX_VALUE;
        for(int i:arr){
            hs.add(i);
        }
        int i=1;
        int j=0,ans=0;
        while(i<=m){
            if(!hs.contains(i)){
                j++;
                if(j==k){
                    ans=i;
                    break;
                } 
                hs1.add(i);
            }
            i++;
        }
    return ans;
    }
}