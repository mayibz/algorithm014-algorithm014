package Week_02;

import java.util.ArrayList;
import java.util.List;

/**
 * N叉树 后续遍历
 * created by qiminghua on 2020/8/19
 */
public class NAryTreePostorderTraversal {
    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    };

    public List<Integer> postorder(Node root) {
        List<Integer> list = new ArrayList<>();
        postorder(root, list);
        return list;
    }

    public void postorder(Node node, List<Integer> res) {
        if (node == null) {
            return;
        }
        for (Node n : node.children) {
            postorder(n, res);
        }
        res.add(node.val);
    }
}
