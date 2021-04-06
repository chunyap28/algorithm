package tree;

import java.util.List;

public interface BST {
    void add(Integer val);
    List<Integer> inOrderTranversal();
    void truncate(Integer val1, Integer val2);
}
