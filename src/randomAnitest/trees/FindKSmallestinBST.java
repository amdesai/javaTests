package randomAnitest.trees;

public class FindKSmallestinBST {

    /*
    Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.
    Note:
    You may assume k is always valid, 1 ≤ k ≤ BST's total elements.
    Follow up:
    What if the BST is modified (insert/delete operations) often and you need to find the kth smallest frequently? How would you optimize the kthSmallest routine?


                6
                 3             9
                         1          5     7       11
                    2     4                    10
    k = 4
    */

    Node inOrderMod(Node root, int k) {
        Counter c = new Counter();
        c.k = k;
        return inOrderMod(root,c);
    }

    Node inOrderMod(Node root, Counter c) { // root: 3
        if (root == null) {
            return null;
        }
        Node left = inOrderMod(root.left, c); // null
        if (left != null) {
            return left;
        }
        c.k--; // k: 2
        if (c.k == 0) { // found the kth node
            return root;
        }
        Node right = inOrderMod(root.right, c);
        if (right != null) {
            return right;
        }
        return null;
    }

}

class Counter { // need a Counter class for scoping of k within recursive calls
    int k;
}

