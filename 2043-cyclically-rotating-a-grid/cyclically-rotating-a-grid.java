class Solution {
    public int[][] rotateGrid(int[][] grid, int k) {
        int n=grid.length;
        int m=grid[0].length;
        int r=0;
        int c=0;
        TreeMap<Integer,List<Integer>> tm=new TreeMap<>();
        int i=0;
        while(i<Math.min(n,m)/2){
            //down
            int top=i;
            int left=i;
            int bottom=n-i-1;
            int right=m-i-1;
            r=top;
            c=left;
            tm.put(i,new ArrayList<>());
            while(r<=bottom){
                tm.get(i).add(grid[r][c]);
                r++;
            }
            r=bottom;
            c=left+1;
            //right
            while(c<=right){
                tm.get(i).add(grid[r][c]);
                c++;
            }
            r=bottom-1;
            c=right;
            //up
            while(r>=top){
                tm.get(i).add(grid[r][c]);
                r--;
            }
            r=top;
            c=right-1;
            //left
             while(c>left){
                tm.get(i).add(grid[r][c]);
                c--;
            }
        i++;
        }
        rotate(tm,k);
        int[][] ans=new int[n][m];
        i=0;
        while(i<Math.min(n,m)/2){
            //down
            int top=i;
            int left=i;
            int bottom=n-i-1;
            int right=m-i-1;
            r=top;
            c=left;
            List<Integer> li=tm.get(i);
            int len=0;
            while(r<=bottom){
                ans[r][c]=li.get(len);
                r++;
                len++;
            }
            r=bottom;
            c=left+1;
            //right
            while(c<=right){
                ans[r][c]=li.get(len);
                c++;
                len++;
            }
            r=bottom-1;
            c=right;
            //up
            while(r>=top){
                ans[r][c]=li.get(len);
                r--;
                len++;

            }
            r=top;
            c=right-1;
            //left
             while(c>left){
                ans[r][c]=li.get(len);
                c--;
                len++;
            }
           i++;
        }
    return ans;

    }
    public static void rotate(TreeMap<Integer,List<Integer>> tm,int k){
        for(int i:tm.keySet()){
            List<Integer> li=tm.get(i);
            int n=li.size();
            int k1=k%n;
            r(li, 0, n - k1 - 1);
            r(li, n - k1, n - 1);
            r(li, 0, n - 1);
        }
    }
    public static void r(List<Integer> li,int i,int j){
        int n=li.size();
        while(i<j){
            int t=li.get(i);
            li.set(i,li.get(j));
            li.set(j,t);
            i++;
            j--;
        }
    }
}