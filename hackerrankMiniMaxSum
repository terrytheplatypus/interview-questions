public static void miniMaxSum(List<Integer> arr) {
        List <Long> l = new ArrayList<>();
        for(int n = 0; n < 5; n++) {
            long sum  = 0;
            for(int m = 0; m < 5; m++) {
                if(m!= n) {
                    sum+=Long.valueOf(arr.get(m));
                }
            }
            l.add(sum);
        }
        System.out.println(Collections.min(l) + 
        " " + 
        Collections.max(l));

    }
