/**
 * @param {string[]} operations
 * @return {number}
 */
var finalValueAfterOperations = function(operations) {
    let res = 0;
    operations.forEach((e)=>{
        if(e[0]=='-' || e[2]=='-'){
            res--;
        }else if(e[0]=='+' || e[2]=='+'){
            res++;
        }
    })
    return res;
};