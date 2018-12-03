package codes.designs;

/* 双向链表 💕
 * @author : ddv
 * @date   : 2018/9/26 下午2:13
 */

public class DoubleNode {
    private int data;
    private DoubleNode pre;
    private DoubleNode next;

    public DoubleNode(int data) {
        this.data = data;
    }

    // 从头节点遍历
    public void traver(DoubleNode node) {
        while (node != null) {
            System.out.printf("%d ", node.data);
            node = node.next;
        }
    }

    // 根据next寻找最后一个节点
    public DoubleNode findLastNode(DoubleNode node) {
        while (node.next != null) {
            node = node.next;
        }
        return node;
    }

    // 根据pre向前遍历
    public void preTraver(DoubleNode node) {
        while (node != null) {
            System.out.printf("%d ", node.data);
            node = node.pre;
        }
    }

    // 根据pre找头节点
    public DoubleNode findFirstNode(DoubleNode node) {
        while (node.pre != null) {
            node = node.pre;
        }
        return node;
    }

    // 置反链表并返回新链表的尾节点 递归
    public static DoubleNode turnList(DoubleNode node) {
        DoubleNode pre = node.pre;
        DoubleNode nextNode = node.next;
        if (nextNode == null) {
            node.pre = null;
            node.next = pre;
            return node;
        }
        node.next = pre;
        node.pre = turnList(nextNode);
        return node;
    }

    // 置反链表并返回新链表头结点 递归
    public static DoubleNode turnList2(DoubleNode node) {
        DoubleNode preNode = node.pre;
        DoubleNode nextNode = node.next;
        if (preNode == null) {
            node.next = preNode;
            node.pre = nextNode;
            return node;
        }
        node.pre = nextNode;
        node.next = turnList2(preNode);
        return node;
    }

    public static DoubleNode turnList3(DoubleNode node) {
        return null;
    }

    // 格式化打印每个节点的 pre,val,next
    public void checkList(DoubleNode node) {
        while (node != null) {
            printNode(node);
            node = node.next;
        }
    }

    private void printNode(DoubleNode node) {
        if (node.pre != null) {
            System.out.printf("%d ", node.pre.data);
        } else {
            System.out.printf("  ");
        }

        System.out.printf("%d ", node.data);

        if (node.next != null) {
            System.out.printf("%d ", node.next.data);
        }
        System.out.println();
    }

    // 生产链表
    public static DoubleNode makeList(int n) {
        if (n == 0) throw new RuntimeException("size must >=1 ...");
        DoubleNode head = new DoubleNode(0);
        DoubleNode pre = head;
        DoubleNode next;
        for (int i = 1; i < n; i++) {
            DoubleNode node = new DoubleNode(i);
            pre.next = node;
            node.pre = pre;
            pre = node;
        }
        return head;
    }
}
