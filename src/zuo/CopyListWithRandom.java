package zuo;

/*
 * @author : ddv
 * @date   : 2018/10/2 上午11:34
 */

import java.util.HashMap;
import java.util.Map;

public class CopyListWithRandom {
    private static class Node {
        int data;
        Node next;
        Node random;

        public Node(int data) {
            this.data = data;
        }
    }

    public static void main(String[] args) {
        Node head1 = new Node(0);
        head1.next = new Node(1);
        head1.next.next = new Node(2);
        head1.next.next.next = new Node(3);
        head1.next.next.next.next = new Node(4);
        head1.next.next.next.next.next = new Node(5);

        Node head2 = new Node(0);
        head2.next = new Node(1);
        head2.next.next = head1.next.next;

        print(head1);
        printListHashcode(head1);
        print(head2);
        printListHashcode(head2);

        Node circleNode = findCrossNode(head1, head2);
    }

    private static Node findCrossNode(Node head1, Node head2) {
        Node node1 = head1, end1 = null;
        Node node2 = head2, end2 = null;
        int length1 = 1, length2 = 1;

        while (node1.next != null) {
            length1++;
            node1 = node1.next;
        }

        end1 = node1;
        node1 = head1;

        while (node2.next != null) {
            length2++;
            node2 = node2.next;
        }

        end2 = node2;
        node2 = head2;

        return null;
    }

    private static void printListHashcode(Node head1) {
        Node cur = head1;
        while (cur != null) {
            System.out.printf("%s ", cur.hashCode());
            cur = cur.next;
        }
        System.out.println();
    }

    // 寻找入环节点
    private static Node findCircleHead(Node head) {
        Node fast = head, slow = head;
        Boolean sign = false;
        while (true) {
            if (!sign) {
                if (fast == null) return fast;
                fast = fast.next.next;
                slow = slow.next;
                if (fast == slow) {
                    sign = true;
                    fast = head;
                }
            } else {
                fast = fast.next;
                slow = slow.next;
                if (fast == slow) return fast;
            }
        }
    }

    private static Node copyNodeList1(Node head) {
        Node cur = head;
        Node next = null;

        while (cur != null) {
            next = cur.next;
            cur.next = new Node(cur.data);
            cur.next.next = next;
            cur = next;
        }

        cur = head;

        while (cur != null) {
            cur.next.random = cur.random.next;
            cur = cur.next.next;
        }

        cur = head;
        Node newHead = head.next;
        Node copyNode = null;

        while (cur != null) {
            next = cur.next.next;
            copyNode = head.next;
            cur.next = next;
            copyNode.next = next != null ? next.next : null;
            cur = next;
        }

        return newHead;
    }

    private static Node copyNodeList(Node head) {
        Map<Integer, Node> map = new HashMap<>();
        Node node = head;
        while (node != null) {
            int key = node.data;
            Node temp = new Node(key);
            map.put(key, temp);
            node = node.next;
        }

        node = head;

        while (node != null) {
            if (node.next != null) map.get(node.data).next = map.get(node.next.data);
            if (node.random != null) map.get(node.data).random = map.get(node.random.data);
            node = node.next;
        }

        return map.get(head.data);
    }

    private static void printRandom(Node head) {
        Node node = head;
        while (node != null && node.random != null) {
            System.out.printf("%d ", node.random.data);
            node = node.next;
        }
        System.out.println();
    }

    private static void print(Node head) {
        Node node = head;
        while (node != null) {
            System.out.printf("%d ", node.data);
            node = node.next;
        }
        System.out.println();
    }

    private static void setRandom(Node head) {
        Node node = head;
        while (node != null) {
            node.random = node;
            node = node.next;
        }
    }
}
