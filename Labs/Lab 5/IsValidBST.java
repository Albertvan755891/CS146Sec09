class TreeNode {

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
    public class IsValidBST {
        TreeNode previous; // Declare previous here
    
        public boolean isValidBST(TreeNode root) {
            previous = null; // Initialize previous here
            return isValid(root);
        }
    
public boolean isValid(TreeNode node) {
    if (node == null)
        return true;

    // Check left subtree
    if (!isValid(node.left))
        return false;

    // Check current node
    if (previous != null && node.val <= previous.val)
        return false;
    previous = node;

    // Check right subtree
    return isValid(node.right);
}

public static void main(String[] args){
    TreeNode root1 = new TreeNode(4);
    root1.left = new TreeNode(3);
    root1.right = new TreeNode(8);
    root1.left.left = new TreeNode(1);
    root1.right.left = new TreeNode(5);
    root1.right.right = new TreeNode(9);

    TreeNode root2 = new TreeNode(1);
    root2.left = new TreeNode(2);
    root2.right = new TreeNode(8);
    root2.left.left = new TreeNode(3);
    root2.left.right = new TreeNode(4);
    root2.right.left = new TreeNode(5);
    root2.right.right = new TreeNode(6);

    IsValidBST isValidBST = new IsValidBST();
    System.out.println(isValidBST.isValidBST(root1));
    System.out.println(isValidBST.isValidBST(root2));
    }  
}
