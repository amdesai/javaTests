package algoProblemSolutions.maps;

import java.util.HashMap;
import java.util.Map;

public class Rabbits {

    public static void main(String[] args) {

        int[] input = {1, 0, 0, 1, 0};
        System.out.println(new Rabbits().numRabbits(input));

    }

    public int numRabbits(int[] answers) {

        Map<Integer, Integer> colorCount = new HashMap<Integer, Integer>();
        for (int i: answers) {
            int grp_size = i+1;
            colorCount.put(grp_size, colorCount.getOrDefault(grp_size, 0) + 1);
        }

        int cnt = 0;
        for (Map.Entry<Integer, Integer> e: colorCount.entrySet()) {
            int grps = e.getValue() / e.getKey();
            grps += e.getValue() % e.getKey() == 0? 0: 1;
            cnt += grps * e.getKey();
        }

        return cnt;
    }
}