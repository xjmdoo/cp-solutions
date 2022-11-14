class Solution {
    private Map<Integer, List<Integer>> xMap = new HashMap<>();
    private Map<Integer, List<Integer>> yMap = new HashMap<>();
    private Set<Coords> visited = new HashSet<>();

    public int removeStones(int[][] stones) {
        for (int[] stone : stones) {
            List<Integer> xList = xMap.getOrDefault(stone[0], new ArrayList<Integer>());
            List<Integer> yList = yMap.getOrDefault(stone[1], new ArrayList<Integer>());
            xList.add(stone[1]);
            yList.add(stone[0]);
            xMap.put(stone[0], xList);
            yMap.put(stone[1], yList);
        }

        int connected = 0;
        for (int[] stone : stones) {
            Coords current = new Coords(stone[0], stone[1]);
            if (!visited.contains(current)) {
                dfs(current);
                connected++;
            }
        }

        return stones.length - connected;
    }

    private void dfs(Coords coords) {
        if (visited.contains(coords)) return;
        visited.add(coords);

        if (xMap.containsKey(coords.x)) {
            for (Integer y : xMap.get(coords.x)) {
                dfs(new Coords(coords.x, y));
            }
        }

        if (yMap.containsKey(coords.y)) {
            for (Integer x : yMap.get(coords.y)) {
                dfs(new Coords(x, coords.y));
            }
        }
    }

    static class Coords {
        public int x;
        public int y;

        public Coords(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object object) {
            if (this == object) return true;
            if (object == null) return false;
            if (getClass() != object.getClass()) return false;
            Coords other = (Coords) object;
            if (x == other.x && y == other.y) return true;
            return false;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }

        @Override
        public String toString() {
            return "(" + x + ", " + y + ")";
        }
    }
}

