class Solution {
    public void rearrangeQueue(Queue<Integer> q) {
        // code here
        int n=q.size();
        int[] arr=new int[n];
        for(int i=0;i<n;i+=2){
            arr[i]=q.peek();
            q.poll();
        }
        for(int i=1;i<n;i+=2){
            arr[i]=q.peek();
            q.poll();
        }
        q.clear();
        for(int i=0;i<n;i++){
            q.add(arr[i]);
        }
    }
}
