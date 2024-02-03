class Solution {
    public void nextPermutation(int[] nums) {
        int i = nums.length-1;
        int max = Integer.MIN_VALUE;
        List<Integer> l = new ArrayList<>();
        while(i>=0){
            if(max==Integer.MIN_VALUE){
                max = nums[i];
                l.add(nums[i]);
                i--;
            } else{
                if(nums[i]<max){
                    System.out.println("Inside loop");
                    theekKar(nums,i,l);
                    //l.add(nums[i]);
                    //Collections.sort(l);
                    // for(int j=i;j<nums.length;j++){
                    //     nums[j] = l.get(l.size()-1);
                    //     //System.out.println(nums[j]);
                    //     l.remove(l.size()-1);
                    // }
                    return;
                }
                else{
                    System.out.println("Inside else");
                    l.add(nums[i]);
                    max = Math.max(nums[i],max);
                    i--;
                }
            }
        }
        Arrays.sort(nums);
    }
    public void theekKar(int[] nums, int start, List<Integer> l){
        System.out.println("Inside");
        Collections.sort(l);
        for(int i=0;i<l.size();i++){
            int curr = l.get(i);
            int num = nums[start];
            if(curr>num){
                l.remove(Integer.valueOf(curr));
                l.add(num);
                Collections.sort(l);
                nums[start] = curr;
                int k=0;
                for(int j=start+1;j<nums.length;j++){
                    nums[j] = l.get(k);
                    k++;
                }
                return;
            }
        }
    }
}
// 231332
/*
[1,2,3]
[3,2,1]
[1,1,5]
[2,3,1,3,3,2]
*/