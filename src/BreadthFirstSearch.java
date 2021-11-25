import java.util.LinkedList;
import java.util.Queue;

public class BreadthFirstSearch {
    Queue<Node> queue = new LinkedList<>();
    long start = System.currentTimeMillis();
    int final_count;

    // Bread First Search
    // Method for finding the minimum amount of knight steps between two given nodes in an arbitrary size chessboard
    public int minimum_steps(int board_height, int board_width, int knight_start_x_position, int knight_start_y_position,
                             int knight_end_x_position, int knight_end_y_position) {

        // Counting the amount of nodes added to queue and tree
        int count = 0;

        // Instantiating node with a reset distance
        Node root = new Node(knight_start_x_position, knight_start_y_position, 0, true);

        // Adding root to the queue
        queue.add(root);

        // Instantiating
        Tree tree = new Tree(root);

        // Movement of the knight in x and y direction
        int[] dx = {-2, -1, 1, 2, -2, -1, 1, 2};
        int[] dy = {-1, -2, -2, -1, 1, 2, 2, 1};

        boolean[][] visit = new boolean[board_width + 1][board_height + 1];

        // Make all nodes on board unvisited
        for (int i = 0; i <= board_width; i++) // O(N)
            for (int j = 0; j <= board_height; j++) // O(N²)
                visit[i][j] = false;

        // Make root node visited
        visit[knight_start_x_position][knight_start_y_position] = true; // O(N)

        // While the queue is not empty
        while (!queue.isEmpty()) { // O(N)
            Node currentNode = queue.poll();

            // When current position is end position:
            // Print result
            // Clear the queue
            // Return minimum steps taken
            if (currentNode.x == knight_end_x_position && currentNode.y == knight_end_y_position) { // O(N)

                final_count = count; // O(N)
                cli(board_height, board_width, knight_start_x_position, knight_start_y_position,
                        knight_end_x_position, knight_end_y_position ,currentNode.distance, tree); // O(N)
                queue.clear(); // O(N)
                return currentNode.distance; // O(N)

                // If current position is not end position
            } else {

                // Loop through possible moves
                for (int i = 0; i < dx.length; i++) { // O(N*m)
                    int newX = currentNode.x + dx[i];
                    int newY = currentNode.y + dy[i];

                    // If moves is inside board and are not yet visited:
                    // Instantiate new visited node
                    // Count + 1, to count the amount of nodes in tree
                    // Add node to queue
                    // Add node to tree
                    if (newX >= 0 && newY >= 0 && newX <= board_width && newY <= board_height && !visit[newX][newY]) { // O(N)
                        Node nextNode = new Node(newX, newY, currentNode.distance + 1, visit[newX][newY] = true);
                        count++;
                        queue.add(nextNode); // O(N)
                        currentNode.childNode.add(nextNode); // O(N)
                    }
                }
            }
        }
        // Returns max value if no match is found
        return Integer.MAX_VALUE;

    } // O(N²)
    // minimum_steps has a time complexity of O(N²) at worst cases.

    // Printing results
    public void cli(int board_height, int board_width, int start_x, int start_y, int end_x, int end_y, int distance, Tree tree) {
        String result = "Board width (x): " + board_width + "\n"
                + "Board height (y): " + board_height + "\n"
                + "Start position: [x=" + start_x + ", y=" + start_y + "]\n"
                + "Target position: [x=" + end_x + ", y=" + end_y + "]\n"
                + "Nodes in tree: " + final_count + "\n"
                + "Execution time: " + (System.currentTimeMillis() - start)/1000.0 + " seconds" + "\n"
                // To print the tree. Affects the executing time
              //  + "Tree: " + tree + "\n\n"
                + "Shortest path: " + distance + " steps";
        System.out.println(result);
    }
}