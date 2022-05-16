//leetcode again says this one is only faster than 17% of java submissions, so something may be unoptimized
public int rob(int[] nums) {
        /*
        the maximum sum for each index will either contain the current one or stop before
        */
        
        int n = nums.length;
        int [] dyn = new int [n];
        dyn[0] = nums[0];
        if(n == 1) {
            return dyn[0];
        }
        dyn[1] = Math.max(dyn[0], nums[1]);
        for(int i = 2; i <n; i++) {
            int d2 = dyn[i-2]+ nums[i];
            int d1 = dyn[i-1];
            System.out.println("for idx "+ i +", dyn[i-2] is " + dyn[i-2] 
                               + ", sum is " + d2 + "dyn[i-1] is "+ d1);
            dyn[i] = Math.max(d2, d1);
        }
        return dyn[n-1];
    }
