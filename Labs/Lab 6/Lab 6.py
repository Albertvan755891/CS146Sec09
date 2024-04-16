from collections import defaultdict

def can_finish(num_courses, prerequisites):
    graph = defaultdict(list)
    
    for course, prerequisites in prerequisites:
        graph[course].append(prerequisites)
        
    def has_cycle(course, visited):
        if visited[course] == 1:
            return True
        if visited[course] == 2:
            return False
        
        visited[course] = 1
        for prerequisite in graph[course]:
            if has_cycle(prerequisite, visited):
                return True
        
        visited[course] = 2
        return False
    
    visited = [0] * num_courses
    for course in range(num_courses):
        if has_cycle(course, visited):
            return False
        
    return True

def main():
    print("Test Case 1:")
    print("Input: numCourses = 2, prerequisites = [[1, 0]]")
    print("Output:", can_finish(2, [[1, 0]])) 
    print("\nTest Case 2:")
    print("Input: numCourses = 2, prerequisites = [[1, 0], [0, 1]]")
    print("Output:", can_finish(2, [[1, 0], [0, 1]])) 

if __name__ == "__main__":
    main()
