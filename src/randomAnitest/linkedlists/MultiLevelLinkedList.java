package randomAnitest.linkedlists;

public class MultiLevelLinkedList {

    public static void main(String... args) {

        MLNode a = new MLNode('A');
        MLNode b = new MLNode('B');
        MLNode c = new MLNode('C');
        MLNode d = new MLNode('D');
        MLNode e = new MLNode('E');
        MLNode f = new MLNode('F');
        MLNode g = new MLNode('G');
        MLNode h = new MLNode('H');
        MLNode i = new MLNode('I');
        MLNode j = new MLNode('J');
        a.next = b;
        b.subList = c;
        c.next = d;
        d.subList = e;
        e.next = f;
        d.next = g;
        b.next = h;
        h.subList = i;
        h.next = j;

        print(a);
        flatten(a);
        print(a);

        // already flat input
        a = new MLNode('A');
        b = new MLNode('B');
        c = new MLNode('C');
        a.next = b;
        b.next = c;

        print(a);
        flatten(a);
        print(a);

        a = null;
        print(a);
        flatten(a);
        print(a);

    }

    public static void print(MLNode n) {
        while(n !=null){
            if (n.subList != null) print(n.subList);
            System.out.print(n);
            n = n.next;
        }
        System.out.println();
    }

    public static MLNode getTail(MLNode n) {

        MLNode prev = null;

        while(n != null) {
            prev = n;
            n = n.next;
        }

        return prev;

    }


    public static MLNode flatten(MLNode head) {

        // base case
        if (head == null) {
            return head;
        }
        //insert sublists at current MLNode if the node is a branch node
        MLNode curr = head;
        while (curr != null) {
            // Check if node has a sublist
            // If there is a sublist, enter it into the main list
            MLNode tmp = curr.next;
            if (curr.subList != null) {
                MLNode sub = flatten(curr.subList);
                curr.subList = null; // remove old sublist pointers
                curr.next = sub;
                MLNode subTail = getTail(sub);
                subTail.next = tmp;
            }
            curr = tmp;
        }

        return head;

    }
}

class MLNode {

    public MLNode next;
    public MLNode subList;
    public Character data;

    public MLNode(char c) {
        data = Character.valueOf(c);
    }

    @Override
    public String toString() {
        return String.valueOf(data) + "->";
    }
}
