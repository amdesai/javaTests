package randomAnitest.linkedlists;

/*
Given a singly linked list and an integer 'k', reverse every 'k' elements. If k <= 1, then input list is unchanged.

If k >= n (n is the length of linked list), then reverse the whole linked list.

Below is the input linked list and output after reversing every 3 elements

pT - null
pT.nxt -> prev                                cT
                                 pT        p                    c
             0   1    2        3                   |
list : / < 3 < 6 < 1 >    9 > 2 - 5 -      8 - 12 - /
                               c
                               cT

            1 > 6 > 3        5 > 2 > 9       8 - 12 - 7 - /
                nH -> 1 > 6 > 3
                pT = cT // 3 | 9
                cT = c // 9 | 8
                if (pT == null) then save nH
                else pT.next = p
                pT = cT
                cT = c
k= 3
in the end:
               cT.next = null;
               pT.next = p;

*/


public class ReverseLinkedListKChunks {

    public static void main(String ... args) {

        Node n3 = new Node(3);
        Node n6 = new Node(6);
        n3.next = n6;
        Node n1 = new Node(1);
        n6.next = n1;
        Node n9 = new Node(9);
        n1.next = n9;
        Node n2 = new Node(2);
        n9.next = n2;
        Node n5 = new Node(5);
        n2.next = n5;
        Node n8 = new Node(8);
        n5.next = n8;
        Node n12 = new Node(12);
        n8.next = n12;
        Node n7 = new Node(7);
        n12.next = n7;

        Node head = n3;
        System.out.println(head);
        head = new ReverseLinkedListKChunks().reverseListInKSizedChunks(head, 0);
        System.out.println("k=0: " + head);
        head = new ReverseLinkedListKChunks().reverseListInKSizedChunks(head, 1);
        System.out.println("k=1: " + head);
        head = new ReverseLinkedListKChunks().reverseListInKSizedChunks(head, 2);
        System.out.println("k=2: " + head);
        head = new ReverseLinkedListKChunks().reverseListInKSizedChunks(head, 3);
        System.out.println("k=3: " + head);
        head = new ReverseLinkedListKChunks().reverseListInKSizedChunks(head, 4);
        System.out.println("k=4: " + head);
        head = new ReverseLinkedListKChunks().reverseListInKSizedChunks(head, 5);
        System.out.println("k=5: " + head);
        head = new ReverseLinkedListKChunks().reverseListInKSizedChunks(head, 6);
        System.out.println("k=6: " + head);
        head = new ReverseLinkedListKChunks().reverseListInKSizedChunks(head, 7);
        System.out.println("k=7: " + head);
        head = new ReverseLinkedListKChunks().reverseListInKSizedChunks(head, 8);
        System.out.println("k=8: " + head);
        head = new ReverseLinkedListKChunks().reverseListInKSizedChunks(head, 9);
        System.out.println("k=9: " + head);

    }



    //                                                     nH p
    //                                                           c
    public Node reverseListInKSizedChunks(Node head, int k) { //      3 < 6 < 1   9 < 2 < 5      8 < 12 > *
        if (head == null || head.next == null || k < 2) {    //                        pT               cT
            return head;                                           //       1 > 6 > 3 > 5 > 2 > 9  >12 > 8 > *
        }
        int i = 0;
        Node nH = null; // 1
        Node pT = null; // 3
        Node curr = head; //
        Node cT = head; // 9
        Node prev = null;
        while (curr != null) { // *
            Node nxt = curr.next; // *
            if (i > 0 && i % k == 0) { // process previous chunks i: 8
                if (pT == null) {
                    nH = prev;
                } else { // atleast two chunks are processed - connect them
                    pT.next = prev;
                }
                pT = cT;
                cT = curr;
            } else {
                curr.next = prev;
            }
            i++;
            prev = curr; // 12
            curr = nxt; //
        }
        cT.next = null;
        if (pT != null) pT.next = prev;
        if (nH == null) nH = prev;
        return nH;
    }
}

class Node {

    Node next;
    int data;

    public Node (int i) {
        data = i;
    }

    @Override
    public String toString() {
        String s = "";
        Node n = this;
        while (n != null) {
            s += (n.data + " > ");
            n = n.next;
        }
        s += "*";
        return s;
    }
}
