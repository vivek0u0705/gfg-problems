class Solution {
    public boolean isProduct(int[] arr, long tar) {
        // code here
        HashMap<Integer,Integer> hm=new HashMap<>();
        int n=arr.length;
        for(int i : arr) {
            hm.put(i,hm.getOrDefault(i,0)+1);
        }
        for(int i=0;i<n;i++){
            if(arr[i]==0) {
                if(tar==0) return true;
                continue;
            }
            if (tar % arr[i] != 0) continue;
            int val = (int) (tar/arr[i]);
            if(hm.containsKey(val)){
                if(val!=arr[i]) return true;
                if(hm.get(val)>=2) return true;
            }
        }
    return false;
    }
}