class Solution {
    public int maxPeople(int[] arr) {
        // code here
        int n=arr.length;
        int ng[]=new int[n];
        int pg[]=new int[n];
        int m=0;
        Stack<Integer> st=new Stack<>();
        for(int i=0;i<n;i++){
            while(!st.isEmpty() && arr[st.peek()]<arr[i]){
                st.pop();
            }
            pg[i]=st.isEmpty()?-1:st.peek();
            st.push(i);
        }
        Stack<Integer> st1=new Stack<>();
        for(int i=n-1;i>=0;i--){
            while(!st1.isEmpty() && arr[st1.peek()]<arr[i]){
                st1.pop();
            }
            ng[i]=st1.isEmpty()?n:st1.peek();
            st1.push(i);
        }
        for(int i=0;i<n;i++){
            m=Math.max(m,ng[i]-pg[i]-1);
        }
    return m;
    }
}
