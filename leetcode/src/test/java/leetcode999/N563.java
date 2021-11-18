package leetcode999;

import org.junit.jupiter.api.Test;

/**
 * @date 2021/11/18
 */
public class N563 {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }


    int res = 0;

    public int findTilt(TreeNode root) {
        dfs(root);
        return res;
    }

    private int dfs(TreeNode treeNode) {
        if (treeNode == null) {
            return 0;
        }

        int sumLeft = dfs(treeNode.left);
        int sumRight = dfs(treeNode.right);

        res += Math.abs(sumLeft - sumRight);

        return treeNode.val + sumLeft + sumRight;
    }

    @Test
    void t() {
        TreeNode root = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(3);

        root.left = node1;
        root.right = node2;

        System.out.println(findTilt(root));
    }

}
