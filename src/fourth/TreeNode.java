package fourth;

public class TreeNode {
    private final int value;

    private TreeNode left;

    private TreeNode right;

    public TreeNode(int value) {
        this.value = value;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }
}
