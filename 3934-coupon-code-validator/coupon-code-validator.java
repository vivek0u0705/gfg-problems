class Pair{
    String s;
    int t;
    Pair(String c,int d){
        s=c;
        t=d;
    }
}
class Solution {
    public List<String> validateCoupons(String[] code, String[] bus, boolean[] isA) {
        int n=isA.length;
        List<Pair> lt=new ArrayList<>();
        for(int i=0;i<n;i++){
            if(isA[i]==true && valid(code[i])){
                if(bus[i].equals("electronics")){
                    lt.add(new Pair(code[i],1));
                }
                else if(bus[i].equals("grocery")){
                    lt.add(new Pair(code[i],2));
                }
                else if(bus[i].equals("pharmacy")){
                    lt.add(new Pair(code[i],3));
                }
                else if(bus[i].equals("restaurant")){
                    lt.add(new Pair(code[i],4));
                }
            }
        }
        lt.sort((a,b)->{
            if(a.t!=b.t) return Integer.compare(a.t,b.t);
            else return (a.s+b.s).compareTo(b.s+a.s);
        });
        List<String> li=new ArrayList<>();
        for(int i=0;i<lt.size();i++){
            li.add(lt.get(i).s);
        }
    return li;
    }
    public static boolean valid(String str){
        int n=str.length();
        if(n==0) return false;
        for(int i=0;i<n;i++){
            if(!Character.isLetter(str.charAt(i)) && !Character.isDigit(str.charAt(i)) && str.charAt(i)!='_') return false;
        }
        return true;
    }
}