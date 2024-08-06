package PriorityQueue;

import java.util.PriorityQueue;

public class RelativeRanks {
    public static void main(String[] args) {
        int[] score = new int[]{5,4,3,2,1};
        RelativeRanks relativeRanks = new RelativeRanks();
        String[] result = relativeRanks.findRelativeRanks(score);
        for (String r : result) {
            System.out.println(r);
        }
    }

    public String[] findRelativeRanks(int[] score) {
        String[] result = new String[score.length];
        PriorityQueue<Contestant> heap = new PriorityQueue<Contestant>((a, b) -> b.score - a.score);

        for (int i = 0; i < score.length; i++) {
            heap.offer(new Contestant(i, score[i]));
        }
        int rank = 1;
        while (!heap.isEmpty()) {
            Contestant contestant = heap.poll();
            if (rank == 1) {
                result[contestant.index] = "Gold Medal";
            } else if (rank == 2) {
                result[contestant.index] = "Silver Medal";
            } else if (rank == 3) {
                result[contestant.index] = "Bronze Medal";
            } else {
                result[contestant.index] = String.valueOf(rank);
            }
            rank++;
        }
        return result;
    }

    class Contestant {
        public int index;
        public int score;

        public Contestant(int index, int score) {
            this.index = index;
            this.score = score;
        }
    }
}
