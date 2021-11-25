import java.util.ArrayList;

public class Node {
    int x;
    int y;
    ArrayList<Node> childNode = new ArrayList<>();

    public Node(int x, int y, int distance) {
        this.x = x;
        this.y = y;
        this.distance = distance;
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
