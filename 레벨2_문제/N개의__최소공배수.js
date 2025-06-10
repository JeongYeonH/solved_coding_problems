function solution(arr) {
    arr.sort((a,b)=> a-b);
    
    function getCommonMultiple(current, next){
        let multiplied = current;
        while(multiplied%next != 0){
            multiplied += current;
        }
        return multiplied;
    }
    
    var answer = 0;
    function getMultipleRecur(index, arr, previousMultiple){
        if(index>= arr.length-1) return previousMultiple;
        const currentMultiple = getCommonMultiple(previousMultiple, arr[index+1]);
        index++;
        return getMultipleRecur(index, arr, currentMultiple);
    }
    answer = getMultipleRecur(0, arr, arr[0]);
    
    return answer;
}