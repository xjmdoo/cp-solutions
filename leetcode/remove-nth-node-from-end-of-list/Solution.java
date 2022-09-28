class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode current = head;
        ArrayList<ListNode> arr = new ArrayList<>();
        while (current != null) {
            arr.add(current);
            current = current.next;
        }
        
        if (arr.size() <= 1) return null;
        
        int nth = arr.size() - n;
        if (nth == 0) {
            return head.next;
        }
        arr.get(nth - 1).next = nth + 1 >= arr.size() ? null : arr.get(nth + 1);
        return head;
    }
}

