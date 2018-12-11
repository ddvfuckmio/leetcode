package zuo;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author : ddv
 * @date : 2018/12/11 下午1:59
 */
public class Main {
    static class Job {
        public int cost;
        public int profit;

        public Job() {}

        public Job(int cost, int profit) {
            this.cost = cost;
            this.profit = profit;
        }

        @Override
        public String toString() {
            return "Job{" + "cost=" + cost + ", profit=" + profit + '}';
        }
    }

    static class JobCostComparator implements Comparator<Job> {

        @Override
        public int compare(Job o1, Job o2) {
            return o1.cost - o2.cost;
        }
    }

    static class JobProfitComparator implements Comparator<Job> {

        @Override
        public int compare(Job o1, Job o2) {
            return o2.profit - o1.profit;
        }
    }

    public static void main(String[] args) {
        PriorityQueue<Job> costQueue = new PriorityQueue<>(new JobCostComparator());
        PriorityQueue<Job> profitQueue = new PriorityQueue<>(new JobProfitComparator());
        int[] costs = new int[] {1, 4, 6, 3, 2, 7, 8, 9, 1, 10};
        int[] profits = new int[] {4, 3, 1, 5, 6, 4, 3, 7, 8, 10};
        Job[] jobs = new Job[costs.length];
        for (int i = 0; i < costs.length; i++) {
            jobs[i] = new Job(costs[i], profits[i]);
        }

        int ans = findMaxProfit(costQueue, profitQueue, jobs, 3, 2);
        System.out.println(ans);
    }

    private static int findMaxProfit(
            PriorityQueue<Job> costQueue,
            PriorityQueue<Job> profitQueue,
            Job[] jobs,
            int times,
            int money) {

        for (int i = 0; i < jobs.length; i++) {
            costQueue.offer(jobs[i]);
        }
        while (times > 0) {
            if (!costQueue.isEmpty()) {
                while (!costQueue.isEmpty() && costQueue.peek().cost <= money) {
                    profitQueue.offer(costQueue.poll());
                }
            }

            if (!profitQueue.isEmpty()) {
                money += profitQueue.poll().profit;
                times--;
            }
        }

        return money;
    }
}
