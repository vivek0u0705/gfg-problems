class Solution {
    HashMap<Integer,Integer> hm;
    public List<Integer> sequentialDigits(int low, int high) {
        //states pos,tight,lz,prev;
        hm=new HashMap<>();
        String s1=String.valueOf(low-1);
        String s2=String.valueOf(high);
        f("",0,1,1,0,s2);
        f("",0,1,1,0,s1);
        List<Integer> li=new ArrayList<>();
        for(int key:hm.keySet()){
            if(hm.get(key)==1){
                li.add(key);
            }
        }
        Collections.sort(li);
    return li;
    }
    public void f(String cur,int i,int tg,int lz,int pr,String s){

        if(i==s.length()){
            if(cur.length()!=0){
                int num=Integer.parseInt(cur);
                hm.put(num,hm.getOrDefault(num,0)+1);
            }
            return;
        }

        int lb=0;
        int ub=tg==1?s.charAt(i)-'0':9;
        for(int dig=lb;dig<=ub;dig++){
            int ntg=(tg==1 && dig==ub)?1:0;
            int nlz=(lz==1 && dig==0)?1:0;
            if(lz==1 && dig==0){
                f(cur,i+1,ntg,nlz,pr,s);
            }
            else{
                if(lz==0 && dig!=pr+1) continue;
                f(cur+dig,i+1,ntg,nlz,dig,s);
            }
        }
    }
}