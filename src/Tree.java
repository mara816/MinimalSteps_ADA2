import java.util.LinkedList;

// Tree to save all nodes
public class Tree<Node> {
    // Nodes (x, y, distance, visited)
    Node root;
    // List for storing all the nodes
    protected final LinkedList<Node> children;

    protected Tree(Node root) {
        this.root = root;
        this.children = new LinkedList<>();
    }

    // Add a child node to the tree:
    // Instantiate a new child node
    // Add to children list
    public void addChild(Node root) {
        Tree<Node> newChild = new Tree<>(root);
        children.add(newChild.root);
    }

    @Override
    public String toString() {
        return "{" + root + "}";
    }
}
