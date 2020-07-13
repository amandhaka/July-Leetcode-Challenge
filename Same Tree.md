Given two binary trees, write a function to check if they are the same or not.

Two binary trees are considered the same if they are structurally identical and the nodes have the same value.

Example 1:
```
Input:     1         1
          / \       / \
         2   3     2   3

        [1,2,3],   [1,2,3]

Output: true
```
Example 2:
```
Input:     1         1
          /           \
         2             2

        [1,2],     [1,null,2]

Output: false
```
Example 3:
```
Input:     1         1
          / \       / \
         2   1     1   2

        [1,2,1],   [1,1,2]
Output: false
```
```java
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p==null && q==null) return true;
        if(p==null || q==null) return false;
        Queue<TreeNode> queue=new LinkedList<>();
        queue.offer(p);
        queue.offer(q);
        while(!queue.isEmpty()){
            TreeNode node1=queue.poll();
            TreeNode node2=queue.poll();
            if(node1.val!=node2.val) return false;
            if(node1.left==null && node2.left!=null) return false;
            if(node1.left!=null && node2.left==null) return false;
            if(node1.right!=null && node2.right==null) return false;
            if(node1.right==null && node2.right!=null) return false;
            if(node1.left!=null) queue.offer(node1.left);
            if(node2.left!=null) queue.offer(node2.left);
            if(node1.right!=null) queue.offer(node1.right);
            if(node2.right!=null) queue.offer(node2.right);
        }
        return true;
    }
}
```
