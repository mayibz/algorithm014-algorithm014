package Week_03;

/**
 * created by qiminghua on 2020/8/25
 */
public class ValidateBinarySearchTree {
    public Integer pre = null;
    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
    }

    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (!isValidBST(root.left)) {
            return false;
        };
        if (pre!= null && root.val <= pre) {
            return false;
        }
        pre = root.val;
        return isValidBST(root.right);
    }
}
