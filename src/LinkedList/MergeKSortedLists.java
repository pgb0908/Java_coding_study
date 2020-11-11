package LinkedList;

import java.util.PriorityQueue;

public class MergeKSortedLists {

    public static void main(String[] args) {

        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(5);

        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);

        ListNode l3 = new ListNode(2);
        l3.next = new ListNode(6);

        ListNode[] list = new ListNode[3];
        list[0] = l1;
        list[1] = l2;
        list[2] = l3;

        MergeKSortedLists a = new MergeKSortedLists();
        ListNode result = a.mergeKLists(list);

        System.out.println("====");
        while(result !=null) {
            System.out.println(result.val);
            result= result.next;
        }
    }

    private ListNode mergeKLists(ListNode[] list) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> a.val-b.val);
        ListNode newHead = new ListNode(0);
        ListNode p = newHead;

        for(ListNode node : list){
            if(node != null) {
                System.out.print(""+node.val+"\t");
                pq.offer(node);
            }
        }

        while(!pq.isEmpty()){
            // 하나를 뽑아서
            ListNode node = pq.poll();
            System.out.print(""+node.val+"\t");
            p.next = node;
            p = p.next;

            // 다음거를 넣는다
            if(node.next != null){
                pq.offer(node.next);
            }
        }

        return newHead.next;
    }
}
