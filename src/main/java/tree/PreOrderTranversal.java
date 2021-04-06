package tree;

import java.util.ArrayList;
import java.util.List;

public class PreOrderTranversal implements TreeTranversal {

    @Override
    public List<Integer> tranverse(Node root) {
        List<Integer> tranversed = new ArrayList<>();
        preOrderTranverse(root, tranversed);
        return tranversed;
    }

    private void preOrderTranverse(Node root, List<Integer> tranversed) {
        if( root == null ) {
            return;
        }

        tranversed.add(root.data);
        preOrderTranverse(root.left, tranversed);
        preOrderTranverse(root.right, tranversed);
    }
}
