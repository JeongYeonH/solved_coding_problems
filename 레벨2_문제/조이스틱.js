function solution(name) {
    const blankArr= [];
    const reverseName = name[0] + [...name].reverse().slice(0,-1).join('');
    function getRoute(name){
        let defaultRoute = 0;
        let counting = 0;
        for(let i=0; i< name.length; i++){
            const nextAlphabet = name[i].charCodeAt() - "A".charCodeAt();
            const verticalStep = nextAlphabet <= 13 ? nextAlphabet : 26-nextAlphabet;
            defaultRoute +=verticalStep;
            
            if(name[i] == "A"){
                counting++;
            }else if(name[i] != "A" && counting != 0){
                blankArr.push([i-counting,counting]);
                counting = 0;
            }
        }
        return defaultRoute;
    }
    let defaultRoute = getRoute(name);
    getRoute(reverseName);
    
    defaultRoute = defaultRoute + name.length -1;
    if(blankArr.length == 0) return defaultRoute;
    const fixRoute = defaultRoute;
    for(let i=0; i< blankArr.length; i++){
        const repeating = (blankArr[i][0]-1) <= -1 ? 1 : (blankArr[i][0]-1);
        const adjustRoute = fixRoute - blankArr[i][1] + repeating;
        if(adjustRoute < defaultRoute){
            defaultRoute = adjustRoute;
        }
    }
    return defaultRoute;
}
