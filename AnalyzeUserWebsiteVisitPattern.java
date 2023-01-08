class Solution {
    
    /*
    I know this solution is right, fuck these cunts
    */
    
    private class Triple {
        String name;
        int time;
        String site;
        Triple(String name, int time, String site) {
            this.name = name;
            this.time = time;
            this.site = site;
        }
    }
    public List<String> mostVisitedPattern(String[] username, int[] timestamp, String[] website) {
        
        //create list of triples
        
        List<Triple> userData = new ArrayList();
        
        for(int i = 0; i < username.length; i++) {
            userData.add(new Triple(username[i], timestamp[i], website[i]));
        }
        
        Collections.sort(userData, (a,b) -> (a.time-b.time));
        
        
        System.out.println("Print sorted by time");
        for(int i = 0; i < username.length; i++) {
            username[i] = userData.get(i).name;
            timestamp[i] = userData.get(i).time;
            website[i] = userData.get(i).site;
            System.out.println(username[i] + " " + timestamp[i] + " " + website[i]);
        }
        System.out.println("end");
        
        //map from patterns to scores
        int maxScore = -1;
        List<String> result = new ArrayList();
        Map <List<String>, Integer> scores = new HashMap();
        //map from names to last patterns
        Map <String, List<String>> lastPattern = new HashMap();
        for(int i = 0; i < username.length; i++) {
            String currWebsite = website[i];
            List <String> currPattern = lastPattern.get(username[i]);
            int newScore = -1;
            
            if(currPattern!=null) {
                
                if(currPattern.size()<3) {
                    
                    currPattern.add(currWebsite);
                } else {
                    currPattern.remove(0);
                    currPattern.add(currWebsite);
                }
                
                if(currPattern.size() >= 3 ) {
                    newScore = scores.getOrDefault(currPattern, 0)+1;
                    scores.put(currPattern, newScore);
                    System.out.println("length of 3");
                    if(newScore > maxScore||
                       (newScore == maxScore && String.join("", currPattern).compareTo(String.join("", result)) < 0 ) ) {
                        maxScore = newScore;
                        result = new ArrayList();
                        result.addAll(currPattern);
                        System.out.println("new max is " + String.join(", ", result));
                    }
                }
                
                System.out.print(String.join(", ", result));
                
                System.out.print(": " + username[i]);
                System.out.println(", Score is " + newScore);
                System.out.print("\n");
                
                
            } else {
                lastPattern.put(username[i], new ArrayList());
                lastPattern.get(username[i]).add(currWebsite);
            }
        }
        return result;
    }
}
