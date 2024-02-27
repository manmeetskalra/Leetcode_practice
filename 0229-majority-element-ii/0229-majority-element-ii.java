class Solution {
    public List<Integer> majorityElement(int[] nums) {
        // if(nums.length==1){
        //     return new ArrayList<>(Arrays.asList(nums[0]));
        // }
        // if(nums.length==2){
        //     return new ArrayList<>(Arrays.asList(nums[0],nums[1]));
        // }
        //List<Integer> list = new ArrayList<>(Arrays.asList(nums[0],nums[1]));
        int one = 0;
        int num1 = 0;
        int num2 = 0;
        int two = 0;
        for(int i=0;i<nums.length;i++){
            if(one==0 && nums[i]!=num2){
                num1 = nums[i];
                one++;
            } else if(two==0 && nums[i]!=num1){
                num2 = nums[i];
                two++;
            } else if(nums[i]==num1){
                one++;
            } else if(nums[i]==num2){
                two++;
            } else{
                one--;
                two--;
            }
        }
        List<Integer> list = new ArrayList<>();
        int threshold = nums.length/3;
        one=0;
        two=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==num1) one++;
            else if(nums[i]==num2) two++;
        }
        System.out.println(one);
        System.out.println(two);
        if(one>threshold){
            list.add(num1);
        }
        if(two>threshold){
            list.add(num2);
        }
        return list;
    }
}