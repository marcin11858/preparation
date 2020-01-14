package second;

import java.util.HashSet;

public class SecondChapter {

    public static void main(String[] args) {
//        question_2_1();
//        question_2_1_1();
//        question_2_2();
//        question_2_3();
//        question_2_4();
        question_2_5();
    }


    private static void question_2_1() {
        LinkedListNode n = LinkedListNode.buildList(new int[]{1, 1, 1});
        LinkedListNode first = n;

        HashSet<Integer> duplicates = new HashSet<>();
        LinkedListNode prev = null;
        while (n != null) {
            if (duplicates.contains(n.data)) {
                prev.next = n.next;
            } else {
                prev = n;
                duplicates.add(n.data);
            }
            n = n.next;
        }
        LinkedListNode.printList(first);
    }

    private static void question_2_1_1() {
        LinkedListNode n = LinkedListNode.buildList(new int[]{1, 2, 3, 4, 3, 1, 1});

        LinkedListNode current = n;
        while(current != null) {
            LinkedListNode runner = current;
            while (runner.next != null) {
                if (runner.next.data == current.data) {
                    runner.next = runner.next.next;
                } else {
                    runner = runner.next;
                }
            }
            current = current.next;
        }
        LinkedListNode.printList(n);
    }

    private static void question_2_2() {
        LinkedListNode n = LinkedListNode.buildList(new int[]{1, 2, 3, 4, 3, 2, 1});
        printKthToLastRecursive(n, 3);
        printKthToLastIterative(n , 3);
    }

    private static void printKthToLastIterative(LinkedListNode n, int i) {
        int length = 0;
        LinkedListNode kth = null;
        LinkedListNode head = n;
        while (n != null) {
            ++length;
            if (length == i) {
                kth = head;
            } else if (length > i) {
                kth = kth.next;
            }
            n = n.next;
        }
        if (kth != null) {
            System.out.println(kth);
        } else {
            System.out.println("SIZE IS TOO SMALL");
        }
    }

    private static int printKthToLastRecursive(LinkedListNode head, int k) {
        if (head == null) {
            return 0;
        }

        int index = printKthToLastRecursive(head.next, k) + 1;
        if (index == k) {
            System.out.println(head.data);
        }
        return index;
    }

    private static void question_2_3() {
        LinkedListNode n = LinkedListNode.buildList(new int[]{1, 2, 3, 4, 3, 2, 1});
        deleteN(n.next.next.next);
        LinkedListNode.printList(n);
    }

    private static boolean deleteN(LinkedListNode n) {
        if (n == null || n.next == null) {
            return false;
        }

        n.data = n.next.data;
        n.next = n.next.next;
        return true;
    }

    private static void question_2_4() {
            LinkedListNode node = LinkedListNode.buildList(new int[]{3, 5, 8, 5, 10, 2, 1});
            int x = 5;

            LinkedListNode head = node;
            LinkedListNode tail = node;

            while (node != null) {
                LinkedListNode next = node.next;
                if (node.data < x) {
                    node.next = head;
                    head = node;
                } else {
                    tail.next = node;
                    tail = node;
                }
                node = next;
            }
            tail.next = null;

            LinkedListNode.printList(head);
    }

    private static void question_2_5() {
        LinkedListNode first = LinkedListNode.buildList(new int[]{7, 1, 6});
        LinkedListNode second = LinkedListNode.buildList(new int[]{5, 9, 6});
        LinkedListNode result = null;
        LinkedListNode head = null;

        int nextValue = 0;
        while (first != null || second != null || nextValue > 0) {
            int sum = (first != null ? first.data : 0)  + (second != null ? second.data : 0) + nextValue;
            if (result == null) {
                result = new LinkedListNode(sum % 10);
                head = result;
            } else {
                result.next = new LinkedListNode(sum % 10);
                result = result.next;
            }
            nextValue = (int) sum / 10;
            first = (first != null ? first.next : null);
            second = (second != null ? second.next : null);
        }

        LinkedListNode.printList(head);
    }


}
