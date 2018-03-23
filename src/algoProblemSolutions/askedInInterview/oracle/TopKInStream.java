package algoProblemSolutions.askedInInterview.oracle;

import java.util.PriorityQueue;

public class TopKInStream {

/*Input of stream of double value;
Write a program to return the top k out this stream.

Solution 1:
Read input from System.in

Solution 2:
Create a web service where data can be submitted via POST API

Solution 3:
Flat files - batch input - File.io

Focus on Solution 1 and Solution 2

*/


    class AniInputStream {

        public boolean openStream() {
            // handle opening of stream
            // read data from connection
            return true;
        }

        public boolean closeStream() {
            return true;
        }

        public double next() {
            return 0.0;
        }

        public boolean hasNext() {
            return true;
        }


 /*
 Heap:
 Access: O(1)
 Insertions: O(NlogK)
 Deletions: O(NlogK)

 0 1 2 3 4 5
 2 5 8 3 7 6
         *

 topk
 3 5 8



 k = 3

 789

 */

        public double[] getTopK(AniInputStream str, int k) throws Exception {

            // input validation
            if (k < 1) {
                throw new Exception("Invalid k");
            }
            if (str.hasNext() == false) { // no data
                return new double[0];
            }

            PriorityQueue<Double> heap = new PriorityQueue<Double>();

            while(str.hasNext()) { //  2 5 8 9 7 6
                double e = str.next(); // 6
                if (heap.size() < k){ // k: 3 0
                    heap.offer(e); // 7 8 9
                    continue;
                }
                if (e > heap.peek()) { //
                    heap.poll();
                    heap.offer(e);
                }
            }

            // convert heap into double array
            double[] ans = new double[heap.size()]; // 3
            int i = 0;
            while (!heap.isEmpty()) {
                ans[i] = heap.poll();
                i++;
            }

            return ans;
        }


    }


    public static void main(String[] args) {
//        AniInputStream s = new AniInputStream();

    }
}
