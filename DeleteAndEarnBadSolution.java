//this is a bad solution because it's n^2 time, due to doing a deep copy of the map inside of a loop over the map. it did pass 23/49 test cases so it's not horrible,
//but not good enough

public int deleteAndEarn(int[] nums) {
            //naive solution is to go through each permutation
            //dp solution: store hashset of each combination
            //base case: 1 element
            return deleteAndEarnDP(nums);

        }
    
        private int deleteAndEarnDP(int []  nums) {
            Map<Map<Integer, Integer>, Integer> memo = new HashMap();
            Map<Integer, Integer> numsMap = new HashMap();
            for(int i = 0; i < nums.length; i ++) {
                Integer val = numsMap.get(nums[i]);
                if(val == null) {
                    numsMap.put(nums[i], 1);
                } else {
                    numsMap.put(nums[i], val + 1);
                }
            }
            return deleteAndEarnHelper(numsMap, memo);
        } 

        private int deleteAndEarnHelper(Map<Integer, Integer> nums, Map<Map<Integer, Integer>, Integer> memo) {
            int result;
            if(nums.size() == 0) result = 0;
            else if(nums.size() == 1) {
                Object [] numsArray = 
                     nums.entrySet().toArray();
                Map.Entry<Integer,Integer> entry = (Map.Entry<Integer,Integer>) numsArray[0];
                result =  entry.getKey() * entry.getValue();
            } else {
                Integer val = memo.get(nums);
                if(val != null) { 
                    result = val;
                }
                else {
                    result = 0;
                    
                    for(Map.Entry<Integer, Integer> entry: nums.entrySet()) {
                        Map<Integer, Integer> newNumsMap = new HashMap();
                        int curResult;
                        newNumsMap.putAll(nums);
                        int curKey = entry.getKey();
                        int curVal = entry.getValue();
                        
                        newNumsMap.remove(curKey);
                        newNumsMap.remove(curKey-1);
                        newNumsMap.remove(curKey+1);
                        
                        curResult = curKey*curVal + deleteAndEarnHelper(newNumsMap, memo);
                        if(curResult > result) result = curResult;
                    }
                    
                }
            }
            memo.put(nums, result);
            return result;
        }
