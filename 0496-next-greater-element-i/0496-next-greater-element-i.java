class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> hash = new HashMap<>();
        for(int i=0;i<nums1.length;i++){
            hash.put(nums1[i],i);
        }
        Stack<Integer> stack = new Stack<>();
        for(int i=nums2.length-1;i>=0;i--){
            int result = -1;
            while(!stack.isEmpty() && nums2[i]>=stack.peek()){
                stack.pop();
            }
            if(!stack.isEmpty()){
                result = stack.peek();
            }
            stack.push(nums2[i]);
            if(hash.containsKey(nums2[i])){
                nums1[hash.get(nums2[i])] = result;
            }
        }
        return nums1;
    }
}