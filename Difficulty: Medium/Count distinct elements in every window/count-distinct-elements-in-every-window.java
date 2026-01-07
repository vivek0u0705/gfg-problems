class Solution {
    ArrayList<Integer> countDistinct(int arr[], int k) {
        // code here
        ArrayList<Integer> l=new ArrayList<>();
        HashMap<Integer,Integer> hm=new HashMap<>();
        for(int i=0;i<k;i++){
            hm.put(arr[i],hm.getOrDefault(arr[i],0)+1);
        }
        int s=hm.size();
        l.add(s);
        for(int i=k;i<arr.length;i++){
            hm.put(arr[i],hm.getOrDefault(arr[i],0)+1);
            hm.put(arr[i-k],hm.get(arr[i-k])-1);
            if(hm.get(arr[i-k])==0) hm.remove(arr[i-k]);
            l.add(hm.size());
        }
    return l;
    }
}