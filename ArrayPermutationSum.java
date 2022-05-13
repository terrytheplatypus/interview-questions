 public static String twoArrays(int k, List<Integer> A, List<Integer> B) {
    // Write your code here
    
    System.out.println("boopus");
    
    Set <Integer> minIdxs = new HashSet<>();
    
    for(int n=0; n< A.size(); n ++) {
        int minOverVal = Integer.MAX_VALUE;
        int minOverIdx = -1;
        for(int m=0; m< B.size(); m++) {
            int sum = A.get(n) + B.get(m);
            if( sum >= k && sum < minOverVal && !minIdxs.contains(m)) {
                minOverVal = sum;
                minOverIdx = m;
                System.out.println("index " + n + "indx " + m);
            }
        }
        if(minOverIdx == -1) return "NO";
        minIdxs.add(minOverIdx);
    }
    
    return "YES";

    }

}
