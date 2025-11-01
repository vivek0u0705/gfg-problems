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
    public ListNode modifiedList(int[] nums, ListNode head) {
        HashSet<Integer> hs=new HashSet<>();
        ListNode d=new ListNode(0);
        d.next=head;
        ListNode t=d;
        for(int i=0;i<nums.length;i++){
            hs.add(nums[i]);
        }
        while(t.next!=null){
            int val=t.next.val;
            if(hs.contains(val)){
                t.next=t.next.next;
            }
            else t=t.next;
        }
        return d.next;
    }
}