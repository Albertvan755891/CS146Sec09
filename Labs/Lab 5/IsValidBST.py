class TreeNode(object):

     def __init__(self, val=0, left=None, right=None):

         self.val = val
         self.left = left
         self.right = right
         
     def isValidBST(self, root):
         def isValid(node, min_val, max_val):
             if not node:
                 return True
             
             if not(min_val < node.val < max_val):
                 return False
             
             return isValid(node.left, min_val, node.val) and \
               isValid(node.right, node.val, max_val)
                    
         return isValid(root, float("-inf"), float("inf"))
     
root1 = TreeNode(4);
root1.left = TreeNode(3);
root1.right = TreeNode(8);
root1.left.left = TreeNode(1);
root1.right.left = TreeNode(5);
root1.right.right = TreeNode(9);

root2 = TreeNode(1);
root2.left = TreeNode(2);
root2.right = TreeNode(8);
root2.left.left = TreeNode(3);
root2.left.right = TreeNode(4);
root2.right.left = TreeNode(5);
root2.right.right = TreeNode(6);
     
tree_node = TreeNode()
print(tree_node.isValidBST(root1))
print(tree_node.isValidBST(root2))
