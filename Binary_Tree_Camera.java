package HARD_75_DAYS;
/*  https://leetcode.com/problems/binary-tree-cameras/
 *  Binary Tree Cameras
 *  You are given the root of a binary tree. We install cameras on the tree nodes where each camera at a node can monitor its parent,
 *  itself, and its immediate children.
 *  Return the minimum number of cameras needed to monitor all nodes of the tree.
 *  Example 1:
 *  Input: root = [0,0,null,0,0]
Output: 1
Explanation: One camera is enough to monitor all nodes if placed as shown.
Example 2:
 *
 */

public class Binary_Tree_Camera {
    public static class Tree {
        int val;
        Tree left;
        Tree right;

        Tree(int val) {
            this.val = val;
        }

        public static void main(String[] args) {
            Tree root = new Tree(1);
            Tree left = new Tree(2);
            Tree right = new Tree(3);
            root.left = left;
            root.right = right;
            System.out.println("The Minimum Camera Requird" + minCameraCover(root));
        }
        public static int minCameraCover(Tree root) {
            int[] sum = {0};
            if (dfs(root , sum) == 0){
                sum[0]++;
            }
            return sum[0];
        }

        private static int dfs(Tree tr , int []sum){
            if (tr == null)return 1;
            int l = dfs(tr.left , sum);
            int r = dfs(tr.right , sum);
            if (l == 0 || r == 0){
                sum[0]++;
                return 2;
            } else if (l == 2 || r == 2) {
                return 1;
            }else {
                return 0;
            }
        }
    }
}
