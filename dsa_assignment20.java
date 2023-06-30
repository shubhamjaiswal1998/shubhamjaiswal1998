import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;



public class dsa_assignment20 {

    public static class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
           }
      }



//////////////////////////////////////////////////////////////////////////////////////////////
/*
 * Given an array of size n. The problem is to check whether the given array can represent the level order 
 * traversal of a Binary Search Tree or not.
 */
      public static boolean isLevel_OrderBSt(int[] arr) {
        int n = arr.length;
        if (n == 0 || n == 1) {
            return true;
        }

        Stack<Integer> stack = new Stack<>();
        int root = arr[0];
        stack.push(root);
        int i = 1;

        while (!stack.isEmpty() && i < n) {
            int curr = stack.pop();

            if (i < n && arr[i] < curr) {
                return false;
            }

            i++;

            if (i < n && arr[i] > curr) {
                stack.push(arr[i]);
                break;
            }
        }

        while (i < n) {
            if (arr[i] <= stack.peek()) {
                return false;
            }
            i++;
        }

        return true;
    }
/////////////////////////////////////////////////////////////////////////////////////
/* question 2
 * Construct the BST (Binary Search Tree) from its given level order traversal
 */
public static TreeNode build_BST(int[] levelOrder) {
        if (levelOrder == null || levelOrder.length == 0) {
            return null;
        }

        TreeNode root = new TreeNode(levelOrder[0]);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int i = 1;

        while (i < levelOrder.length) {
            TreeNode currNode = queue.poll();

            if (i < levelOrder.length && levelOrder[i] > currNode.val) {
                currNode.right = new TreeNode(levelOrder[i]);
                queue.add(currNode.right);
                i++;
            }

            if (i < levelOrder.length && levelOrder[i] < currNode.val) {
                currNode.left = new TreeNode(levelOrder[i]);
                queue.add(currNode.left);
                i++;
            }
        }

        return root;
    }

/////////////////////////////////////////////////////////////////////////////////////
/* Given a binary tree, your task is to find subtree with maximum sum in tree.
 * 
 */
      public static int maxSum;

    public static int mSum_Subtree(TreeNode root) {
        maxSum = Integer.MIN_VALUE;
        maxSumSubtreeHelper(root);
        return maxSum;
    }

    private static int maxSumSubtreeHelper(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftSum = maxSumSubtreeHelper(root.left);
        int rightSum = maxSumSubtreeHelper(root.right);
        int subtreeSum = root.val + leftSum + rightSum;

        maxSum = Math.max(maxSum, subtreeSum);

        return subtreeSum;
    }
    //////////////////////////////////////////////////////////////////////////////////////
     public static void display_inorder(TreeNode root) {
        if (root != null) {
            display_inorder(root.left);
            System.out.print(root.val + " ");
            display_inorder(root.right);
        }
        
    }
    public static void main(String[] args) {
        
       TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

          
      System.out.println("Maximum Sum of a Subtre"+ mSum_Subtree(root));
       
      int[] arr = {7, 4, 12, 3, 6, 8, 1, 5, 10};

       
             TreeNode buildtree=build_BST(arr);
             display_inorder(buildtree);

          int[] arr1 = {7, 4, 12, 3, 6, 8, 1, 5, 10};

        boolean isBST =isLevel_OrderBSt(arr1);

        System.out.println(isBST);
              
               





    }
}
