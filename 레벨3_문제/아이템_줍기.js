function solution(rectangle, characterX, characterY, itemX, itemY) {
    let board = Array.from({length: 102}, () => Array(102).fill(0));
    let visted = Array.from({length: 102}, () => Array(102).fill(false));
    let distance = Array.from({length: 102}, () => Array(102).fill(0));

    for(square of rectangle){
        fillSquare(square, board);
    }
    for(square of rectangle){
        removeExceptEdges(square, board);
    }

    function fillSquare(coordinates, arr){
        const [stX, stY, lsX, lsY] = coordinates;
        for(let i=stY*2; i<= lsY*2; i++){
            for(let j=stX*2; j<=lsX*2; j++){
                arr[i][j] = 1;
            }
        }
    }
    
    function removeExceptEdges(coordinates, arr){
        const [stX, stY, lsX, lsY] = coordinates;
        for(let i=stY*2+1; i<=  lsY*2-1; i++){
            for(let j=stX*2+1; j<=lsX*2-1; j++){
                arr[i][j] = 0;
            }
        }
    }
    
    const dy = [0, 0, 1, -1];
    const dx = [1, -1, 0, 0];
    bfs(characterY*2, characterX*2);

    function bfs(startY, startX){
        const queue = [];
        queue.push([startY, startX]);
        visted[startY][startX] = true;
        distance[startY][startX] = 0;

        while(queue.length){
            const[currY, currX] = queue.shift();

            for(let d=0; d < 4; d++){
                const nextY = currY + dy[d];
                const nextX = currX + dx[d];
                const isYInBoard =  (0 <= nextY && nextY < 24);
                const isXInBoard =  (0 <= nextX && nextX < 24);
                if(isYInBoard && isXInBoard && 
                    board[nextY][nextX] == 1 && !visted[nextY][nextX]){
                    queue.push([nextY, nextX]);
                    visted[nextY][nextX] = true;
                    distance[nextY][nextX] = distance[currY][currX] + 1;
                }
            }
        }
    }

    const shortestRoute = distance[itemY*2][itemX*2];
    return shortestRoute/2;
}
