package Week_02;

import java.util.*;

/**
 * N叉树的层序遍历
 * https://leetcode-cn.com/problems/n-ary-tree-level-order-traversal/
 * created by qiminghua on 2020/8/19
 */
public class NAryTreeLevelOrderTraversal {
    static class Node {
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

    public static List<List<Integer>> levelOrder2(Node root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            List<Integer> level = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node node = queue.poll();
                level.add(node.val);
                queue.addAll(node.children);
            }
            result.add(level);
        }
        return result;
    }

    public static List<List<Integer>> levelOrder3(Node root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;
        List<Node> previousLayer = Arrays.asList(root);
        while (!previousLayer.isEmpty()) {
            List<Node> currentLayer = new ArrayList<>();
            List<Integer> previousVals = new ArrayList<>();
            for (Node node : previousLayer) {
                previousVals.add(node.val);
                currentLayer.addAll(node.children);
            }
            result.add(previousVals);
            previousLayer = currentLayer;
        }
        return result;
    }

    public static List<List<Integer>> levelOrder(Node root) {
        LinkedList<Node> linkedList = new LinkedList();
        List<List<Integer>> res = new ArrayList<>();
        linkedList.add(root);
        while (!linkedList.isEmpty()) {
            int count = linkedList.size();
            List<Integer> innerList = new ArrayList<>();
            while (count > 0) {
                Node node = linkedList.poll();
                innerList.add(node.val);
                linkedList.addAll(node.children);
                count --;
            }
            res.add(innerList);
        }
        return res;
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        List<Node> rootChilds = new ArrayList<>();
        for (int i = 2; i <= 4; i++) {
            Node node = new Node(i);
            rootChilds.add(node);
            if (i == 3) {
                List<Node> list = new ArrayList<>();
                for (int j = 5; j <=6; j++) {
                    list.add(new Node(j));
                }
            }
        }
        root.children = rootChilds;
        List<List<Integer>> res = levelOrder2(root);
        System.out.println(res.toString());
    }
}
