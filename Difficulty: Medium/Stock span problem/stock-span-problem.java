class Solution {
    public ArrayList<Integer> calculateSpan(int[] arr) {
        // code here
        ArrayList<Integer> li=new ArrayList<>();
        Stack<Integer> st=new Stack<>();
        int n=arr.length;
        int ans[]=new int[n];
        for(int i=0;i<n;i++){
            while(!st.isEmpty() && arr[st.peek()]<=arr[i]){
                st.pop();
            }
            ans[i]=st.isEmpty()?-1:st.peek();
            st.push(i);
            li.add(i-ans[i]);
        }
    return li;
        
    }
}