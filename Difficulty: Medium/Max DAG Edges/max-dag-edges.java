class Solution {
    public int maxEdgesToAdd(int V, int[][] e) {
        // Code here
        int n=e.length;
        int k=(V-1)*V/2;
    return Math.abs(n-k);
    }
}