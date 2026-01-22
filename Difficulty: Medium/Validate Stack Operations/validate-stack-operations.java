class Solution {
    public boolean validateOp(int[] a, int[] b) {
        // code here
        int n=a.length;
        int j=0;
        Stack<Integer> st=new Stack<>();
        for(int i=0;i<n;i++){
            st.push(a[i]);
            while(!st.isEmpty() && j<n && st.peek()==b[j]){
                j++;
                st.pop();
            }
        }
    if(st.isEmpty()) return true;
    return false;
    }
}