package codes.designs;

/*
 * @author : ddv
 * @date   : 2018/10/7 下午12:53
 */

import java.util.Stack;

public class TreeNode {
    public TreeNode left;
    public TreeNode right;
    public int val;

    public TreeNode(int data) {
        this.val = data;
    }

    @Override
    public String toString() {
        return "TreeNode{" + "left=" + left + ", right=" + right + ", val=" + val + '}';
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(8);
        root.left = new TreeNode(7);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(11);
        root.left.right.left = new TreeNode(9);
        root.left.left.left = new TreeNode(6);

        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        root.right.right = new TreeNode(1);
        root.right.right.right = new TreeNode(0);

        preOrder(root);
        System.out.println();
        inOrder(root);
        System.out.println();
        postOrder(root);
    }

    private static void preOrder(TreeNode root) {
        if (root == null) return;
        System.out.printf("%d ", root.val);
        preOrder(root.left);
        preOrder(root.right);
    }

    private static void preOrder2(TreeNode root) {
        if (root == null) return;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        TreeNode currentNode = null;
        while (!stack.isEmpty()) {
            currentNode = stack.pop();
            System.out.printf("%d ", currentNode.val);
            if (currentNode.right != null) stack.push(currentNode.right);
            if (currentNode.left != null) stack.push(currentNode.left);
        }
    }

    private static void inOrder(TreeNode root) {
        if (root == null) return;
        inOrder(root.left);
        System.out.printf("%d ", root.val);
        inOrder(root.right);
    }

    private static void inOrder2(TreeNode root) {
        if (root == null) return;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        while (node != null || !stack.isEmpty()) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }

            node = stack.pop();
            System.out.printf("%d ", node.val);

            node = node.right;
        }
    }

    private static void postOrder(TreeNode root) {
        if (root == null) return;
        postOrder(root.left);
        postOrder(root.right);
        System.out.printf("%d ", root.val);
    }

    private static void postOrder2(TreeNode root) {
        if (root == null) return;
        Stack<TreeNode> stack = new Stack<>();
        Stack<TreeNode> logStack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode currentNode = stack.pop();
            logStack.push(currentNode);
            if (currentNode.left != null) stack.push(currentNode.left);
            if (currentNode.right != null) stack.push(currentNode.right);
        }
        while (!logStack.isEmpty()) {
            System.out.printf("%d ", logStack.pop().val);
        }
    }
}
