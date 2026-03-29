class EventManager {
    class Pair{
        int v;
        int p;
        Pair(int val,int pri){
            v=val;
            p=pri;
        }
    }
    PriorityQueue<Pair> pq=new PriorityQueue<>((a,b)->{
        if(a.p!=b.p) return Integer.compare(b.p,a.p);
        else return Integer.compare(a.v,b.v);
    });
    HashMap<Integer,Integer> hm=new HashMap<>(); //intailize to get val in pq
    public EventManager(int[][] events) {
        int n=events.length;
        for(int i=0;i<n;i++){
            pq.add(new Pair(events[i][0],events[i][1]));
            hm.put(events[i][0],events[i][1]);
        }
        
    }
    
    public void updatePriority(int eventId, int newPriority) {
        hm.put(eventId,newPriority);
        pq.add(new Pair(eventId,newPriority)); // add val even priority is low or high

    }
    
    public int pollHighest() {
        // if(pq.size()==0) return -1;
        while(!pq.isEmpty()){
            Pair rem=pq.poll(); // remove all top in pq
    //if top prio is there in hm then is valid then remove in hm for next testcases
    //return it val
            if(hm.containsKey(rem.v) && hm.get(rem.v)==rem.p){
                hm.remove(rem.v);
                return rem.v;
            }
        }
    return -1;
    }
}

/**
 * Your EventManager object will be instantiated and called as such:
 * EventManager obj = new EventManager(events);
 * obj.updatePriority(eventId,newPriority);
 * int param_2 = obj.pollHighest();
 */