import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class dsa_assignment21 {


////////////////////////////////////////////////////////////////////////////////////////////////////////////
  /* 
Write a program to connect nodes at the same level.

    */
  public static void connect_AtSameLevel(TreeNode root) {
        if (root == null) {
            return;
        }

        root.next = null;

        while (root != null) {
            TreeNode current = root;
            while (current != null) {
                if (current.left != null) {
                    if (current.right != null) {
                        current.left.next = current.right;
                    } else {
                        current.left.next = getNext(current);
                    }
                }

                if (current.right != null) {
                    current.right.next = getNext(current);
                }

                current = current.next;
            }

            if (root.left != null) {
                root = root.left;
            } else if (root.right != null) {
                root = root.right;
            } else {
                root = getNext(root);
            }
        }
    }

public static TreeNode getNext(TreeNode node) {
        TreeNode current = node.next;
        while (current != null) {
            if (current.left != null) {
                return current.left;
            }
            if (current.right != null) {
                return current.right;
            }
            current = current.next;
        }
        return null;
    }

//////////////////////////////////////////////////////////////////////////////////////////////////////////////
/* question 2
 * Given a Binary Search Tree with all unique values and two keys. Find the distance between two nodes in BST. 
 * The given keys always exist in BST.
 */
   public static int Distance(TreeNode root, int key1, int key2) {
        TreeNode commonAncestor = Common_Ancestor(root, key1, key2);
        int dist1 = DistanceFromNode(commonAncestor, key1);
        int dist2 = DistanceFromNode(commonAncestor, key2);
        return dist1 + dist2;
    }

    public static TreeNode Common_Ancestor(TreeNode node, int key1, int key2) {
        if (node == null || node.val == key1 || node.val == key2) {
            return node;
        }

        if (node.val > key1 && node.val > key2) {
            return Common_Ancestor(node.left, key1, key2);
        }

        if (node.val < key1 && node.val < key2) {
            return Common_Ancestor(node.right, key1, key2);
        }

        return node;
    }
     public static int DistanceFromNode(TreeNode node, int key) {
        if (node.val == key) {
            return 0;
        }

        if (node.val > key) {
            return 1 + DistanceFromNode(node.left, key);
        }

        return 1 + DistanceFromNode(node.right, key);
    }
//////////////////////////////////////////////////////////////////////////////////////////////////////////
/* question 1
You are given a binary tree. The binary tree is represented using the TreeNode class. Each TreeNode has an
 integer value and left and right children, represented using the TreeNode class itself. Convert this binary 
 tree into a binary search tree.
 */
public  static void BT_ToBST(TreeNode root) {
        List<Integer> values = new ArrayList<>();
        storeValues(root, values);
        Collections.sort(values);
        BST(root, values);
    }

    public static void storeValues(TreeNode node, List<Integer> values) {
        if (node == null) {
            return;
        }
        values.add(node.val);
        storeValues(node.left, values);
        storeValues(node.right, values);
    }

    public static TreeNode BST(TreeNode node, List<Integer> values) {
        if (node == null) {
            return null;
        }
        node.left =BST(node.left, values);
        node.val = values.remove(0);
        node.right = BST(node.right, values);
        return node;
    }
///////////////////////////////////////////////////////////////////////////////////////////////////
    public static void inorderTraversal_display(TreeNode node) {
        if (node == null) {
            return;
        }
        inorderTraversal_display(node.left);
        System.out.print(node.val + " ");
        inorderTraversal_display(node.right);

        
    }

 /////////////////////////////////////////////////////////////////////////////////////////   
    public static class TreeNode {
    int val;  
    TreeNode left;
    TreeNode right;
         TreeNode next;
    TreeNode(int val) {  
        this.val = val;
        this.left=null;
        this.right=null;
        this.next=null;

           }
      }
/////////////////////////////////////////////////////////////////////////////////
    public static class ListNode{
       int val;
       ListNode next; ListNode prev;

         ListNode(int val){

            this.val=val;
            this.next=null;
            this.prev=null;
         } 
    
    }

     ////////////////////////////////////////////////////////////////////////////////////
public static void printDLL(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.println(current.val);
            current = current.next;
        }
        System.out.println();
    }
/////////////////////////////////////////////////////////////////////////////////////////////////////////////

      public static void main(String[] args) {
        
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(8);
        root.left.right = new TreeNode(4);
          
          inorderTraversal_display(root);
          System.out.println();
          BT_ToBST(root);
          inorderTraversal_display(root); 
          System.out.println();
         //////////////////////////////////////////////////////////////////////////
         
            System.out.println("distance between 2 node is "+ Distance(root, 2, 4));

          //////////////////////////////////////////////////////////////////////////////////////


            


      }
}
