import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class CourseSchedule{
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] pair : prerequisites) {
            int course = pair[0];
            int prerequisite = pair[1];
            graph.get(course).add(prerequisite);
        }

        int[] visited = new int[numCourses];
        for (int course = 0; course < numCourses; course++) {
            if (hasCycle(course, visited, graph)) {
                return false; 
            }
        }
        return true; 
    }

    private boolean hasCycle(int course, int[] visited, List<List<Integer>> graph) {
        if (visited[course] == 1){
            return true;
        }
        if (visited[course] == 2){
            return false;
        }
        visited[course] = 1;
        for(int prerequisite : graph.get(course)){
            if(hasCycle(prerequisite, visited, graph)){
                return true;
            }
        }
        visited[course] = 2;
        return false;
        }
public static void main(String[] args) {
    CourseSchedule courseSchedule = new CourseSchedule();
    
    // Test cases
    int[][] prerequisites1 = {{1, 0}};
    int numCourses1 = 2;
    System.out.println("Test Case 1:");
    System.out.println("Input: numCourses = " + numCourses1 + ", prerequisites = " + Arrays.deepToString(prerequisites1));
    System.out.println("Output: " + courseSchedule.canFinish(numCourses1, prerequisites1));
    
    int[][] prerequisites2 = {{1, 0}, {0, 1}};
    int numCourses2 = 2;
    System.out.println("\nTest Case 2:");
    System.out.println("Input: numCourses = " + numCourses2 + ", prerequisites = " + Arrays.deepToString(prerequisites2));
    System.out.println("Output: " + courseSchedule.canFinish(numCourses2, prerequisites2));
    }
}
