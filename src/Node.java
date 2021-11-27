public class Node {
    int x;
    int y;
    boolean visited;

    public Node(int x, int y, int distance, boolean visited) {
        this.x = x;
        this.y = y;
        this.distance = distance;
        this.visited = visited;
    }
    int distance;

    @Override
    public String toString() {
        return "Node{" +
                "x=" + x +
                ", y=" + y +
                ", distance=" + distance +
                '}';
    }
}
