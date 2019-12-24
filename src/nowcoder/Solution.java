package nowcoder;

import codes.designs.TreeNode;

public class Solution {
    boolean isSymmetrical(TreeNode pRoot) {
        if (pRoot == null)
            return true;
        return depth(pRoot.left, pRoot.right);
    }

    private boolean depth(TreeNode left, TreeNode right) {
        if (left == null)
            return right == null;
        if (right == null)
            return false;
        if (left.val != right.val)
            return false;

        return depth(left.left, right.right) && depth(left.right, right.left);

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


	}
}
