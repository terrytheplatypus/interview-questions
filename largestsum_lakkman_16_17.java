/*
 * largestsum.java
 *
 *  Copyright (c) 2022 NetNumber, Inc. All Rights Reserved.
 *
 * This software is the proprietary information of NetNumber,Inc.
 * Use is subject to license terms.
 *
 * Created on Apr 4, 2022 11:05:19 AM
 */
package nn2.api.web.interviewquestions;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

/**
 *
 * @author dcherepov
 */
public class largestsum_lakkman_16_17 {

    public static void main(String[] args) {
        //"unit test 1"
        
        int[] test0 = {0,1,2,-1};
        System.out.println(largestSumNaive(test0));
        
        int[] test1 = {3, 1, 2, -3, 4, 0, 3, -4};
        /*
        [3,1,2,-3,4,0,3,4] 1
        [4,3,-1,1,4,3,-1] 2
        [6,0,3,1,7,-1] 3
        [3,4,3,4,3] 4
        [7,4,6,0] 5
        [7,7,2]6
        [10,3] 7
        [6] 8
         */
        //naive is wrong
        System.out.println(largestSumNaive(test1));
        System.out.println(largestSumDynamic(test1));

        long time1 = 0;
        long time2 = 0;
        //"load test"
        int[] test2 = generateArray(10000, 100);
        time1 = System.currentTimeMillis();
        int naiveResult = largestSumNaive(test2);
        time2 = System.currentTimeMillis();
        System.out.println("naive result:" + naiveResult);
        System.out.println("time of naive load test:" + (time2 - time1));

        time1 = System.currentTimeMillis();
        int dynamicResult = largestSumDynamic(test2);
        time2 = System.currentTimeMillis();
        System.out.println("dynamic result:" + dynamicResult);
        System.out.println("time of dynamic load test:" + (time2 - time1));

    }

    static int[] generateArray(int size, int range) {
        return IntStream.generate(() -> new Random().nextInt(range) - range / 2).limit(size).toArray();
    }

    static int largestSumDynamic(int[] a) {
        //naive approach is n^2 time and dynamic programming is probably n*log(n)
        //how large does dynamic programming table need to be?
        //could have lists that you add to for each layer, which is fine because arraylist has constant time
        //get and add operations
        //looks like n^2 because the bounds of each loop, but the inner loop always stops early

        /*for [1,2,3,4]
        the dynamic tables are
        [1,2,3,4]
        [3.5.7]
        [6,9]
        [15]
        iterate through dynamic table at lower level, add
        
         */
        int largestSum = Integer.MIN_VALUE;
        List<List<Integer>> dynamicTable = new ArrayList();
        for (int m = 0; m < a.length; m++) {
            int currSum = 0;
            dynamicTable.add(new ArrayList<>());
            if (m == 0) {
                dynamicTable.get(0).add(a[m]);
                currSum = a[m];
            } else {
                int ind = 0;
                for (Integer i : dynamicTable.get(m - 1)) {
                    currSum = i + a[m + ind];
                    dynamicTable.get(m).add(currSum);
                    if (currSum >= largestSum) {
                        largestSum = currSum;
                    }
                    ind++;
                }

            }
        }
        return largestSum;
    }

    static int largestSumNaive(int[] a) {
        //TODO:test gives wrong results but i didn't fix it yet
        //naive impl is easy but slow
        //n^3 or n^2logn time because outer loop iterates over start position, first inner loop over length, 2nd inner loop sums
        //array entries can be negative so int min is lower bound
        int largestSum = Integer.MIN_VALUE;
        for (int m = 0; m < a.length; m++) {
            int currSum = 0;
            //length loop
            for (int n = 0; n < a.length; n++) {
                if(n + m>a.length) {
                    break;
                }
                for (int j = 0; j < n; j++) {
                    currSum += a[m + j];
                }
            }
            if (currSum >= largestSum) {
                largestSum = currSum;
            }
        }
        return largestSum;
    }
}
