class Solution {
    public int equalSumSpan(int[] a1, int[] a2) {
        // code here
        int n=a1.length;
        int diff[]=new int[n];
        for(int i=0;i<n;i++){
            diff[i]=a1[i]-a2[i];
        }
        HashMap<Integer,Integer> hm=new HashMap<>();
        int ps=0;
        int m=0;
        int k=0;
        for(int i=0;i<n;i++){
            ps+=diff[i];
            if(ps==k){
                m=i+1;
            }
            if(hm.containsKey(ps-k)){
                m=Math.max(m,i-hm.get(ps-k));
            }
            else{
                hm.put(ps,i);
            }
        }
    return m;
    }
}