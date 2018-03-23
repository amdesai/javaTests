package algoProblemSolutions.arrays;

import java.util.LinkedList;
import java.util.List;

public class PermuteString {
    public List<String> letterCasePermutation(String S) {

        LinkedList<String> q = new LinkedList<String>();

        q.offer("");

        for (char c: S.toCharArray()) {
            if ('a' <= c && c <= 'z' || 'A' <= c && c <= 'Z') {
                LinkedList<String> qNew = new LinkedList<String>();
                while (!q.isEmpty()) {
                    qNew.offer(q.poll() + c);
                    if ('a' <= c && c <= 'z') {
                        qNew.offer(q.poll() + String.valueOf(c).toUpperCase());
                    } else {
                        qNew.offer(q.poll() + String.valueOf(c).toLowerCase());
                    }
                }
                q = qNew;
            } else {
                LinkedList<String> qNew = new LinkedList<String>();
                while (!q.isEmpty()) {
                    qNew.offer(q.poll() + c);
                }
                q = qNew;
            }
        }
        // List result = new ArrayList<String>(q);
        return q;
    }
}