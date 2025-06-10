function solution(n, edge) {
    let graph = {};
    for(node of edge){
        const [first, second] = node;
        if(!graph[first]) graph[first] = [];
        if(!graph[second]) graph[second] = [];
        graph[first].push(second);
        graph[second].push(first);
    }

    function bfs(graph, start){
        const visited = [];
        const queue = [];
        let lastLevelSize = 0;
        
        queue.push(start);
        visited[start] = true;
        
        while(queue.length > 0){           
            let size = queue.length;
            lastLevelSize = size;
            while(size-- != 0){
                const tempNode = queue.shift();
                for(const adjacent of graph[tempNode]){
                    if(!visited[adjacent]){
                        queue.push(adjacent);
                        visited[adjacent] = true;
                    }
                }
            }
        }
        return lastLevelSize;
    }
    
    var answer = bfs(graph, 1)
    return answer;
}