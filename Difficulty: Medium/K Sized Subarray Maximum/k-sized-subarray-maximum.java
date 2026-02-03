class Solution {
    public ArrayList<Integer> maxOfSubarrays(int[] arr, int k) {
        // code here
        int n=arr.length;
        ArrayList<Integer> li=new ArrayList<>();
        Deque<Integer> q=new ArrayDeque<>();
        for(int i=0;i<k;i++){
            while(!q.isEmpty() && arr[q.peekLast()] <arr[i]){
                q.pollLast();
            }
            q.addLast(i);
        }
        li.add(arr[q.peekFirst()]);
        for(int i=k;i<n;i++){
            while(!q.isEmpty() && arr[q.peekLast()] <arr[i]){
                q.pollLast();
            }
            while(!q.isEmpty() && i-q.peekFirst() >= k){
                q.pollFirst();
            }
            if(!q.isEmpty())li.add(arr[q.peekFirst()]);
            else li.add(arr[i]);
            q.addLast(i);
        }
    return li;
    }
}