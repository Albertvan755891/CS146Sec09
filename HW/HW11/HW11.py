import numpy as np

class Graph(object):
    def floodFill(self, image, sr, sc, color):
        oldColor = image[sr][sc]
        if oldColor == color:
            return image
        
        def dfs(image, sr, sc):
            if sr < 0 or sr >= len(image) or sc < 0 or sc >= len(image[0]) or image[sr][sc] != oldColor:
                return
            image[sr][sc] = color
            dfs(image, sr-1, sc)
            dfs(image, sr+1, sc)
            dfs(image, sr, sc-1)
            dfs(image, sr, sc+1)
        
        dfs(image, sr, sc)
        return image

def main():
    # Test cases
    graph = Graph()

    image1 = [[1, 1, 1], [1, 1, 0], [1, 0, 1]]
    sr1, sc1, color1 = 1, 1, 2
    result1 = graph.floodFill(image1, sr1, sc1, color1)
    print("Results 1:")
    print(np.array(result1))

    image2 = [[0, 0, 0], [0, 0, 0]]
    sr2, sc2, color2 = 0, 0, 0
    result2 = graph.floodFill(image2, sr2, sc2, color2)
    print("Results 2:")
    print(np.array(result2))

if __name__ == "__main__":
    main()
