package codes.designs;

public class Main {
    public static void main(String[] args) {
        Node head = Node.makeNodeWithArray(new int[] {5, 5, 1, 1, 2});
        head.travel(head);
        head = Solution(head, 2);
        head.travel(head);
    }

    private static Node Solution(Node head, int n) {
        if (head == null) return head;
        Node lh = null, eh = null, mh = null;
        Node lt = null, et = null, mt = null;
        Node currentNode = head;
        while (currentNode != null) {
            Node nextNode = currentNode.next;
            currentNode.next = null;
            if (currentNode.data < n) {
                if (lh == null) {
                    lh = currentNode;
                    lt = currentNode;
                } else {
                    lt.next = currentNode;
                    lt = currentNode;
                }
            } else if (currentNode.data == n) {
                if (eh == null) {
                    eh = currentNode;
                    et = currentNode;
                } else {
                    et.next = currentNode;
                    et = currentNode;
                }
            } else {
                if (mh == null) {
                    mh = currentNode;
                    mt = currentNode;
                } else {
                    mt.next = currentNode;
                    mt = currentNode;
                }
            }
            currentNode = nextNode;
        }

        if (lh != null) {
            lt.next = eh;
            et = et == null ? lt : et;
        }

        if (eh != null) {
            et.next = mh;
        }

        return lh != null ? lh : eh != null ? eh : mh;
    }

    private static Node Solution2(Node head, int n) {
        if (head == null) return head;
        Node currentNode = head;
        int length = 0;
        while (currentNode != null) {
            length++;
            currentNode = currentNode.next;
        }
        currentNode = head;
        Node[] a = new Node[length];

        for (int i = 0; i < length; i++) {
            a[i] = new Node(currentNode.data);
            currentNode = currentNode.next;
        }

        nodePartition(a, n);
        for (int i = 0; i < length - 1; i++) a[i].next = a[i + 1];
        return a[0];
    }

    private static void nodePartition(Node[] a, int n) {
        int length = a.length;
        int smallIndex = 0;
        int maxIndex = length - 1;
        int i = 0;
        while (i <= maxIndex) {
            if (a[i].data < n) {
                swap(a, i++, smallIndex++);
            } else if (a[i].data == n) {
                i++;
            } else {
                swap(a, i, maxIndex--);
            }
        }
    }

    private static void swap(Node[] a, int i, int j) {
        Node temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
