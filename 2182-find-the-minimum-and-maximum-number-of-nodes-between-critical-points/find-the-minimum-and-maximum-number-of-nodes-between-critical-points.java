/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        ListNode d=new ListNode(0);
        ListNode t=head;
        List<Integer> li=new ArrayList<>(); 
        while(t!=null){
            li.add(t.val);
            t=t.next;
        }
        int n=li.size();
        //find all critical points
        List<Integer> res=new ArrayList<>(); 
        for(int i=0;i<li.size();i++){
            if(i-1>=0 && i+1<n){
                if((li.get(i-1)<li.get(i) && li.get(i)>li.get(i+1)) ||
                (li.get(i-1)>li.get(i) && li.get(i)<li.get(i+1))){
                    res.add(i);
                }
            }
        }
        // for(int k:res) System.out.print(k+" ");
        if(res.size()<2) return new int[]{-1,-1};
        if(res.size()==2){
            int k=res.get(1)-res.get(0);
             return new int[]{k,k};
        }
        Collections.sort(res);
        n=res.size();
        int a2=res.get(n-1)-res.get(0);
        int a1=(int)1e9;
        for(int i=1;i<n;i++){
            int k=res.get(i)-res.get(i-1);
            a1=Math.min(a1,k);
        }
    return new int[]{a1,a2};
    }
}