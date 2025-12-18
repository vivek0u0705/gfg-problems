class Solution {
    public void sortIt(int[] arr) {
        // code here
        List<Integer> l1=new ArrayList<>();
        List<Integer> l2=new ArrayList<>();
        int n=arr.length;
        for(int i=0;i<n;i++){
            if(arr[i]%2==0) l1.add(arr[i]);
            else l2.add(arr[i]);
        }
        Collections.sort(l2);
        Collections.sort(l1);
        Collections.reverse(l2);
        int i=0;
        int k=0;
            for(int j=0;j<l2.size();j++){
                arr[k++]=l2.get(j);
            }
             for(int j=0;j<l1.size();j++){
                arr[k++]=l1.get(j);
            }
    }
}
