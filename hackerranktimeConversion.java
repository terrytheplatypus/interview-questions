public static String timeConversion(String s) {
        try {
            String[] tokens = s.split(":");
            String hour = tokens[0];
            String minute = tokens[1];
            String second = tokens[2].substring(0,2);
            String AMPM = tokens[2].substring(2,4);
            if(AMPM.equals("PM") && !hour.equals("12") ) {
                hour = String.valueOf(Integer.valueOf(hour) + 12);
            } else if(AMPM.equals("AM") && hour.equals("12")) {
                hour = "00";
            }
            return hour + ":" + minute + ":" + second;
        }catch(Throwable t) {
            t.printStackTrace();
        }
        return null;
    }
