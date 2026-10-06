import java.util.*;

class Solution {

    // Helper class to store node details
    private static class NodeInfo {

        TreeNode node;
        int row;
        int col;

        NodeInfo(TreeNode node, int row, int col) {
            this.node = node;
            this.row = row;
            this.col = col;
        }
    }

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;

        // Map: col -> (row -> PriorityQueue of node values to maintain sorting)
        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();
        Queue<NodeInfo> queue = new LinkedList<>();

        queue.offer(new NodeInfo(root, 0, 0));

        while (!queue.isEmpty()) {
            NodeInfo curr = queue.poll();
            TreeNode node = curr.node;
            int row = curr.row;
            int col = curr.col;

            map.putIfAbsent(col, new TreeMap<>());
            map.get(col).putIfAbsent(row, new PriorityQueue<>());
            map.get(col).get(row).offer(node.val);

            if (node.left != null) {
                queue.offer(new NodeInfo(node.left, row + 1, col - 1));
            }
            if (node.right != null) {
                queue.offer(new NodeInfo(node.right, row + 1, col + 1));
            }
        }

        // Build result list from sorted TreeMap
        for (TreeMap<Integer, PriorityQueue<Integer>> rows : map.values()) {
            List<Integer> colList = new ArrayList<>();
            for (PriorityQueue<Integer> nodes : rows.values()) {
                while (!nodes.isEmpty()) {
                    colList.add(nodes.poll());
                }
            }
            result.add(colList);
        }

        return result;
    }
}