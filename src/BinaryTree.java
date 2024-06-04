import java.util.ArrayList;

public class BinaryTree {
    private TreeNode root;

    public BinaryTree(int value) {
        root = new TreeNode(value);
    }

    public void insert(int value) {
        root = insertRec(root, value);
    }

    private TreeNode insertRec(TreeNode root, int value) {
        if (value < root.value) {
            root.left = insertRec(root.left, value);
        } else if (value > root.value) {
            root.right = insertRec(root.right, value);
        }
        return root;
    }

    public ArrayList<Integer> preOrder(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<>();
        if (root != null) {
            result.add(root.value);
            preOrder(root.left);
            preOrder(root.right);
        }
        return result;
    }

    public ArrayList<Integer> inOrder(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<>();
        if (root != null) {
            inOrder(root.left);
            result.add(root.value);
            inOrder(root.right);
        }
        return result;
    }

    public ArrayList<Integer> postOrder(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<>();
        if (root != null) {
            postOrder(root.left);
            postOrder(root.right);
            result.add(root.value);
        }
        return result;
    }
}
