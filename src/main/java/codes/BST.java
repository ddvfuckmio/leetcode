package codes;

import codes.designs.TreeNode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BST {

    public TreeNode makeTree() {
        TreeNode root = new TreeNode(8);
        InsertBST(root, new int[] {3, 10, 1, 6, 14, 4, 7, 13});
        return root;
    }

    public TreeNode RecurSearchBST(TreeNode tree, int data) {
        if (tree == null) return null;
        if (data == tree.val) return tree;
        else if (data < tree.val) return RecurSearchBST(tree.left, data);
        else return RecurSearchBST(tree.right, data);
    }

    public TreeNode SearchBST(TreeNode tree, int data) {
        if (tree == null) return null;
        while (tree != null) {
            if (tree.val == data) return tree;
            else if (data < tree.val) tree = tree.left;
            else tree = tree.right;
        }
        return null;
    }

    public void InsertBST(TreeNode tree, int[] data) {
        int i = 0;
        while (i < data.length) {
            TreeNode newNode = SearchBST(tree, data[i]);
            TreeNode parentNode = null;
            TreeNode currentNode = tree;

            if (newNode != null) return;
            newNode = new TreeNode(data[i]);

            while (true) {
                parentNode = currentNode;
                if (data[i] < currentNode.val) {
                    currentNode = currentNode.left;
                    if (currentNode == null) {
                        parentNode.left = newNode;
                        break;
                    }
                } else {
                    currentNode = currentNode.right;
                    if (currentNode == null) {
                        parentNode.right = newNode;
                        break;
                    }
                }
            }
            i++;
        }
    }

    public void TraverseByLevel(TreeNode tree) {
        Queue<TreeNode> queue = new LinkedList<>();
        if (tree == null) return;

        queue.offer(tree);
        while (queue.size() > 0) {
            TreeNode node = queue.poll();

            if (node.left != null) queue.offer(node.left);
            if (node.right != null) queue.offer(node.right);

            System.out.println(node.val);
        }
    }

    public void RecurPreTraverse(TreeNode tree) {
        if (tree == null) return;
        System.out.print(tree.val + " ");
        RecurPreTraverse(tree.left);
        RecurPreTraverse(tree.right);
    }

    public void RecurInOrderTraverse(TreeNode tree) {
        if (tree != null) {
            RecurInOrderTraverse(tree.left);
            System.out.print(tree.val + " ");
            RecurInOrderTraverse(tree.right);
        }
    }

    public void RecurPostTraverse(TreeNode tree) {
        if (tree.left != null) RecurPostTraverse(tree.left);
        if (tree.right != null) RecurPostTraverse(tree.right);
        System.out.print(tree.val + " ");
    }

    public void preOrder(TreeNode tree) {
        if (tree == null) return;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(tree);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            System.out.printf("%s ", node.val);
            if (node.right != null) stack.push(node.right);
            if (node.left != null) stack.push(node.left);
        }
    }

    public void inOrder(TreeNode tree) {
        if (tree == null) return;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode currentNode = tree;
        while (currentNode != null || !stack.isEmpty()) {
            while (currentNode != null) {
                stack.push(currentNode);
                currentNode = currentNode.left;
            }

            currentNode = stack.pop();
            System.out.printf("%s ", currentNode.val);

            if (currentNode.right != null) {
                currentNode = currentNode.right;
            } else {
                currentNode = null;
            }
        }
    }

    public static void main(String[] args) {
        BST root = new BST();
    }
}
