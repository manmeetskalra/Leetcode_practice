class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> list = new ArrayList<>();
        int start = newInterval[0];
        int end = newInterval[1];
        
        for(int i=0;i<intervals.length;i++){
            int[] curr = intervals[i];
            //overlapped
            if((curr[1]>=start && curr[1]<=end) || (end>=curr[0] && end<=curr[1])){
                start = Math.min(start,curr[0]);
                end = Math.max(end,curr[1]);
            } else if(end<curr[0]){                 // new one is left
                list.add(new int[]{start,end});
                start = curr[0];
                end = curr[1];
            } else{                                 // new one is right
                list.add(new int[]{curr[0],curr[1]});
            }
        }
        list.add(new int[]{start,end});
        // if(start!=-1 || end!=-1){
        //     list.add(new int[]{start,end});
        // }
        
        int[][] result = new int[list.size()][2];
        for(int i=0;i<list.size();i++){
            int[] curr = list.get(i);
            result[i][0] = curr[0];
            result[i][1] = curr[1];
        }
        return result;
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    /*
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> res = new ArrayList<>();
        int start = newInterval[0];
        int end = newInterval[1];
        boolean inserted  = true;
        if(intervals.length > 0){
            start = intervals[0][0];
            end = intervals[0][1];
            inserted = false;
        }
        
        for(int i=0;i<intervals.length;i++){
            if(newInterval[0] <= end && newInterval[1] >=start){
                start = Math.min(newInterval[0], start);
                end = Math.max(newInterval[1], end);
                inserted = true;
            }
            if(intervals[i][0] <= end && intervals[i][1] >=start){
                start = Math.min(intervals[i][0], start);
                end = Math.max(intervals[i][1], end);
            }
            else{
                int[] curr = new int[]{start,end};
                res.add(curr);
                start = intervals[i][0];
                end = intervals[i][1];
            }
        }
        int[] cur = new int[]{start,end};
        res.add(cur);
        
        if(!inserted){
            res.add(newInterval);
        }
        int[][] result = new int[res.size()][2];
        for(int i=0;i<res.size();i++){
            int[] curr = res.get(i);
            result[i][0] = curr[0];
            result[i][1] = curr[1];
        }
        return result;
    }
    
    */
}