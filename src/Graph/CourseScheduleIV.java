package Graph;

import java.util.*;

public class CourseScheduleIV {
    public static void main(String[] args) {
        CourseScheduleIV scheduleIV = new CourseScheduleIV();
        int[][] prerequisites = {{0,1},{1,2},{2,4},{3,2},{5,3}};
        int[][] queries = {{0,3},{1,4},{1,3},{2,3},{3,2},{5,4}};
        int numCourses = 6;
        System.out.println(scheduleIV.checkIfPrerequisite(numCourses, prerequisites, queries));
    }

    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        List<List<Integer>> adjList = new ArrayList<>();
        for(int i = 0; i < numCourses; i++) {
            adjList.add(new ArrayList<Integer>());
        }
        for(int i = 0; i < prerequisites.length; i++) {
            int u = prerequisites[i][0];
            int v = prerequisites[i][1];
            adjList.get(u).add(v);
        }

        int[] inDegree = new int[numCourses];
        for(int i = 0; i < numCourses; i++) {
            for(int j : adjList.get(i)) {
                inDegree[j]++;
            }
        }
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < numCourses; i++) {
            if(inDegree[i] == 0) {
                queue.offer(i);
            }
        }
        Map<Integer, Integer> sorted = new HashMap<>();
        int sortedIndex = -1;
        while(!queue.isEmpty()) {
            int size = queue.size();
            sortedIndex++;
            for(int i = 0; i < size; i++) {
                int current = queue.remove();
                sorted.put(current, sortedIndex);
                for(int node : adjList.get(current)) {
                    inDegree[node]--;
                    if(inDegree[node] == 0) {
                        queue.offer(node);
                    }
                }
            }
        }
        List<Boolean> answer = new ArrayList<>();
        for(int i = 0; i < queries.length; i++) {
            if(!sorted.containsKey(queries[i][0]) || !sorted.containsKey(queries[i][1])) {
                answer.add(false);
            }
            else if(sorted.get(queries[i][0]) < sorted.get(queries[i][1])) {
                answer.add(true);
            }
            else {
                answer.add(false);
            }
        }
        return answer;
    }
}
