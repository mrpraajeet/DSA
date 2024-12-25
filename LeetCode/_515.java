import java.util.*;

class _515 {
    public List<Integer> largestValues(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        traverse(root, list, 0);
        return list;
    }

    private void traverse(TreeNode curr, ArrayList<Integer> list, int depth) {
        if(curr == null) return;

        if(list.size() <= depth) list.add(curr.val);
        else if(list.get(depth) < curr.val) list.set(depth, curr.val);

        traverse(curr.left, list, depth+1);
        traverse(curr.right, list, depth+1);
    }
}