package algorithm;

import java.util.ArrayList;
import java.util.List;

public class SpecificSumOneResult {
    public void summation(int [] ints, int difference) {
        List<Integer> result = new ArrayList<>();
        long before = System.currentTimeMillis();
        summation(ints, result, difference, 0);
        long after = System.currentTimeMillis();
        System.out.println("result = " + result.stream().mapToInt(v -> v).sum() + ", list:" + result);
        System.out.println("use: " + (after - before));
    }
    private boolean summation(int [] ints, List<Integer> result, int difference, int start) {
        if (start == ints.length) {
            return false;
        }
        for (int i = start; i < ints.length; i++) {
            if (difference == ints[i] || (difference > ints[i] && summation(ints, result,difference - ints[i], i + 1))) {
                return result.add(ints[i]);
            }
        }
        return false;
    }
}
