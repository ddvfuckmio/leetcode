package nowcoder;

import codes.designs.TreeNode;

import java.lang.reflect.Array;
import java.util.*;

public class Solution {
	public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
		ArrayList<ArrayList<Integer>> rs = new ArrayList<>();
		if (pRoot == null) return rs;

		int sign = 1;

		LinkedList<TreeNode> queue = new LinkedList<>();
		queue.offer(pRoot);

		while (!queue.isEmpty()) {
			ArrayList<Integer> list = new ArrayList<>();
			int start, end;
			if ((sign & 1) == 1) {
				start = 0;
				end = queue.size();
				for (; start < end; start++) {
					TreeNode node = queue.pollFirst();
					list.add(node.val);
					if (node.left != null)
						queue.offerLast(node.left);
					if (node.right != null)
						queue.offerLast(node.right);
				}
				sign = sign ^ 1;
			} else {
				start = queue.size();
				end = 0;
				for (; start > end; start--) {
					TreeNode node = queue.pollLast();
					list.add(node.val);
					if (node.right != null) queue.offerFirst(node.right);
					if (node.left != null) queue.offerFirst(node.left);

				}
				sign = sign ^ 1;

			}
			rs.add(list);
		}

		return rs;
	}


	public static void main(String[] args) {
		Solution solution = new Solution();
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(6);
		root.right.left = new TreeNode(7);
		root.right.right = new TreeNode(8);
		ArrayList<ArrayList<Integer>> list = solution.Print(root);
		System.out.println(list);

	}
}
