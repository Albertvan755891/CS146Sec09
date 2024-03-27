class TreeNode(object):

    def __init__(self, val=0, left=None, right=None):
         self.val = val
         self.left = left
         self.right = right
         
    def create_tree(self):
        root = TreeNode(4)
        root.left = TreeNode(3)
        root.right = TreeNode(8)
        root.left.left = TreeNode(1)
        root.right.left = TreeNode(5)
        root.right.right = TreeNode(9)
        return root

    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':

        if root is None:
            return None
        
        p_value = p.val
        q_value = q.val
        
        current = root
        while current:
            if p_value < current.val and q_value < current.val:
                current = current.left
            elif p_value > current.val and q_value > current.val:
                current = current.right
            else: 
                return current
        return None
    
def main():
    tree_node = TreeNode()
    root = tree_node.create_tree()
    
    p_value = int(input("Enter the value of p: "))
    p = TreeNode(p_value)
    
    q_value = int(input("Enter the value of q: "))
    q = TreeNode(q_value)
    
    lca = tree_node.lowestCommonAncestor(root, p, q)
    print("Lowest Common Ancestor:", lca.val if lca else "null")
    
if __name__ == "__main__":
    main()   
