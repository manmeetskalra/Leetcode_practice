/**
 * @param {number[]} nums
 * @return {number[]}
 */
var getConcatenation = function(nums) {
    const res = nums;
    nums.forEach((e)=>res.push(e));
    return res;
};