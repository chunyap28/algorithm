package tree;

public class TreeConstructor {

    public Node construct(int[] data) {
        if( data.length <= 0 ) {
            return null;
        }

        Node root = addNode(null, data[0]);
        for(int i = 1; i < data.length; i++) {
            addNode(root, data[i]);
        }

        return root;
    }

    public Node addNode(Node root, Integer data) {
        if( root == null ) {
            return new Node(data);
        }

        if( data <= root.data ) {
            //insert left
            root.left = addNode(root.left, data);
        } else {
            //insert right
            root.right = addNode(root.right, data);
        }

        return root;
    }
}
