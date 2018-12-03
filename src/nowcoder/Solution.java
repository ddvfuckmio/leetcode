package nowcoder;

import codes.designs.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if (root != null) queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node.left != null) queue.offer(node.left);
            if (node.right != null) queue.offer(node.right);
            list.add(node.val);
        }

        return list;
    }

    public int maxSum(int[] a, int n) {
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += a[i];
        }
        max = sum;

        for (int i = n; i < a.length; i++) {
            sum = sum - a[i - n] + a[i];
            max = max > sum ? max : sum;
        }

        return max;
    }

    public static void main(String[] args) throws Exception {
        Solution solution = new Solution();
    }
}
