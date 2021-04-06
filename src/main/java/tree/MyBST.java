package tree;

import java.util.ArrayList;
import java.util.List;

public class MyBST implements BST {
    private Node root = null;

    @Override
    public void add(Integer val) {
        Node node = new Node(val);
        root = addNode(root, node);
    }

    private Node addNode(Node root, Node node) {
        if( root == null ) {
            return node;
        }

        if( node.data <= root.data ) {
            root.left = addNode(root.left, node);
        } else {
            root.right = addNode(root.right, node);
        }

        return root;
    }

    @Override
    public List<Integer> inOrderTranversal() {
        List<Integer> tranversed = new ArrayList<>();
        tranverse(root, tranversed);
        return tranversed;
    }

    private void tranverse(Node root, List<Integer> tranversed) {
        if( root == null ) {
            return;
        }

        tranverse(root.left, tranversed);
        tranversed.add(root.data);
        tranverse(root.right, tranversed);
    }

    @Override
    public void truncate(Integer val1, Integer val2) {
        root = truncateRecursive(root, val1, val2);
    }

    private Node truncateRecursive(Node root, Integer min, Integer max) {
        if( root == null ) {
            return null;
        }

        if( min <= root.data && root.data <= max ) {
            root.left = truncateRecursive(root.left, min, max);
            root.right = truncateRecursive(root.right, min, max);
            return root;
        } else if( min > root.data ) {
            return truncateRecursive(root.right, min, max);
        } else {
            return truncateRecursive(root.left, min, max);
        }
    }
}
