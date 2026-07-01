class Solution {
    public static ArrayList<Integer> increasingNumbers(int n) {
        // code here
        ArrayList<Integer> li=new ArrayList<>();
        if(n==1) li.add(0);
        if(n>9) return li;
        f(1,"",li,n);
    return li;
    }
    static void f(int i,String cur,ArrayList<Integer> li,int n){
        if(cur.length()==n){
            li.add(Integer.parseInt(cur));
            return;
        }
        for(int j=i;j<=9;j++){
            f(j+1,cur+j,li,n);
        }
    }
}
