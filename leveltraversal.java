//this was an incorrect attempt to solve leetcode 366

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
    public List<List<Integer>> findLeaves(TreeNode root) {
        //return findLeavesNaive(root);
        return findLeavesQueue(root);
    }
    
    class NodeWithHeight {
        TreeNode node;
        int height;
        NodeWithHeight(TreeNode node, int height) {
            this.node = node;
            this.height = height;
        }
    }
    List<List<Integer>> findLeavesQueue(TreeNode root) {
        Queue<NodeWithHeight> shit = new LinkedList();
        List<List<Integer>> result = new ArrayList();
        int height = 0;
        shit.add(new NodeWithHeight(root, 0));
        while(!shit.isEmpty()) {
            NodeWithHeight curr = shit.poll();
            if(curr.height >= result.size()) {
                result.add(curr.height, new ArrayList());
            }
            result.get(curr.height).add(curr.node.val);
            
            if(curr.node.left != null) {
                shit.add(new NodeWithHeight(curr.node.left, curr.height+1));
            }
            
            if(curr.node.right != null) {
                shit.add(new NodeWithHeight(curr.node.right, curr.height+1));
            }
            
        }
        //Collections.reverse(result);
        return result;
        
    }
    
   
}
