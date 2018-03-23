package algoProblemSolutions.stacksAndQueues;

/*

Implement a stack using queue.

q1: 2 3 7 4
5
q2:

*/

import java.util.ArrayDeque;
import java.util.Queue;

class StackUsingQueue {

    Queue<Integer> q1 = new ArrayDeque<Integer>();
    Queue<Integer> q2 = new ArrayDeque<Integer>();

    void push(Integer e) {
        q1.offer(e);
    }

    Integer pop() {
        if (q1.isEmpty()) {
            return null; // throw an Exception
        }
        while (q1.size() > 1) {
            q2.offer(q1.poll());
        }
        Integer e = q1.poll();
        // swap pointers
        Queue tmp = q1;
        q1 = q2;
        q2 = tmp;
        return e;
    }

    public String toString() {
        return "Bottom -> ||" + q1.toString() + " <- Top";
    }

    public static void main(String ... args) {

        StackUsingQueue sQ = new StackUsingQueue();

        sQ.push(4);
        System.out.println(sQ.toString());
        sQ.push(6);
        sQ.push(9);
        sQ.push(2);
        sQ.push(8);
        System.out.println(sQ.toString());
        sQ.toString();
        sQ.push(2);
        System.out.println(sQ.toString());
        sQ.pop();
        sQ.pop();
        sQ.pop();
        sQ.pop();
        System.out.println(sQ.toString());
        sQ.push(3);
        System.out.println(sQ.toString());
        sQ.push(7);
        System.out.println(sQ.toString());
        sQ.pop();
        System.out.println(sQ.toString());
        sQ.push(1);
        System.out.println(sQ.toString());

    }

}

