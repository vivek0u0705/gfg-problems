class Solution {
    public int sumSubMins(int[] arr) {
        // code here
        int n=arr.length;
        Stack<Integer> st=new Stack<>();
        int ans[]=new int[n];
        for(int i=n-1;i>=0;i--){
            while(!st.isEmpty() && arr[i]<=arr[st.peek()]){
                st.pop();
            }
            if(st.isEmpty()) ans[i]=n;
            else ans[i]=st.peek();
            st.push(i);
        }
        st.clear();
        int ans2[]=new int[n];
        for(int i=0;i<n;i++){
            while(!st.isEmpty() && arr[i]<arr[st.peek()]){
                st.pop();
            }
            if(st.isEmpty()) ans2[i]=-1;
            else ans2[i]=st.peek();
            st.push(i);
        }
        int s=0;
        for(int i=0;i<n;i++){
            s+=(ans[i]-i)*(i-ans2[i])*arr[i];
        }
    return s;
    }
}
