package tree;

import java.util.ArrayList;
import java.util.List;

public class PostOrderTransversal implements TreeTranversal {
    @Override
    public List<Integer> tranverse(Node root) {
        List<Integer> transversed = new ArrayList<>();
        postOrder(root, transversed);
        return transversed;
    }

    private void postOrder(Node root, List<Integer> transversed) {
        if(root == null ) {
            return;
        }

        postOrder(root.left, transversed);
        postOrder(root.right, transversed);
        transversed.add(root.data);
    }
}
