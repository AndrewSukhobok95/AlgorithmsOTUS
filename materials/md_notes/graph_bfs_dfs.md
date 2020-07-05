## Поиск в Графе

**Breadth First Search**

BFS stands for Breadth First Search is a vertex based technique for finding a shortest path in graph. It uses a Queue data structure which follows first in first out. In BFS, one vertex is selected at a time when it is visited and marked then its adjacent are visited and stored in the queue. It is slower than DFS.

```
G:
        A
       / \
      B   C
     /   / \
    D   E   F

Output is:
A, B, C, D, E, F
```

**Depth First Search**

DFS stands for Depth First Search is a edge based technique. It uses the Stack data structure, performs two stages, first visited vertices are pushed into stack and second if there is no vertices then visited vertices are popped.

```
G:
        A
       / \
      B   C
     /   / \
    D   E   F

Output is:
A, B, D, C, E, F
```

### DFS

Input: A graph G and a vertex v of G

Output: All vertices reachable from v labeled as discovered

- Recursive:
```
procedure DFS(G, v) is
    label v as discovered
    for all directed edges from v to w that are in G.adjacentEdges(v) do
        if vertex w is not labeled as discovered then
            recursively call DFS(G, w)
```

- Non-Recursive:
```
procedure DFS_iterative(G, v) is
    let S be a stack
    S.push(v)
    while S is not empty do
        v = S.pop()
        if v is not labeled as discovered then
            label v as discovered
            for all edges from v to w in G.adjacentEdges(v) do 
                S.push(w)
```

### BFS

Input: A graph G and a starting vertex root of G

Output: Goal state. The parent links trace the shortest path back to root

```
procedure BFS(G, root) is
    let Q be a queue
    label root as discovered
    Q.enqueue(root)
    while Q is not empty do
        v := Q.dequeue()
        if v is the goal then
            return v
        for all edges from v to w in G.adjacentEdges(v) do
            if w is not labeled as discovered then
                label w as discovered
                w.parent := v
                Q.enqueue(w)
```


