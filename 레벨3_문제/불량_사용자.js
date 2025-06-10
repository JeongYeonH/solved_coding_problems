function solution(user_id, banned_id) {
    const patterns = [];
    const suspects = [];
    for(banned of banned_id){
        let pattern = "^";
        for(let i=0; i <banned.length; i++){
            if(banned[i] == "*"){
                pattern += ".";
            }else{
                pattern += banned[i]+"";
            }
        }
        pattern += "$"
        patterns.push(pattern)          
    }
    const regexPatterns = patterns.map(p => new RegExp(p));
    
    for(let i=0; i <regexPatterns.length; i++){
        let innerSuspects = [];
        for(userId of user_id){
            if(regexPatterns[i].test(userId)){
                innerSuspects.push(userId);
            }
        }
        suspects.push(innerSuspects)
    }
    
    let resultSet = new Set();
    function dfs (index, current){
        if(index >= banned_id.length){
            let sorted = [...current].sort().join(",");
            resultSet.add(sorted);
            return;
        } 
        
        for(let suspect of suspects[index]){
            if(current.includes(suspect)) continue;
            current.push(suspect);
            dfs(index+1, current);
            current.pop();
        }
    }
    dfs(0, []);
    return resultSet.size;
}