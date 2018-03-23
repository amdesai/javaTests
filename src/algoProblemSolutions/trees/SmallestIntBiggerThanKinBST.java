package algoProblemSolutions.trees;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class SmallestIntBiggerThanKinBST {
/*

finding smallest number bigger than k in a BST

input:
BST -
		  8
	        5              14
                2    7     9            16
                                12   15      17
		      11

k -> 10

inOrderTrav = {2, 5, 7, 8, 9, 11, 12, 14 .. }
*/

    public static void main (String ... args) {



    }

    int findSmallestNumBiggerThanK(Node n, int k) {
        Node curr = n;
        Node ans = null;
        while (n != null) { // n: null
            if (n.data <= k) { // go right
                n = n.right;
            } else {
                ans = n; // ans: 11
                n = n.left;
            }
        }
        if (ans == null) {
            return -1; // or throw an exception such not found
        } else {
            return ans.data;
        }
    }

    List<Integer> inOrderTrav(Node n) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        inOrderTravRec(n, list);
        return list;
    }

    void inOrderTravRec(Node n, ArrayList list) {
        if (n == null) {
            return;
        }
        inOrderTravRec(n.left, list);
        list.add(n);
        inOrderTravRec(n.right, list);
    }



    public ArrayList<Integer> inOrderTravNonRec(Node n) {
        if (n == null) return null;

        ArrayList<Integer> list = new ArrayList<Integer>();
        Stack<Node> s = new Stack<Node>();

        Node curr = n;
        while (curr.left != null) {
            s.push(curr.left);
            curr = curr.left;
        }

        while (!s.isEmpty()) { // s:
            curr = s.pop(); // curr: 17
            list.add(curr.data); // list: 2, 3, 5, 6, 7, 8, 9, 11, 14, 15, 16, 17
            if (curr.right != null) {
                s.push(curr.right); //
                curr = curr.right;  // curr: 17
                while (curr.left != null) {
                    s.push(curr.left);
                    curr = curr.left;
                }
            }
        }
        return list;
    }
}