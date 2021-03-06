package fourth;

import java.util.LinkedList;

public class FourthChapter {

    public static void main(String[] args) {
//        question_4_1();
        TreeNode node = question_4_2(new int[]{ 1,2,3,4,5,6,7,8,9,10 });
        node.toString();
        int c = 1 + 1;
    }

    private static void question_4_1() {
        Graph g = createNewGraph();
        Node[] n = g.getNodes();
        Node start = n[3];
        Node end = n[5];

        if (start == end) {
            System.out.println(true);
            return;
        }

        LinkedList<Node> q = new LinkedList<Node>();

        for (Node u : g.getNodes()) {
            u.state = State.UNVISITED;
        }

        start.state = State.VISTING;
        Node u;
        q.add(start);
        while (!q.isEmpty()) {
            u = q.removeFirst();
            if (u != null) {
                for (Node v : u.getAdjacent()) {
                    if (v.state == State.UNVISITED) {
                        if (v == end) {
                            System.out.println(true);
                            return;
                        } else {
                            v.state = State.VISTING;
                            q.add(v);
                        }
                    }
                }
            }
            u.state = State.VISITED;
        }
        System.out.println(false);
    }

    private static TreeNode question_4_2(int[] values) {
        return createMinBSTRec(values, 0, values.length - 1);
    }

    private static TreeNode createMinBSTRec(int[] values, int startIndex, int endIndex) {
        if (endIndex < startIndex) {
            return null;
        }

        int middleIndex = (startIndex + endIndex) / 2;
        TreeNode node = new TreeNode(values[middleIndex]);
        node.setLeft(createMinBSTRec(values, startIndex, middleIndex - 1));
        node.setRight(createMinBSTRec(values, middleIndex + 1, endIndex));
        return node;
    }

    private static Graph createNewGraph()
    {
        Graph g = new Graph();
        Node[] temp = new Node[6];

        temp[0] = new Node("a", 3);
        temp[1] = new Node("b", 0);
        temp[2] = new Node("c", 0);
        temp[3] = new Node("d", 1);
        temp[4] = new Node("e", 1);
        temp[5] = new Node("f", 0);

        temp[0].addAdjacent(temp[1]);
        temp[0].addAdjacent(temp[2]);
        temp[0].addAdjacent(temp[3]);
        temp[3].addAdjacent(temp[4]);
        temp[4].addAdjacent(temp[5]);
        for (int i = 0; i < 6; i++) {
            g.addNode(temp[i]);
        }
        return g;
    }
}
