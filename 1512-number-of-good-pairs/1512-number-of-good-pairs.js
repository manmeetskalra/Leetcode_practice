/**
 * @param {number[]} nums
 * @return {number}
 */
var numIdenticalPairs = function(nums) {
    let j=0;
    let res=0;
    nums.forEach((e)=>{
       for(let i=j+1;i<nums.length;i++){
           if(nums[i]==e){
               res++;
           }
       }
        j++;
    });
    return res;
};