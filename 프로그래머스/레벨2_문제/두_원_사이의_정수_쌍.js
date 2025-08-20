function solution(r1, r2) {
    let answer = 0;
    for(let x=1; x <= r2; x++){
        const r2YPow = Math.pow(r2, 2) - Math.pow(x, 2);
        const r2Ycoordinate = Math.sqrt(r2YPow);
        const r2Y = Math.floor(r2Ycoordinate)
        const r1YPow = Math.pow(r1, 2) - Math.pow(x, 2);
        const r1Ycoordinate = Math.sqrt(r1YPow) ? Math.sqrt(r1YPow) : 0;
        const r1Y = Math.ceil(r1Ycoordinate)
        
        answer += r2Y - r1Y+1;
    }
    return answer*4;
}