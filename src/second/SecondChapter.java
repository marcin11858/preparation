package second;

import java.util.HashSet;
import java.util.List;
import java.util.Stack;

public class SecondChapter {

    public static void main(String[] args) {
//        question_2_1();
//        question_2_1_1();
//        question_2_2();
//        question_2_3();
//        question_2_4();
//        question_2_5();
//        question_2_5_1();
//        question_2_6();
//        question_2_6_1();
//        question_2_6_2();
//        question_2_7();
        question_2_8();

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

    private static void question_2_5_1() {
        LinkedListNode first = LinkedListNode.buildList(new int[]{1, 2, 3, 4});
        LinkedListNode second = LinkedListNode.buildList(new int[]{5, 6, 7});

        int len1 = LinkedListNode.length(first);
        int len2 = LinkedListNode.length(second);

        if (len1 < len2) {
            first = LinkedListNode.padList(first, len2 - len1);
        } else {
            second = LinkedListNode.padList(second, len1 - len2);
        }

        PartialSum sum = addListsHelper(first, second);
        if (sum.carry == 0) {
            LinkedListNode.printList(sum.sum);
        } else {
            LinkedListNode result = LinkedListNode.insertBefore(sum.sum, sum.carry);
            LinkedListNode.printList(result);
        }
    }

    private static PartialSum addListsHelper(LinkedListNode l1, LinkedListNode l2) {
        if (l1 == null && l2 == null) {
            PartialSum sum = new PartialSum();
            return sum;
        }

        PartialSum sum = addListsHelper(l1.next, l2.next);
        int val = sum.carry + l1.data + l2.data;

        LinkedListNode fullResult = LinkedListNode.insertBefore(sum.sum, val % 10);

        sum.sum = fullResult;
        sum.carry = val/10;
        return sum;
    }


    static class PartialSum {
        public LinkedListNode sum = null;
        public int carry = 0;
    }


    private static void question_2_6() {
        LinkedListNode list = LinkedListNode.buildList(new int[]{1, 2, 3, 4, 4, 2, 1});
        LinkedListNode clone = reverseAndClone(list);
        System.out.println(equals(list, clone));
    }

    private static LinkedListNode reverseAndClone(LinkedListNode node) {
        LinkedListNode head = null;
        while (node != null) {
            LinkedListNode n = new LinkedListNode(node.data);
            n.next = head;
            head = n;
            node = node.next;
        }
        return head;
    }

    private static boolean equals(LinkedListNode first, LinkedListNode second) {
        while (first != null && second != null) {
            if (first.data != second.data) {
                return false;
            }
            first = first.next;
            second = second.next;
        }

        return first == null && second == null;
    }

    private static void question_2_6_1() {

        LinkedListNode list = LinkedListNode.buildList(new int[]{1, 2, 3, 4, 4, 2, 1});

        LinkedListNode fast = list;
        LinkedListNode slow = list;

        Stack<Integer> stack = new Stack<>();

        while (fast != null && fast.next != null) {
            stack.push(slow.data);
            slow = slow.next;
            fast = fast.next.next;
        }

        if (fast != null) {
            slow = slow.next;
        }

        while (slow != null) {
            int top = stack.pop();

            if (top != slow.data) {
                System.out.println("false");
                return;
            }
            slow = slow.next;
        }
        System.out.println("true");
    }

    private static void question_2_6_2() {
        LinkedListNode list = LinkedListNode.buildList(new int[]{1, 2, 3, 4, 4, 3, 2, 1});
        int length = LinkedListNode.length(list);
        Result res = isPalindromeRecurse(list, length);
        System.out.println(res.result);
    }

    private static Result isPalindromeRecurse(LinkedListNode head, int length) {
        if (head == null || length <= 0 ) {
            return new Result(head, true);
        } else if (length == 1) {
            return new Result(head.next, true);
        }

        Result res = isPalindromeRecurse(head.next, length - 2);
        if (!res.result || res.node == null) {
            return res;
        }

        res.result = (head.data == res.node.data);

        res.node = res.node.next;

        return res;
    }

    private static class Result {
        public Result(LinkedListNode node, boolean result) {
            this.node = node;
            this.result = result;
        }

        public LinkedListNode node;
        public boolean result;
    }

    private static class ResultIntersect {
        public LinkedListNode tail;
        public int size;

        public ResultIntersect(LinkedListNode tail, int size) {
            this.tail = tail;
            this.size = size;
        }
    }

    private static void question_2_7() {
        LinkedListNode intersect = LinkedListNode.buildList(new int[]{ 3, 2, 1});
        LinkedListNode list1 = LinkedListNode.buildList(new int[]{1, 2, 3, 4, 4, 3, 2, 1});
        LinkedListNode.getLast(list1).next = intersect;
        LinkedListNode list2 = LinkedListNode.buildList(new int[]{1, 2, 3, 4, 4, 3, 2, 1});
        LinkedListNode.getLast(list2).next = intersect;

        if (list1 == null || list2 == null) {
            System.out.println("false");
            return;
        }

        ResultIntersect result1 = getTailAndSize(list1);
        ResultIntersect result2 = getTailAndSize(list2);

        if (result1.tail != result2.tail) {
            System.out.println("false");
            return;
        }

        LinkedListNode shorter = result1.size < result2.size ? list1 : list2;
        LinkedListNode longer = result1.size < result2.size ? list2 : list1;

        longer = getKthNode(longer, Math.abs(result1.size - result2.size));

        while (shorter != longer) {
            shorter = shorter.next;
            longer = longer.next;
        }

        LinkedListNode.printList(longer);
    }

    private static LinkedListNode getKthNode(LinkedListNode head, int k) {
        LinkedListNode current = head;
        while (k > 0 && current != null) {
            current = current.next;
            --k;
        }
        return current;
    }

    private static ResultIntersect getTailAndSize(LinkedListNode list) {
        if (list == null) return null;

        int size = 1;
        LinkedListNode current = list;
        while (current.next != null) {
            size++;
            current = current.next;
        }
        return new ResultIntersect(current, size);
    }

    private static void question_2_8() {
        LinkedListNode start = new LinkedListNode(16);
        LinkedListNode list = LinkedListNode.buildList(new int[]{1, 4, 5, 6, 7, 8, 9 ,2, 3});
        LinkedListNode.getLast(list).next = start;
        LinkedListNode loop = LinkedListNode.buildList(new int[]{4, 5, 6});
        start.next = loop;
        LinkedListNode.getLast(loop).next = start;

        LinkedListNode slow = list;
        LinkedListNode fast = list;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                break;
            }
        }

        if (fast == null || slow == null) {
            System.out.println("No loop");
            return;
        }

        slow = list;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }

        System.out.println(slow.data);
    }
}
