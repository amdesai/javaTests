package randomAnitest.stacksAndQueues;

import java.util.Stack;

public class QueueUsingStack {

    Stack<Integer> s1 = new Stack<Integer>();
    Stack<Integer> s2 = new Stack<Integer>();

    void enqueue(Integer i) {
        s1.push(i);
    }

    Integer dequeue() {
        if (s1.size() + s2.size() == 0) {
            return null; // or throw an Exception
        } else {
            if (!s2.isEmpty()) {
                return s2.pop();
            } else {
                moveElements();
                return s2.pop();
            }
        }
    }

    void moveElements() {
        while (!s1.isEmpty()) {
            s2.push(s1.pop());
        }
    }

    public String toString() {
        return "queue part: " + s1.toString() + " | stack part: " + s2.toString();
    }

    public static void main(String ... args) {

        QueueUsingStack qS = new QueueUsingStack();

        qS.enqueue(4);
        qS.enqueue(5);
        qS.enqueue(2);
        qS.enqueue(7);
        qS.enqueue(1);
        System.out.println(qS.toString());
        qS.dequeue();
        qS.dequeue();
        System.out.println(qS.toString());
        qS.enqueue(6);
        System.out.println(qS.toString());
        qS.dequeue();
        qS.dequeue();
        qS.enqueue(7);
        System.out.println(qS.toString());
        qS.dequeue();
        System.out.println(qS.toString());
        qS.dequeue();
        System.out.println(qS.toString());

    }


}
