import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public abstract class Traversal {

    public static <T> List<T> preorderTraversal(final TreeNode<T> root) {
        final List<T> result = new ArrayList<>();
        final Stack<TreeNode<T>> stack = new Stack<>();

        TreeNode<T> c = root;
        while (c != null || !stack.isEmpty()) {
            if (c != null) {
                result.add(c.getValue());
                stack.push(c);
                c = c.getLeft();
            } else {
                c = stack.pop().getRight();
            }
        }
        return result;
    }

    public static <T> List<T> inorderTraversal(final TreeNode<T> root) {
        final List<T> result = new ArrayList<>();
        final Stack<TreeNode<T>> stack = new Stack<>();

        TreeNode<T> c = root;
        while (c != null || !stack.isEmpty()) {
            if (c != null) {
                stack.push(c);
                c = c.getLeft();
            } else {
                c = stack.pop();
                result.add(c.getValue());
                c = c.getRight();
            }
        }
        return result;
    }

    public static <T> List<T> postorderTraversal(final TreeNode<T> root) {
        final List<T> result = new ArrayList<>();
        final Stack<TreeNode<T>> stack = new Stack<>();

        TreeNode<T> c = root;
        TreeNode<T> lastVisit = c;
        while (c != null || !stack.isEmpty()) {
            if (c != null) {
                stack.push(c);
                c = c.getLeft();
            } else {
                TreeNode<T> peek = stack.peek();
                if (peek.getRight() == null || peek.getRight() == lastVisit) {
                    peek = stack.pop();
                    result.add(peek.getValue());
                    lastVisit = peek;
                } else {
                    c = peek.getRight();
                }
            }
        }
        return result;
    }

    public static <T> List<T> levelTraversal(final TreeNode<T> root) {
        final List<T> result = new ArrayList<>();
        final LinkedList<TreeNode<T>> queue = new LinkedList<>();
        queue.addLast(root);
        TreeNode<T> c;
        while (!queue.isEmpty()) {
            c = queue.pollFirst();
            result.add(c.getValue());
            if (c.getLeft() != null) {
                queue.addLast(c.getLeft());
            }
            if (c.getRight() != null) {
                queue.addLast(c.getRight());
            }
        }
        return result;
    }
}
