package nowcoder;

import java.util.ArrayDeque;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution {
	private boolean sign = true;
	private PriorityQueue<Integer> minQueue = new PriorityQueue<>(new MaxComparator());
	private PriorityQueue<Integer> maxQueue = new PriorityQueue<>(new MinComparator());

	public void Insert(Integer num) {
		if (sign) {
			maxQueue.offer(num);
			minQueue.offer(maxQueue.poll());
		} else {
			minQueue.offer(num);
			maxQueue.offer(minQueue.poll());
		}
		sign = !sign;
	}

	public Double GetMedian() {
		if(!sign){
			return (double) minQueue.peek();
		}
		return (double) (minQueue.peek()+maxQueue.peek())/2;
	}


	public static void main(String[] args) throws Exception {
		Solution solution = new Solution();
		PriorityQueue<Integer> heap = new PriorityQueue<>();
		heap.offer(1);
		heap.offer(10);
		heap.offer(-1);

		System.out.println(heap);

	}

	class MinComparator implements Comparator<Integer> {
		@Override
		public int compare(Integer o1, Integer o2) {
			return o1 - o2;
		}
	}

	class MaxComparator implements Comparator<Integer> {
		@Override
		public int compare(Integer o1, Integer o2) {
			return o2 - o1;
		}
	}
}
