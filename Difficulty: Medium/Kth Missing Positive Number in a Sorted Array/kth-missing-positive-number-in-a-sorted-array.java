class Solution {
    public int kthMissing(int[] arr, int k) {
        // code here
        HashSet<Integer> hs=new HashSet<>();
        for(int i:arr){
            hs.add(i);
        }
        int i=1,t=1;
        while(true){
            if(!hs.contains(i)){
                if(t==k) return i;
                t++;
            }
            i++;
        }
    }
}