package algoProblemSolutions.linkedlists;

public class ReverseLinkedListKChunksRev {

    public static void main(String[] args) {

        ListNode<Integer> node3 = new ListNode<>(3);
        ListNode<Integer> node4 = new ListNode<>(4);
        node3.next=node4;
        ListNode<Integer> node7 = new ListNode<>(7);
        node4.next=node7;
        ListNode<Integer> node2 = new ListNode<>(2);
        node7.next=node2;
        ListNode<Integer> node8 = new ListNode<>(8);
        node2.next=node8;
        ListNode<Integer> node9 = new ListNode<>(9);
        node8.next=node9;
        ListNode<Integer> node6 = new ListNode<>(6);
        node9.next=node6;

        ListNode<Integer> list = node3;
        System.out.println(list);

        ListNode<Integer> revList = new ReverseLinkedListKChunksRev().reverseNodesInKGroups(list, 2);
        System.out.println(revList);
    }

    ListNode<Integer> reverseNodesInKGroups(ListNode<Integer> l, int k) {

        if (l == null || k < 2) return l;

        ListNode<Integer> newHead = null;
        ListNode<Integer> prevTail = null;
        ListNode<Integer> curr = l;

            while (curr != null) {
                // get the end of each sublist first
                int cnt = 1;
                ListNode<Integer> c = curr;
                while (c != null && cnt < k) {
                    c = c.next;
                    if (c != null) cnt++;
                }
                ListNode<Integer> prev = null;
                ListNode<Integer> subHead = curr;
                if (cnt == k) { // reverse sublist
                    while (cnt != 0) {
    //                    System.out.println("node -> " + curr.value + " | k -> "+ k + " | cnt -> " + cnt);
                        ListNode<Integer> nxt = curr.next;
                        curr.next = prev;
                        prev = curr;
                        curr = nxt;
                        cnt--;
                    }
                    if (prevTail == null) {
                        newHead = prev;
                    } else {
                        prevTail.next = prev;
                    }
                    prevTail = subHead;
                } else {
                    if (prevTail == null) {
                        newHead = curr;
                    } else {
                        prevTail.next = curr;
                    }
                    curr = c;
                }
            }
        return newHead;
    }
}



    // Definition for singly-linked list:
    class ListNode<T> {
        ListNode(T x) {
            value = x;
        }

        T value;
        ListNode<T> next;

        @Override
        public String toString() {
            String s = "";
            ListNode n = this;
            while (n != null) {
                s += (n.value + " > ");
                n = n.next;
            }
            s += "*";
            return s;
        }
    }


