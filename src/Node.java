import java.util.ArrayList;

public class Node {
    // x and y coordinates of node
    // Distance for steps taken
    int x, y, distance;
    // Has the node been visited before?
    boolean visited;
    // List to store child nodes to the node
    ArrayList<Node> childNode = new ArrayList<>();

    public Node(int x, int y, int distance, boolean visited) {
        this.x = x;
        this.y = y;
        this.distance = distance;
        this.visited = visited;
    }

    @Override
    public String toString() {
        return "Node{" +
                "x=" + x +
                ", y=" + y + ", distance=" + distance + ", childNode={" + childNode +
                "}, ";
    }
}
