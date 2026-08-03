class SegmentTree {

    public int[] seg;
    SegmentTree(int n) {
        seg = new int[4 * n];
    }

    // Build
    void build(int node, int low, int high, int[] arr) {

        if (low == high) {
            seg[node] = arr[low];
            return;
        }

        int mid = (low + high) / 2;

        build(2 * node + 1, low, mid, arr);
        build(2 * node + 2, mid + 1, high, arr);

        seg[node] = seg[2 * node + 1]+ seg[2 * node + 2];
    }

    // Range Minimum Query
    int query(int node, int low, int high, int l, int r) {

        // No Overlap
        if (high < l || low > r)
            return 0;

        // Complete Overlap
        if (low >= l && high <= r)
            return seg[node];

        // Partial Overlap
        int mid = (low + high) / 2;

        int left = query(2 * node + 1, low, mid, l, r);
        int right = query(2 * node + 2, mid + 1, high, l, r);

        return left+ right;
    }

    // Point Update
    void update(int node, int low, int high, int idx, int val) {

        if (low == high) {
            seg[node] += val;
            return;
        }

        int mid = (low + high) / 2;

        if (idx <= mid)
            update(2 * node + 1, low, mid, idx, val);
        else
            update(2 * node + 2, mid + 1, high, idx, val);

        seg[node] = seg[2 * node + 1]+ seg[2 * node + 2];
    }
}

class Solution {
    public int inversionCount(int arr[]) {
        // code here
        int n=arr.length;
        int mx=-1;
        for(int x:arr){
            mx=Math.max(mx,x);
        }
        mx++;
        SegmentTree sg=new SegmentTree(mx);
        int freq[]=new int[mx];
        for(int x:arr){
            freq[x]++;
        }
        sg.build(0, 0,mx-1, freq);
        int ct=0;
        for(int i=0;i<n;i++){
            int x=arr[i];
            freq[x]--;
            sg.update(0,0,mx-1,x,-1);
            ct+=sg.query(0,0,mx-1,0,x-1);
            
        }
    return ct;
    }
}