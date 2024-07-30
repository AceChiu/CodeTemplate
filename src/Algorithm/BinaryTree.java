package Algorithm;

import java.util.ArrayList;
import java.util.Stack;

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
    // L -> N -> R
    public ArrayList<Integer> inorderIterative() {
        ArrayList<Integer> result = new ArrayList<>();
        Stack<TreeNode> s = new Stack<>();
        TreeNode curr = root;

        // traverse the tree
        while (curr != null || s.size() > 0) {
            while (curr != null) {
                s.push(curr);
                curr = curr.left;
            }
            curr = s.pop();
            result.add(curr.value);
            curr = curr.right;
        }
        return result;
    }

    public ArrayList<Integer> inOrderRecursive(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<>();
        if (root != null) {
            inOrderRecursive(root.left);
            result.add(root.value);
            inOrderRecursive(root.right);
        }
        return result;
    }

    // N -> L -> R
    public ArrayList<Integer> preorderIterative() {
        ArrayList<Integer> result = new ArrayList<>();
        Stack<TreeNode> s = new Stack<>();
        TreeNode curr = root;
        while (curr != null || s.size() > 0) {
            while (curr != null) {
                s.push(curr);
                result.add(s.peek().value);
                curr = curr.left;
            }
            curr = s.pop();
            curr = curr.right;
        }
        return result;
    }

    public ArrayList<Integer> preOrderRecursive(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<>();
        if (root != null) {
            result.add(root.value);
            preOrderRecursive(root.left);
            preOrderRecursive(root.right);
        }
        return result;
    }

    // L -> R -> N
    public ArrayList<Integer> postorder() {
        ArrayList<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        TreeNode prev = null;
        while (!stack.isEmpty()) {
            TreeNode current = stack.peek();
            if (prev == null || prev.left == current || prev.right == current) {
                if (current.left != null)
                    stack.push(current.left);
                else if (current.right != null)
                    stack.push(current.right);
                else {
                    stack.pop();
                    result.add(current.value);
                }
            }
            else if (current.left == prev) {
                if (current.right != null)
                    stack.push(current.right);
                else {
                    stack.pop();
                    result.add(current.value);
                }
            }
            else if (current.right == prev) {
                stack.pop();
                result.add(current.value);
            }

            prev = current;
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
