package extra;

import java.util.*;

public class 堆_线段重合 {
    public static void main(String[] args) {
        int[][] arr = {{1, 4}, {2, 4}, {3, 4}, {4, 5}};
        System.out.println(solution(arr));
    }

    public static int solution(int[][] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        int max = 0;
        List<Info> infoList = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            Info info = new Info(arr[i][0], arr[i][1]);
            infoList.add(info);
        }
        Collections.sort(infoList, new InfoComparator());

        PriorityQueue<Integer> priorityQueue = new PriorityQueue();
        for (int i = 0; i < infoList.size(); i++) {
            while (!priorityQueue.isEmpty() && priorityQueue.peek() <= infoList.get(i).min) {
                priorityQueue.poll();
            }
            priorityQueue.add(infoList.get(i).max);
            max = Math.max(max, priorityQueue.size());

        }
        return max;
    }

    public static class Info {
        int min;
        int max;

        public int getMin() {
            return min;
        }

        public void setMin(int min) {
            this.min = min;
        }

        public int getMax() {
            return max;
        }

        public void setMax(int max) {
            this.max = max;
        }

        public Info(int min, int max) {
            this.min = min;
            this.max = max;
        }
    }

    public static class InfoComparator implements Comparator<Info> {
        @Override
        public int compare(Info o1, Info o2) {
            return o1.min - o2.min;
        }
    }
}
