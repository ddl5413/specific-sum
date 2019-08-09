package algorithm;

import data.Tree;
import data.TreeNode;

import java.math.BigDecimal;
import java.util.List;

public class SpecificSumAllResultDecimal {
    public void summation(BigDecimal[] ints, BigDecimal difference) {
        Tree<BigDecimal> result = new Tree<>();
        long before = System.currentTimeMillis();
        BigDecimal[] sums = new BigDecimal[ints.length];
        sums[ints.length - 1] = ints[ints.length - 1];
        for (int i = ints.length - 2; i >= 0; i--) {
            sums[i] = sums[i + 1].add(ints[i]);
        }
        summation(ints, sums, result.getRoot(), difference, 0);
        long after = System.currentTimeMillis();
        for (List<BigDecimal> branch : result.allBranches()) {
            System.out.println("result = " + branch.stream().reduce(BigDecimal::add) + ", list:" + branch);
        }
        System.out.println("result size : " + result.allBranches().size());
        System.out.println("use: " + (after - before));
    }

    private void summation(BigDecimal [] ints, BigDecimal[] sums, TreeNode<BigDecimal> result, BigDecimal difference, int start) {
        if (start == ints.length) {
            return;
        }
        for (int i = start; i < ints.length; i++) {

            if (difference.compareTo(ints[i]) == 0) {
                TreeNode currNode = result.getTree().newNode(ints[i]);
                result.addChildren(currNode);
                return;
            }
            if (difference.compareTo(ints[i]) > 0 && difference.compareTo(sums[i]) <= 0) {
                TreeNode currNode = result.getTree().newNode(ints[i]);
                summation(ints, sums, currNode,difference.subtract(ints[i]), i + 1);
                if (currNode.isHasChildren()) {
                    result.addChildren(currNode);
                }
            }
        }
        return;
    }
}
