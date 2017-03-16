public class TreeNode<T> {

    private final T value;
    private TreeNode<T> left;
    private TreeNode<T> right;

    public TreeNode(final T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    public TreeNode<T> getLeft() {
        return left;
    }

    public void setLeft(final TreeNode<T> left) {
        this.left = left;
    }

    public TreeNode<T> getRight() {
        return right;
    }

    public void setRight(final TreeNode<T> right) {
        this.right = right;
    }

}
