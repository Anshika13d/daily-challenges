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
    public TreeNode replaceValueInTree(TreeNode root) {
        if(root == null) return null;

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        List<Integer> list = new ArrayList<>();

        while(!q.isEmpty()){
            int size = q.size();
            int sum = 0;
            for(int i=0;i<size;i++){
                TreeNode n = q.poll();
                sum += n.val;

                if(n.left != null){
                    q.offer(n.left);
                }
                if(n.right != null){
                    q.offer(n.right);
                }
            }

            list.add(sum);
        }

        root.val = 0;
        q.offer(root);
        int j = 1;
        while(!q.isEmpty()){
            int size = q.size();

            for(int i=0;i<size;i++){
                int sum = 0;
                TreeNode n = q.poll();

                if(n.left != null){
                    sum += n.left.val;
                    q.offer(n.left);
                }
                if(n.right != null){
                    sum += n.right.val;
                    q.offer(n.right);
                }

                if(n.left != null) n.left.val = list.get(j) - sum;
                if(n.right != null) n.right.val = list.get(j) - sum;
            }

            j++;
        }

        return root;
    }
}
