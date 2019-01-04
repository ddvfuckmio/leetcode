package nowcoder;

import codes.designs.TreeNode;

import java.util.*;

public class Solution {
	public ArrayList<ArrayList<Integer> > Print(TreeNode pRoot) {
		return null;
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
