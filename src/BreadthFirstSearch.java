import java.util.ArrayDeque;
import java.util.Queue;

public class BreadthFirstSearch {
    Queue<Node> queue = new ArrayDeque<>();
    int finalcount;

    // Bread First Search
    //
    public int minimum_steps(int board_height, int board_width, int knight_start_x_position, int knight_start_y_position,
                              int knight_end_x_position, int knight_end_y_position) {

        // Counting the amount of nodes added to queue and tree
        int count = 0;

        // Instantiating node with a reset distance
        Node root = new Node(knight_start_x_position, knight_start_y_position, 0);

        // Adding root to the queue
        queue.add(root);

        // Instantiating
        Tree tree = new Tree(root);

        // x and y direction, where a knight can move
        int dx[] = {-2, -1, 1, 2, -2, -1, 1, 2};
        int dy[] = {-1, -2, -2, -1, 1, 2, 2, 1};

        // While the queue is not empty, keep BFS alive
        while (!queue.isEmpty()) { // O(N)
            Node currentNode = queue.poll();
            // When current position is end position, return distance traveled and print result
            if (currentNode.x == knight_end_x_position && currentNode.y == knight_end_y_position) { // O(N)
                finalcount = count;
                cli(board_height, board_width, knight_start_x_position, knight_start_y_position,
                        knight_end_x_position, knight_end_y_position, currentNode.distance, tree);
                return currentNode.distance;
                // If current position is not end position
            } else {
                // Loops through possible moves
                for (int i = 0; i < dx.length; i++) { // O(N*m)
                    int newX = currentNode.x + dx[i];
                    int newY = currentNode.y + dy[i];

                    // If moves is inside board, instantiate new node, add node to queue and tree
                    if (newX > 0 && newY > 0 && newX < board_width && newY < board_height) { // O(N)
                        Node nextNode = new Node(newX, newY, currentNode.distance + 1);
                        count++;
                        queue.add(nextNode); // O(N)
                       // currentNode.childNode.add(nextNode); // O(N)
                    }
                }
            }
        }
        // Returns max value if no match is found
        return Integer.MAX_VALUE;

    } // O(N*m)
    // minimum_steps has a time complexity of O(N*m) at worse cases.

    // Printing results
    public void cli(int board_height, int board_width, int start_x, int start_y, int end_x, int end_y, int distance, Tree tree) {
        String result = "Board width (x): " + board_width + "\n"
                + "Board height (y): " + board_height + "\n"
                + "Start position: [x=" + start_x + ", y=" + start_y + "]\n"
                + "Target position: [x=" + end_x + ", y=" + end_y + "]\n"
                + "Shortest path: " + distance + " steps" + "\n"
                + "Nodes in tree: " + finalcount;
        System.out.println(result);
    }
}