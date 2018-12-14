package nowcoder;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class Solution {

	public ArrayList<Integer> maxInWindows(int[] num, int size) {
		ArrayList<Integer> list = new ArrayList<>();

		if (size <= 0) return list;

		for (int i = 0; i < num.length - size + 1; i++) {
			list.add(help(num, i, size));
		}

		return list;

	}

	private Integer help(int[] num, int index, int size) {
		int max = num[index];

		for (int i = index + 1; i < index + size - 1; i++) {
			max = Math.max(max, num[i]);
		}

		return max;
	}

	public static void main(String[] args) throws Exception {
		Solution solution = new Solution();
		
	}
}
