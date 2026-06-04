class Solution {
    public int findMaxLength(int[] arr) {
        int n=arr.length;
        for(int i=0;i<n;i++){
            if(arr[i]==0) arr[i]=-1;
        }
        //largest sub array sum =0    we use (prefix sum + HashMap)
        HashMap<Integer,Integer> hm=new HashMap<>();
        int ps=0;
        int k=0; //(sum)
        int maxL=0;
        for(int i=0;i<n;i++){
            ps+=arr[i];
            if(ps==k){
                maxL=i+1;
            }
            if(hm.containsKey(ps-k)){
                maxL=Math.max(maxL,i-hm.get(ps-k));
            }
            if(!hm.containsKey(ps)){
                hm.put(ps,i);
            }
            // hm.put(ps,i);
        }
    return maxL;
    }
}