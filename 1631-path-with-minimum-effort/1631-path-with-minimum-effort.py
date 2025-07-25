class Solution:
    def minimumEffortPath(self, heights: List[List[int]]) -> int:
        rows, cols = len(heights), len(heights[0])
        minHeap = [(0, 0, 0)] # (abs diff, r, c)
        direct = [[0, 1], [1, 0], [-1, 0], [0, -1]]
        visit = set()

        while minHeap:
            diff, r, c = heapq.heappop(minHeap)
            if r == rows - 1 and c == cols - 1:
                return diff

            if (r, c) in visit:
                continue
        
            visit.add((r, c))

            for dr, dc in direct:
                nr, nc = r + dr, c + dc
                if 0 <= nr < rows and 0 <= nc < cols and (nr, nc) not in visit:
                    new_diff = max(diff, abs(heights[r][c] - heights[nr][nc]))
                    heapq.heappush(minHeap, (new_diff, nr, nc))
        