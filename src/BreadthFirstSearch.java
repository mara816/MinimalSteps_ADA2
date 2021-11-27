public class BreadthFirstSearch {
    // Tree containing nodes
    Tree<Node> tree;
    private final long start = System.currentTimeMillis();
    private int final_count;

    // Breadth First Search
    // Method for finding the minimum amount of knight steps between two given nodes in an arbitrary size chessboard
    public void minimum_steps(int board_height, int board_width, int knight_start_x_position, int knight_start_y_position,
                              int knight_end_x_position, int knight_end_y_position) {

        // To count the amount of nodes added to tree
        int count = 0; // O(1)

        // Set true if the node has been visited
        boolean[][] visit = new boolean[board_width + 1][board_height + 1]; // O(1)

        // Make all possible nodes on board unvisited
        for (int i = 0; i <= board_width; i++) // O(N)
            for (int j = 0; j <= board_height; j++) // O(N²)
                visit[i][j] = false; // O(N)

        // Instantiating node with start position visited and a travelling distance of zero
        Node root = new Node(knight_start_x_position, knight_start_y_position, 0,
                visit[knight_start_x_position][knight_start_y_position] = true); // O(1)

        // Instantiating the tree
        tree = new Tree<>(root); // O(1)

        // Adding root node to the tree
        tree.children.add(root); // O(1)

        // Possible moves for the knight in x and y direction
        int[] dx = {-2, -1, 1, 2, -2, -1, 1, 2};
        int[] dy = {-1, -2, -2, -1, 1, 2, 2, 1};

        // While the tree is not empty
        // Poll the tree - returns and removes the head
        while (!tree.children.isEmpty()) { // O(N)
            Node currentNode = tree.children.poll(); // O(1)

            // When current position is the end position:
            // Save the amount of nodes in tree in the variable final_count
            // Print result
            // Clear the tree
            if (currentNode.x == knight_end_x_position && currentNode.y == knight_end_y_position) { // O(N)
                final_count = count; // O(1)
                cli(board_height, board_width, knight_start_x_position, knight_start_y_position,
                        knight_end_x_position, knight_end_y_position, currentNode.distance); // O(1)
                tree.children.clear(); // O(1)

                // If current position is not the end position
            } else { // O(N)

                // Loop through possible moves
                // Create a new Node for each possible move
                for (int i = 0; i < dx.length; i++) { // O(N*m)
                    int newX = currentNode.x + dx[i]; // O(1)
                    int newY = currentNode.y + dy[i]; // O(1)

                    // If move is inside board and are not yet visited:
                    // Instantiate new visited node
                    // Count + 1, to count the amount of nodes in tree
                    // Add new child node to tree
                    if (newX >= 0 && newY >= 0 && newX <= board_width && newY <= board_height && !visit[newX][newY]) { // O(N)
                        Node nextNode = new Node(newX, newY, currentNode.distance + 1, visit[newX][newY] = true); // O(1)
                        count++; // O(1)
                        tree.addChild(nextNode); // O(1)

                        // Adds child node to childNode list, only for showing child nodes in Node toString
                        currentNode.childNode.add(nextNode); // O(1)
                    }
                }
            }
        }
    } // O(N²)
    // minimum_steps has a time complexity of O(N²) at worst cases.

    // Printing results
    public void cli(int board_height, int board_width, int start_x, int start_y, int end_x, int end_y, int distance) {
        String result = "Board width (x): " + board_width + "\n"
                + "Board height (y): " + board_height + "\n"
                + "Start position: [x=" + start_x + ", y=" + start_y + "]\n"
                + "Target position: [x=" + end_x + ", y=" + end_y + "]\n"
                + "Nodes in tree: " + final_count + "\n"
                + "Execution time: " + (System.currentTimeMillis() - start) / 1000.0 + " seconds" + "\n"
                // Prints the tree. Affects the execution time
                + "Tree: " + tree + "\n\n"
                + "Shortest path: " + distance + " steps";
        System.out.println(result);
    }
}