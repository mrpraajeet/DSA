class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class _2130 {
    public int pairSum(ListNode head) {
        ListNode slow = head, fast = head;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        } //Find mid

        ListNode prev = null, curr = slow, next = curr.next;
        while(curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        } //Reverse 2nd half

        int sum = 0;
        while(prev != null) {
            sum = Math.max(sum, head.val + prev.val);
            head = head.next;
            prev = prev.next;
        } //Find max sum
        return sum;
    }
}