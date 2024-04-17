import java.util.ArrayList;
import java.util.List;

public class BinaryTree<T extends Comparable<T>> {
    private TreeNode<T> root;

    public BinaryTree() {
        root = null;
    }

    public void add(T data) {
        root = addNode(root, data);
    }

    private TreeNode<T> addNode(TreeNode<T> root, T data) {
        if (root == null) {
            return new TreeNode<>(data);
        }
        if (data.compareTo(root.data) < 0) {
            root.left = addNode(root.left, data);
        }
        if (data.compareTo(root.data) > 0) {
            root.right = addNode(root.right, data);
        }
        return root;
    }

    public boolean contains(T data) {
        return containsNode(root, data);
    }

    private boolean containsNode(TreeNode<T> root, T data) {
        if (root == null) {
            return false;
        }
        if (data.equals(root.data)) {
            return true;
        }
        if (data.compareTo(root.data) < 0) {
            return containsNode(root.left, data);
        } else {
            return containsNode(root.right, data);
        }
    }

    public void dfs() {
        dfs(root);
    }

    private void dfs(TreeNode<T> root) {
        if (root != null) {
            System.out.print(root.data + " ");
            dfs(root.left);
            dfs(root.right);
        }
    }

    public void bfs() {
        if (root == null) {
            return;
        }
        List<TreeNode<T>> currentLevel = new ArrayList<>();
        currentLevel.add(root);

        while (!currentLevel.isEmpty()) {
            List<TreeNode<T>> nextLevel = new ArrayList<>();

            for (TreeNode<T> node : currentLevel) {
                System.out.print(node.data + " ");

                if (node.left != null) {
                    nextLevel.add(node.left);
                }
                if (node.right != null) {
                    nextLevel.add(node.right);
                }
            }
            currentLevel = nextLevel;
        }
    }
}