package algorithm;

import data.Tree;
import data.TreeNode;

import java.util.List;

public class SpecificSumAllResult {
    public void summation(int [] ints, int difference) {
        Tree<Integer> result = new Tree();
        long before = System.currentTimeMillis();
        int[] sums = new int[ints.length];
        sums[ints.length - 1] = ints[ints.length - 1];
        for (int i = ints.length - 2; i >= 0; i--) {
            sums[i] = sums[i + 1] + ints[i];
        }
        summation(ints, sums, result.getRoot(), difference, 0);
        long after = System.currentTimeMillis();
        for (List<Integer> branch : result.allBranches()) {
            System.out.println("result = " + branch.stream().mapToInt(v -> v).sum() + ", list:" + branch);
        }
        System.out.println("result size : " + result.allBranches().size());
        System.out.println("use: " + (after - before));
    }

    private void summation(int [] ints, int[] sums, TreeNode<Integer> result, int difference, int start) {
        if (start == ints.length) {
            return;
        }
        for (int i = start; i < ints.length; i++) {

            if (difference == ints[i]) {
                TreeNode currNode = result.getTree().newNode(ints[i]);
                result.addChildren(currNode);
                return;
            }
            if (difference > ints[i] && difference <= sums[i]) {
                TreeNode currNode = result.getTree().newNode(ints[i]);
                summation(ints, sums, currNode,difference - ints[i], i + 1);
                if (currNode.isHasChildren()) {
                    result.addChildren(currNode);
                }
            }
        }
        return;
    }
}
