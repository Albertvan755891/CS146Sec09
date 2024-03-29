from typing import List, Optional
from collections import deque

class TreeNode(object):

     def __init__(self, val=0, left=None, right=None):
         self.val = val
         self.left = left
         self.right = right

class LevelOrderTraversal:     
    def levelOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
        if not root:
            return []
    
        result = []
        queue = deque([root])
    
        while queue:
            level_size = len(queue)
            level_values = []
            for _ in range(level_size):
                current = queue.popleft()
                level_values.append(current.val)
                if current.left:
                    queue.append(current.left)
                if current.right:
                    queue.append(current.right)
            result.append(level_values)
    
        return result

def main():
    root1 = TreeNode(4)
    root1.left = TreeNode(3)
    root1.right = TreeNode(8)
    root1.left.left = TreeNode(1)
    root1.right.left = TreeNode(5)
    root1.right.right = TreeNode(9)

    root2 = None
    
    result = LevelOrderTraversal()
    result1 = result.levelOrder(root1)
    result2 = result.levelOrder(root2)

    print("Output for Test Case 1:")
    if not result1:
        print("None")
    else:
        print(result1)

    print("Output for Test Case 2:")
    if not result2:
        print("None")
    else:
        print(result2)
            
if __name__=="__main__":
    main()
