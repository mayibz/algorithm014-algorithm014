package Week_02;

import java.util.ArrayList;
import java.util.List;

/**
 * 589 N叉树的 前序遍历
 * https://leetcode-cn.com/problems/n-ary-tree-preorder-traversal/description/
 * created by qiminghua on 2020/8/19
 */
public class nAryTreePreorderTraversal {
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

    public List<Integer> preorder(Node root) {
        List<Integer> list = new ArrayList<>();
        perorder(root, list);
        return list;
    }

    public void perorder(Node node, List<Integer> list) {
        if (node == null) {
            return;
        }
        list.add(node.val);
        for (Node n : node.children) {
            perorder(n, list);
        }
    }
}
