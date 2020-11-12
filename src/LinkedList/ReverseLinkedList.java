package LinkedList;

public class ReverseLinkedList {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(3);

        printNode(l1);
        ListNode head = reverseList(l1);
        printNode(head);

    }

    private static ListNode reverseList(ListNode current) {
        ListNode prev = null;
        ListNode temp = null;

        while(current != null){
            temp = current.next;
            current.next = prev;
            prev = current;
            current = temp;
        }
        return prev;
    }

    private static void printNode(ListNode head) {
        System.out.println("printNode : ");
        while(head != null){
            System.out.println(head.val);
            head = head.next;
        }
        System.out.println();
    }
}
