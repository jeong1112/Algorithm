
//  public class ListNode {
//     int val;
//     ListNode next;
//     ListNode() {}
//     ListNode(int val) { this.val = val; }
//     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
//  }
 

class Solution {
    public ListNode deleteMiddle(ListNode head) {
        int nodeSize = 0;
        ListNode current = head;

        if(head.next == null){
            return null;
        }

        while(current != null){
            nodeSize++;
            current = current.next;
        }

        int deleteIdx = nodeSize / 2;

        // deleteIdx 앞에꺼의 next를 deleteIdx 뒤에꺼로 바꿔주면 된다.
        
        ListNode beforeNode = head;

        for(int i = 0; i < deleteIdx - 1; i++){
            beforeNode = beforeNode.next;
        }

        beforeNode.next = beforeNode.next.next;

        return head;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna