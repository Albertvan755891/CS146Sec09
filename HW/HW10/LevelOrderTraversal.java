import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.LinkedList;

public class LevelOrderTraversal{
    public static class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}

    TreeNode(int val) { this.val = val; }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
 }

 public List<List<Integer>> levelOrder(TreeNode root) {
    // Your code here
    if (root == null)
        return new ArrayList<>();
    
    List<List<Integer>> list = new ArrayList<>();
    Queue<TreeNode> queue = new LinkedList<>();
    queue.add(root);
    while(!queue.isEmpty()){
        int size = queue.size();
        List<Integer> subList = new ArrayList<>();
        for(int i=0; i< size; i++){
            TreeNode current = queue.poll();
            subList.add(current.val);
            if (current.left != null){
                queue.add(current.left);
            }
            if (current.right != null){
                queue.add(current.right);
            }
        }
            list.add(subList);
        }
    return list;
 }  
public static void main(String[] args) {
    TreeNode root1 = new TreeNode(4);
    root1.left = new TreeNode(3);
    root1.right = new TreeNode(8);
    root1.left.left = new TreeNode(1);
    root1.right.left = new TreeNode (5);
    root1.right.right = new TreeNode(9);

    TreeNode root2 = null;

    LevelOrderTraversal result = new LevelOrderTraversal();
    List<List<Integer>> result1 = result.levelOrder(root1);

    List<List<Integer>> result2 = result.levelOrder(root2);

    System.out.println("Output for Test Case 1: ");
    if(result1.isEmpty()){
        System.out.println("None");
    }
    else{
    System.out.println(result1);
    }

    System.out.println("Output for Test Case 2");
    if(result2.isEmpty()){
        System.out.println("None");
    }
    else{
    System.out.println(result2);
    }
 }
}
