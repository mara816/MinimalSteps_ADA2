import java.util.LinkedList;

public class Node {
    int x;
    int y;
    boolean visited;
    LinkedList<Node> childNode = new LinkedList<>();

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
                ", childNode=" + childNode +
                ", distance=" + distance +
                '}';
    }
}
