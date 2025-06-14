class Solution:
    def findCheapestPrice(self, n: int, flights: List[List[int]], src: int, dst: int, k: int) -> int:
        ps = [float('inf')] * n
        ps[src] = 0
        adj = [[] for _ in range(n)]
        for s,d,p in flights:
            adj[s].append((d,p))
        q = deque()
        q.append(src)
        while k >= 0:
            k-=1
            size = len(q)
            nps = list(ps)
            while size > 0:
                size-=1
                s = q.popleft()
                for d,p in adj[s]:
                    if ps[s]+p < nps[d]:
                        nps[d] = ps[s]+p
                        q.append(d)
            ps = nps
        print(ps)
        return ps[dst] if ps[dst] != float('inf') else -1 


