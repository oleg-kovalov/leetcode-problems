class Solution {
    public boolean isPathCrossing(String path) {
        record Point(int x, int y) {}

        HashSet<Point> visited = new HashSet<>();
        int currentX = 0;
        int currentY = 0;
        visited.add(new Point(currentX, currentY));

        for (int i=0; i<path.length(); i++)
        {
            switch (path.charAt(i))
            {
                case 'N' -> currentY++;
                case 'S' -> currentY--;
                case 'E' -> currentX++;
                case 'W' -> currentX--;
            }
            final Point currentPoint = new Point(currentX, currentY);
            if (visited.contains(currentPoint))
            {
                return true;
            }
            visited.add(currentPoint);
        }

        return false;
    }
}