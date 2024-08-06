package PriorityQueue;

import java.util.*;

public class TaskScheduler {
    public static void main(String[] args) {
        char[] tasks = new char[] {'A','A','A','B','B','B'};
        int n = 2;
        TaskScheduler taskScheduler = new TaskScheduler();
        int result = taskScheduler.leastInterval(tasks, n);
        System.out.println(result == 8);

        n = 3;
        result = taskScheduler.leastInterval(tasks, n);
        System.out.println(result == 10);
    }

    public int leastInterval(char[] tasks, int n) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : tasks) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        PriorityQueue<Integer> heap = new PriorityQueue(Collections.reverseOrder());
        heap.addAll(map.values());
        int result = 0;
        while (!heap.isEmpty()) {
            int time = 0;
            List<Integer> temp = new ArrayList<>();
            for (int i = 0; i < n + 1; i++) {
                if (!heap.isEmpty()) {
                    temp.add(heap.remove() - 1);
                    time++;
                }
            }
            for (int t : temp) {
                if (t > 0) heap.add(t);
            }
            result += heap.isEmpty() ? time : n + 1;
        }
        return result;
    }
}
