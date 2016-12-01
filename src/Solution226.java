/**
 * Created by HaoPeiqiang on 2016/12/1.
 */
public class Solution226 {

    private class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public TreeNode invertTree(TreeNode root) {

        if (root == null)
            return null;

        if (root.left != null && root.right != null) {

            TreeNode temp = root.left;
            root.left = root.right;
            root.right = temp;

            invertTree(root.left);
            invertTree(root.right);
        }else {

            if (root.left != null) {

                root.right = root.left;
                root.left = null;
                invertTree(root.right);

            } else if (root.right !=null) {

                root.left = root.right;
                root.right = null;
                invertTree(root.left);

            }
        }
        return root;
    }

    public TreeNode createData() {

        TreeNode root = new TreeNode(4);

        root.left = new TreeNode(2);
        root.right = new TreeNode(7);

        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);

        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(9);

        return root;
    }

    public static void main(String[] argv) {

        Solution226 solution226 = new Solution226();
        TreeNode root = solution226.createData();
        TreeNode node = solution226.invertTree(root);
        System.out.println(node);
    }
}