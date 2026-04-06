class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> r=new ArrayList<>();
        g(n,r,"",0,0);
    return r;

    }
    public static void g(int n,List<String> r,String cur,int o,int c){
        if(c>o) return;
        if(o==n && o==c) {
            r.add(cur);
            return;
        }
       if(o<n){
        g(n,r,cur+"(",o+1,c);
       }
       if(c<o){
        g(n,r,cur+")",o,c+1);
       }
    }
}