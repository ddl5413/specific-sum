import algorithm.SpecificSumAllResult;
import algorithm.SpecificSumAllResultDecimal;
import algorithm.SpecificSumOneResult;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class Main {


    public static void main(String[] args) {
        Random r = new Random();
        int scale = 30;
        int[] ints = r.ints(scale, 100, 100000).toArray();
        int count = r.nextInt(scale);
        int[] pickInts = r.ints(count, 0,scale).toArray();
        Set<Integer> pick = new HashSet<>();
        for (int pickInt : pickInts) {
            pick.add(pickInt);
        }

        Arrays.sort(ints);
        int[] inputs = new int[ints.length];
        for (int i = 0,j = ints.length - 1; i < ints.length; i++, j--) {
            inputs[i] = ints[j];
        }

        System.out.println("input:" + Arrays.toString(inputs));
        int difference = pick.stream().mapToInt(v -> ints[v]).sum();
        System.out.println("target = " + difference);


        System.out.println("=====老算法=====");
        SpecificSumOneResult specificSumOneResult = new SpecificSumOneResult();
        specificSumOneResult.summation(inputs, difference);
        System.out.println("");
        System.out.println("=====新算法=====");
        SpecificSumAllResult specificSumAllResult = new SpecificSumAllResult();
        specificSumAllResult.summation(inputs, difference);
        System.out.println("");
        System.out.println("=====新算法 Decimal=====");
        SpecificSumAllResultDecimal specificSumAllResultDecimal = new SpecificSumAllResultDecimal();
//        specificSumAllResultDecimal.summation(inputs, difference);
    }
}