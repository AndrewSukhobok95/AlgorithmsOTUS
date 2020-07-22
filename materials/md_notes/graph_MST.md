# Построение минимального скелета (Minimal Span Tree)

## Алгоритм Карускала

```
KRUSKAL(G):
    sort G.E by weight(u, v), increasing
    A = DSU()
    foreach v in G.V:
       MAKE-SET(v)
    foreach (u, v) in G.E:
       if FIND-SET(u) ≠ FIND-SET(v):
          A = A ∪ {(u, v)}
          UNION(u, v)
    return A
```

