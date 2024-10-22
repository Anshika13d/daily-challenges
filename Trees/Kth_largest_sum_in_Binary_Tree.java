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
    public long kthLargestLevelSum(TreeNode root, int k) {
        if(root == null) return -1;

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        PriorityQueue<Long> pq = new PriorityQueue<>((a, b) -> Long.compare(b, a));
        //pq.offer((long) root.val);

        while(!q.isEmpty()){
            long kthLargestSum = 0;
            int size = q.size();
            
            for(int i=0;i<size;i++){
                TreeNode node = q.poll();
                kthLargestSum += node.val;
                if(node.left != null){
                    q.offer(node.left);
                }
                if(node.right != null){
                    q.offer(node.right);
                }
            }

            pq.offer(kthLargestSum);
        }

        while(k > 1 && !pq.isEmpty()){
            pq.poll();
            k--;
        }

        return pq.isEmpty()? -1 : pq.peek();
    }
}