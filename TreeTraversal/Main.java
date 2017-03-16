public class Main {

    public static void main(final String[] args) {
        final TreeNode<String> root = prepareTree();
        System.out.println("=== Via Recursive ===");
        System.out.println("Preorder Traversal: " + TraversalByRecursive.preorderTraversal(root));
        System.out.println("Inorder Traversal: " + TraversalByRecursive.inorderTraversal(root));
        System.out.println("Postorder Traversal: " + TraversalByRecursive.postorderTraversal(root));

        System.out.println("\n=== Via Stack ===");
        System.out.println("Preorder Traversal: " + TraversalByStack.preorderTraversal(root));
        System.out.println("Inorder Traversal: " + TraversalByStack.inorderTraversal(root));
        System.out.println("Postorder Traversal: " + TraversalByStack.postorderTraversal(root));
    }

    public static TreeNode<String> prepareTree() {
        final TreeNode<String> root = new TreeNode<>("a");
        final TreeNode<String> b = new TreeNode<>("b");
        final TreeNode<String> c = new TreeNode<>("c");
        final TreeNode<String> d = new TreeNode<>("d");
        final TreeNode<String> e = new TreeNode<>("e");
        final TreeNode<String> f = new TreeNode<>("f");
        final TreeNode<String> g = new TreeNode<>("g");
        root.setLeft(b);
        root.setRight(c);
        b.setLeft(d);
        b.setRight(f);
        d.setRight(e);
        f.setLeft(g);
        return root;
    }

}
