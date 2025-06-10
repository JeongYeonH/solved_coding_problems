function solution(n, t, m, timetable) {
    const arrivalTableByMin = [];
    const timeTableByMin = timetable.map(time => getMin(time)).sort((a,b) => a-b);
  
    arrivalTableByMin.push(540);
    for(let i=1; i< n; i++){
        const arrivalTime = 540 + i*t;
        arrivalTableByMin.push(arrivalTime);
    }

    function getMin(time){
        const hour = +time.substr(0,2);
        const min = +time.substr(3,2);
        return hour*60 + min;
    }
    
    function minToTime(min){
        let hour = Math.floor(min/60)
        if(hour < 10) hour = "0"+ hour.toString();
        let minute = (min%60).toString();
        if(minute.length < 2) minute = "0" + minute;
        return hour+""+":"+minute;
    }
    
    const howManyRideEach = [];
    let count = 0;
    for(let i=0; i < arrivalTableByMin.length; i++){
        let canRide = [];
        for(let j=count; j < timeTableByMin.length; j++){
            if(j == count + m){
                count=j;
                break;
            }else if(arrivalTableByMin[i] < timeTableByMin[j]){
                count=j;
                break;
            }
            canRide.push(timeTableByMin[j])
        }
        howManyRideEach.push(canRide);
    }

    for(let i=howManyRideEach.length-1; i >=0; i--){
        const lengthOfBlock = howManyRideEach[i].length;
        if(lengthOfBlock < m){
            return minToTime(arrivalTableByMin[i]);
        }else if(lengthOfBlock == m){
            return minToTime(howManyRideEach[i][m-1]-1);
        }
    }
}