package HARD_75_DAYS;
/*
 * Maximum path sum
 *
 * Given the root of a binary tree, your task is to find the maximum path sum. The path may start and end at any node in the tree.
 *  Examples:
 *  Input: root[] = [10, 2, 10, 20, 1, N, -25, N, N, N, N, 3, 4]
 *          10
 *        /    \
 *       2      10
 *      / \       \
 *    20   1      -25
 *                /  \
 *               3    4
 *
 *  Output: 42
 *  Explanation: Max path sum is represented using green colour nodes in the above binary tree.
 * */
public class BinaryTree_Maximum_Path_Sum {
    public static class Node{
        int val;
        Node left;
        Node right;
        public Node(int val){
            this.val = val;
        }
    }
    public static void main(String[] args) {
        Node root = new Node(1);
        Node l = new Node(5);
        Node r = new Node(6);
        root.left = l;
        root.right = r;
        System.out.println(STR."Total Max Sum :\{findMaxSum(root)}");
    }

    private static int findMaxSum(Node root) {
        int []sum = {Integer.MIN_VALUE};
        maxSumdfs(root , sum);
        return sum[0];
    }

    private static int maxSumdfs(Node root, int[] sum) {
        if (root == null)return 0;
        int l =  maxSumdfs(root.left , sum);
        int  r =  maxSumdfs(root.right ,sum);
        int case1 = l + r + root.val;
        int case2 = Math.max(l , r) + root.val;
        int bestAtNode = Math.max(case1, Math.max(case2, root.val));
        sum[0] = Math.max(sum[0], bestAtNode);
        return Math.max(case2 , root.val);
    }
}
