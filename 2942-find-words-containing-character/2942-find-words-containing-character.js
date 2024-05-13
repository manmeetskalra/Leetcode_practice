/**
 * @param {string[]} words
 * @param {character} x
 * @return {number[]}
 */
var findWordsContaining = function(words, x) {
    let j=0;
    let res=[];
    words.forEach((word)=>{
        if(word.indexOf(x)>-1){
            res.push(j);
        }
        j++;
    });
    return res;
};