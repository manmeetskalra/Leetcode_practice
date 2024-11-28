/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */
 
class Solution {
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int low = 0;
        int high = mountainArr.length()-1;
        int mid = helper(low,high,mountainArr);
        int first = searchAsc(low,mid,mountainArr,target);
        // System.out.println("first");
        // System.out.println(first);
        if(first != -1){
            return first;
        }
        
        int second = searchDesc(mid,high,mountainArr,target);
        // System.out.println("sec");
        // System.out.println(second);
        if(second != -1){
            return second;
        }
        return -1;
    }
    
    public int searchAsc(int low, int high, MountainArray mountainArr, int target) {
        while(low<=high){
            int mid = low+(high-low)/2;
            int curr = mountainArr.get(mid);
            if(curr==target){
                return mid;
            } else if(curr<target){
                low = mid+1;
            } else{
                high = mid-1;
            }
        }
        return -1;
    }
    
    public int searchDesc(int low, int high, MountainArray mountainArr, int target) {
        while(low<=high){
            int mid = low+(high-low)/2;
            int curr = mountainArr.get(mid);
            if(curr==target){
                return mid;
            } else if(curr>target){
                low = mid+1;
            } else{
                high = mid-1;
            }
        }
        return -1;
    }
    
    public int helper(int low, int high, MountainArray mountainArr){
        while(low<=high){
            int mid = low+(high-low)/2;
            int curr = mountainArr.get(mid);
            int next = mountainArr.get(mid+1);
            if(next>curr){
                low = mid+1;
            } else if(curr>next){
                int prev = mountainArr.get(mid-1);
                if(curr>prev){
                    return mid;
                } else {
                    high = mid-1;
                }
            }
        }
        return low;
    }
}