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
public class Main{
    public static TreeNode createTree(){
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(6);
        return root;
    }
    public static TreeNode invertTree(TreeNode treeNode){
        if(treeNode == null){
            return null;
        }
        TreeNode left = invertTree(treeNode.left);
        TreeNode right = invertTree(treeNode.right);

        treeNode.left = right;
        treeNode.right = left;

        return treeNode;
    }

    public static void printTree(TreeNode root){
        if(root == null)
            return;

        System.out.print(root.val + " ");
        printTree(root.left);
        printTree(root.right);
    }

    public static void main(String[] args){
        TreeNode root = createTree();
        System.out.println("Original Tree: ");
        printTree(root);

        System.out.println("\nInvertedTree: ");
        TreeNode reversedRoot = invertTree(root);
        printTree(reversedRoot);
    }
 }
