package second;

public class LinkedListNode {
    public int data;
    public LinkedListNode next;
    private static int MAX_PRINT_LENGTH = 500;

    public LinkedListNode(int x) {
        data = x;
        next = null;
    }

    public static LinkedListNode buildList(int[] a) {
        if (a == null || a.length == 0) return null;
        LinkedListNode n = new LinkedListNode(a[0]);
        LinkedListNode head = n;
        for (int i = 1; i < a.length; ++i) {
            n.next = new LinkedListNode(a[i]);
            n = n.next;
        }
        return head;
    }

    public static void printList(LinkedListNode n) {
        int i = 0;
        while (n != null) {
            System.out.println(n.data + "->");
            n = n.next;
            if (++i > MAX_PRINT_LENGTH) {
                System.out.println("[MAX_LEN]");
                return;
            }
        }
        System.out.println("NULL");
    }

    public static int length(LinkedListNode n) {
        int i = 0;
        while (n != null) {
            ++i;
            n = n.next;
        }
        return i;
    }

    public static LinkedListNode padList(LinkedListNode n, int number) {
        for (int i = 0; i < number; ++i) {
            LinkedListNode zeroNode = new LinkedListNode(0);
            zeroNode.next = n;
            n = zeroNode;
        }
        return n;
    }

    public static LinkedListNode insertBefore(LinkedListNode list, int data) {
        LinkedListNode node = new LinkedListNode(data);
        if (list != null) {
            node.next = list;
        }
        return node;
    }

    public static LinkedListNode getLast(LinkedListNode list) {
        while (list.next != null) {
            list = list.next;
        }
        return list;
    }

    public String toString() {
        return String.valueOf(data);
    }
}
