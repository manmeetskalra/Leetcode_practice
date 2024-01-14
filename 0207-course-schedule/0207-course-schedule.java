class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> list = new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            list.add(new ArrayList<>());
        }
        for(int i=0;i<prerequisites.length;i++){
            list.get(prerequisites[i][0]).add(prerequisites[i][1]);
        }
        int[] visited = new int[numCourses];
        for(int i=0;i<numCourses;i++){
            if(visited[i]==0){
                if(isCyclic(list, visited, i)){
                    return false;
                }
            }
        }
        return true;
    }
    
    public boolean isCyclic(List<List<Integer>> list, int[] visited, int num){
        if(visited[num]==2){
            return true;
        }
        visited[num] = 2;
        List<Integer> l = list.get(num);
        for(int i=0;i<l.size();i++){
            int curr = l.get(i);
            if(visited[curr]!=1){
                if(isCyclic(list, visited, curr)){
                    return true;
                }
            }
        }
        visited[num] = 1;
        return false;
    }
}