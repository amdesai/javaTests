package algoProblemSolutions.askedInInterview.concur;

import java.util.*;
import java.util.Random;

public class BucketSortInteger {
    public static void main(String[] args) {
        //
        int rL = 8;
        int rH = 21;

        int[] copy1 = new int[100000000];
        int[] copy2 = new int[100000000];
        int[] copy3 = new int[100000000];
        populateData(copy1, copy2, copy3, rL, rH);
//        Arrays.sort(copy1);
//        Arrays.sort(copy2);
//        Arrays.sort(copy3);

        long s = System.currentTimeMillis();
        Arrays.sort(copy1);
        long e = System.currentTimeMillis();
        System.out.println("o(nlogn) time taken: [" + (e - s) +" ms]");

        s = System.currentTimeMillis();
        bucketSort(copy2, rL, rH);
        e = System.currentTimeMillis();
        System.out.println("o(n) time taken with int[] buckets: [" + (e - s) +" ms]");

        s = System.currentTimeMillis();
        bucketSortHashMap(copy3, rL, rH);
        e = System.currentTimeMillis();
        System.out.println("o(n) time taken with hashmap buckets: [" + (e - s) +" ms]");

    }

    private static void populateData(int[] a1, int[] a2, int[] a3, int l, int h) {
        for (int i = 0; i< a1.length; i++) {
            Random rnd = new Random();
            int rN = rnd.nextInt(h - l + 1) + l;
            a1[i] = rN;
            a2[i] = rN;
            a3[i] = rN;
        }
    }

    /*
    l = 3
    h = 5
    5 - 3 = 2 + 1
    */
    public static void bucketSort(int[] arr, int l, int h) {
        int[] freq = new int[h-l+1];
        for (int i: arr) {
            freq[i-l]++;
        }
        int in = 0;
        for (int j = l; j <= h; j++) {
            if (freq[j-l] != 0) {
                int cnt = freq[j-l];
                for (int k = 1; k <= cnt; k++) {
                    arr[in++] = j;
                }
            }
        }
    }


    public static void bucketSortHashMap(int[] arr, int l, int h) {
        Map<Integer, Integer> freq = new HashMap<>();
        for (int i: arr) {
            freq.put(i, freq.getOrDefault(i, 0) + 1);
        }
        int in = 0;
        for (int j = l; j <= h; j++) {
            if (freq.containsKey(j)) {
                int cnt = freq.get(j);
                for (int k = 1; k <= cnt; k++) {
                    arr[in++] = j;
                }
            }
        }
    }

}
