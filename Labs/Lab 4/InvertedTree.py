class TreeNode(object):
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

    def create_tree(self):
        root = TreeNode(1)
        root.left = TreeNode(2)
        root.right = TreeNode(8)
        root.left.left = TreeNode(3)
        root.left.right = TreeNode(4)
        root.right.left = TreeNode(5)
        root.right.right = TreeNode(6)
        return root
    
    def invertTree(self, root):
        if root is None: 
            return None
        
        root.left, root.right = root.right, root.left
        self.invertTree(root.left)
        self.invertTree(root.right)
        
        return root

if __name__ == "__main__":
    def main():
        tree_node = TreeNode()
        root = tree_node.create_tree()
        
        print("Original Tree:")
        print_tree(root)
        
        inverted_tree = tree_node.invertTree(root)
        print("\nInverted Tree:")
        print_tree(inverted_tree)

    def print_tree(root):
        if root:
            print(root.val, end=" ")
            print_tree(root.left)
            print_tree(root.right)
            
    main()
