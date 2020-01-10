package codes.designs;

/*
翻转链表
*/
public class Node {
    public int data;
    public Node next;

    public Node() {}

    public Node(int data) {
        this.data = data;
    }

    public void travel(Node node) {
        while (node != null) {
            System.out.printf("%d ", node.data);
            node = node.next;
        }
        System.out.println();
    }

    public Node insert(Node node, int data) {
        Node newNode = new Node(data);
        node.next = newNode;
        return newNode;
    }

    public static Node makeNode(int n) {
        Node head = new Node(0);
        Node temp = head;
        for (int i = 1; i < n; i++) {
            Node node = new Node(i);
            temp.next = node;
            temp = node;
        }
        return head;
    }

    public static Node makeNodeWithArray(int[] array) {
        Node head = new Node(array[0]);
        Node node = head;
        for (int i = 1; i < array.length; i++) {
            Node next = new Node(array[i]);
            node.next = next;
            node = next;
        }
        return head;
    }

    public Node turnNodeList(Node node) {
        if (node == null || node.next == null) return node;
        Node newHeader = null; // 最终返回结点
        Node preNode = null; // 前一结点
        Node pointNode = node; // 当前节点
        while (pointNode != null) {
            Node nextNode = pointNode.next; // 保存后一结点
            if (nextNode == null) {
                newHeader = pointNode;
            }
            pointNode.next = preNode; // 改变当前节点指向
            preNode = pointNode; // 改变前一结点
            pointNode = nextNode; // 结点后移
        }
        return newHeader;
    }

    public Node turnNodeList2(Node node) {
        if (node == null || node.next == null) {
            return node;
        }
        Node nextNode = node.next;
        node.next = null;
        Node newHead = turnNodeList2(nextNode);
        nextNode.next = node;
        return newHead;
    }

    // 判断回文链表 额外空间复杂度(1)
    public static boolean isPalindrome(Node node) {
        Node node1 = node;
        Node node2 = node;
        while (node1.next != null && node1.next.next != null) {
            node1 = node1.next.next;
            node2 = node2.next;
        }

        Node nextNode = node2.next;
        node2.next = null;
        Node pre = node2;
        Node temp;

        while (nextNode != null) {
            temp = nextNode.next;
            nextNode.next = pre;
            if (temp == null) break;
            pre = nextNode;
            nextNode = temp;
        }

        while (node != null) {
            if (node.data != nextNode.data) return false;
            node = node.next;
            nextNode = nextNode.next;
        }

        return true;
    }
}
