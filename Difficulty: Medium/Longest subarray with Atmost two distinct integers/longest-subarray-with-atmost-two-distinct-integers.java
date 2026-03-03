class Solution {
    public int totalElements(int[] arr) {
        // code here
        HashMap<Integer,Integer> hm=new HashMap<>();
        int n=arr.length;
        int l=0;
        int m=0;
        for(int r=0;r<n;r++){
            hm.put(arr[r],hm.getOrDefault(arr[r],0)+1);
            while(l<r && hm.size()>2){
                hm.put(arr[l],hm.get(arr[l])-1);
                if(hm.get(arr[l])==0) hm.remove(arr[l]);
                l++;
            }
            m=Math.max(m,r-l+1);
        }
    return m;
    }
}