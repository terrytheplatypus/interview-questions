//this solution passes in leetcode but is bad compared to other ones
//it should be nlogn

class Solution {
    public int findMinDifference(List<String> timePoints) {
        if(timePoints.size()<= 1) return 0;
        // could sort first
        Collections.sort(timePoints);
        List <String> startAndEnd = new ArrayList();
        startAndEnd.add(timePoints.get(0));
        startAndEnd.add(timePoints.get(timePoints.size()-1));
        Collections.sort(startAndEnd);
        
        //bigger than 720
        int minDiff = 900;
        for(int i = 0; i < timePoints.size()-1; i++) {
            int curDiff = getTimeDiff(timePoints.get(i), timePoints.get(i+1));
            minDiff = curDiff < minDiff?curDiff:minDiff;
        }
        //check start/end
        int curDiff = getTimeDiff(startAndEnd.get(0), startAndEnd.get(1));
        minDiff = curDiff < minDiff?curDiff:minDiff;
        
        return minDiff;
    }
    
    //time1 is before time2
    int getTimeDiff(String time1, String time2) {
        int hourDiff = 0;
        int minuteDiff = 0;
        String[] timeSplit1 = time1.split(":");
        String[] timeSplit2 = time2.split(":");
        
        int hour1 = Integer.valueOf(timeSplit1[0]);
        int minute1 = Integer.valueOf(timeSplit1[1]);
        
        int hour2 = Integer.valueOf(timeSplit2[0]);
        int minute2 = Integer.valueOf(timeSplit2[1]);
        
        if(hour2 - hour1 > 12 ) {
            hour1 += 24;
            
            int tempHour = hour1;
            int tempMin = minute1;
            hour1 = hour2;
            minute1 = minute2;
            
            hour2 = tempHour;
            minute2 = tempMin;
        }
        
        hourDiff = hour2 - hour1;
        
        if(minute2 < minute1) {
            minute2 +=60;
            hourDiff--;
            
            // int tempMin = minute1;
            // minute1 = minute2;
            // minute2 = tempMin;
        }
        
        return hourDiff*60 + minute2-minute1;
    }
}
