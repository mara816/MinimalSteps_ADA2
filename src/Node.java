import java.util.ArrayList;

public class Node {
    int x, y, distance;
    boolean visited;
    // List to store all child nodes
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
                ", y=" + y + ", distance=" + distance +", childNode={" +  childNode +
                "}, ";
    }
}
