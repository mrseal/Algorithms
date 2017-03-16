import java.util.ArrayList;
import java.util.List;

public abstract class TraversalByRecursive {

    public static <T> List<T> preorderTraversal(final TreeNode<T> root) {
        final List<T> result = new ArrayList<>();
        if (root != null) {
            result.add(root.getValue());
            result.addAll(preorderTraversal(root.getLeft()));
            result.addAll(preorderTraversal(root.getRight()));
        }
        return result;
    }

    public static <T> List<T> inorderTraversal(final TreeNode<T> root) {
        final List<T> result = new ArrayList<>();
        if (root != null) {
            result.addAll(inorderTraversal(root.getLeft()));
            result.add(root.getValue());
            result.addAll(inorderTraversal(root.getRight()));
        }
        return result;
    }

    public static <T> List<T> postorderTraversal(final TreeNode<T> root) {
        final List<T> result = new ArrayList<>();
        if (root != null) {
            result.addAll(postorderTraversal(root.getLeft()));
            result.addAll(postorderTraversal(root.getRight()));
            result.add(root.getValue());
        }
        return result;
    }

}
