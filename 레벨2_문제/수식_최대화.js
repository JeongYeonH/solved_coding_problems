function solution(expression) {
    let spilted = expression.split(/(-|\+|\*)/);

    
    function calculationRecur(order, arr, indx){
        if(indx >= order.length){
            return arr;
        }
        const calcArr = calculation(order[indx], arr);
        indx++;
        return calculationRecur(order, calcArr, indx);
    }
    
    function calculation(operation, splitedArr){
        let calculatedArr = [];
        for(let i=0; i < splitedArr.length; i++){
            if(operation==splitedArr[i]){
                const caled = calc(calculatedArr[calculatedArr.length-1], splitedArr[i], splitedArr[i+1]);
                calculatedArr.pop();
                calculatedArr.push(caled);
                i++;
            }else{
                calculatedArr.push(splitedArr[i]);
            }
        }
        return calculatedArr;
    }
    
    function calc(a, op, b){
        switch(op){
            case "*":
                return (+a)*(+b);
            case "-":
                return (+a)-(+b);
            case "+":
                return (+a)+(+b);
            default:
                return null;
        }
    }   
    
    function getPermutations(arr){
        let result = [];
        if(arr.length === 0) return [[]];
        
        for(let i=0; i< arr.length; i++){
            const fix = arr[i];
            const rest = arr.slice(0,i).concat(arr.slice(i+1));
            const permutations = getPermutations(rest);
            
            for(let p of permutations){
                result.push([fix, ...p]);
            }
        }
        return result;
    }
    
    let answer = 0;
    const order = ["*", "+", "-"];
    const allCases = getPermutations(order);
    for(let order of allCases){
        const res = Math.abs(calculationRecur(order, spilted, 0));
        if(res > answer){
            answer = res;
        }
    }

    return answer;
}