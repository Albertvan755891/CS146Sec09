import java.util.Scanner;

public class TreeNode {

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

    public static TreeNode createTree(){
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(3);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(1);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(9);
        return root;
    }

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        if(root == null) 
            return null;

        int pValue = p.val;
        int qValue = q.val;

        TreeNode current = root;
        while(current != null) {
            if (pValue < current.val && qValue < current.val){
                current = current.left;
            }
            else if (pValue > current.val && qValue > current.val){
                current = current.right;
            }
            else{
                return current;
            }
        }
        return null;
    }

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        TreeNode root = createTree();

        System.out.print("Enter the value of p: ");
        int pValue = scanner.nextInt();
        TreeNode p = new TreeNode(pValue);

        System.out.print("Enter the value of q: ");
        int qValue = scanner.nextInt();
        TreeNode q = new TreeNode(qValue);

        TreeNode treeNode = new TreeNode();  // Create an instance of TreeNode
        TreeNode lca = treeNode.lowestCommonAncestor(root, p, q);  // Call the method using the instance
        System.out.println("Lowest Common Ancestor: " + (lca != null ? lca.val : "null"));
    }
}
