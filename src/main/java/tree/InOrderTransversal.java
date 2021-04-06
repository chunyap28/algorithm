package tree;

import java.util.ArrayList;
import java.util.List;

public class InOrderTransversal implements TreeTranversal {
    @Override
    public List<Integer> tranverse(Node root) {
        List<Integer> transversed = new ArrayList<>();
        inOrder(root, transversed);
        return transversed;
    }

    private void inOrder(Node root, List<Integer> transversed) {
        if(root == null ) {
            return;
        }

        inOrder(root.left, transversed);
        transversed.add(root.data);
        inOrder(root.right, transversed);
    }
}
