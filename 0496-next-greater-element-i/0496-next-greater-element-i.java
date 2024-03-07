class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> stack = new Stack<>();
        HashMap<Integer,Integer> hash = new HashMap<>();
        for(int i=nums2.length-1;i>=0;i--){
            if(!stack.isEmpty() && stack.peek()<nums2[i]){
                while(!stack.isEmpty() && stack.peek()<nums2[i]){
                    stack.pop();
                }
            }
            int next = -1;
            if(!stack.isEmpty()){
                next = stack.peek();
            }
            hash.put(nums2[i],next);
            stack.push(nums2[i]);
        }
        int[] res = new int[nums1.length];
        for(int i=0;i<nums1.length;i++){
            int r = -1;
            if(hash.containsKey(nums1[i])){
                r = (int) hash.get(nums1[i]);
            }
            res[i]  = r;
        }
        return res;
    }
}