class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) return null;

        int currentSmallest = 0;
        ListNode head = null;
        ListNode tail = null;

        while (true) {
            int min = Integer.MAX_VALUE;
            boolean found = false;

            for (int i = 0; i < lists.length; i++) {
                if (lists[i] != null && lists[i].val < min) {
                    min = lists[i].val;
                    currentSmallest = i;
                    found = true;
                }
            }
            if (!found) return head;
            ListNode currentNode = new ListNode(lists[currentSmallest].val);
            if (head == null) {
                head = currentNode;
                tail = head;
            } else {
                tail.next = currentNode;
                tail = tail.next;
            }
            lists[currentSmallest] = lists[currentSmallest].next;
        }
    }
}