/*
this solution passes on leetcode but the time spent is in bottom 33% and space usage is in bottom 7%
i think it's pretty readable but maybe the use of java objects is a bad thing?
for string length k and words list length N, it's O(N*k) time and space usage i think
*/
class Solution {
    public int expressiveWords(String s, String[] words) {
        /*
        idea:
        go through s and reduce it to a list of char + consecutiveCharCount
        reduce each word in words to char + consecCharCount
        for each reduced word, check if char count is the same to s char count
        if it is, compare one by one
        */
        CharWithCountList base = new CharWithCountList(s);
        int count = 0;
        for(String word: words) {
           CharWithCountList curr =  new CharWithCountList(word);
            if(base.isStretchy(curr)){
                count++;
            }
        }
        return count;
    }
    
    private class CharWithCountList {
        List <CharWithCount> base = new ArrayList();
        CharWithCountList(String s) {
            char curChar = s.charAt(0);
            for(int i = 0; i < s.length(); i++) {
                curChar = s.charAt(i);
                if(base.size()>0 && curChar==base.get(base.size()-1).c) {
                    base.get(base.size()-1).count++;
                } else {
                    base.add(new CharWithCount(curChar, 1));
                }

            }
        }
        
        boolean isStretchy(CharWithCountList a) {
            if(this.base.size()!= a.base.size()) return false;
            else {
                boolean result = true;
                for(int i = 0; i < this.base.size(); i++) {
                    if(this.base.get(i).c != a.base.get(i).c) {
                        result = false;
                        break;
                    }
                    else if(this.base.get(i).count>= 3 && a.base.get(i).count > this.base.get(i).count) {
                        result = false;
                        break;
                    }
                    else if(this.base.get(i).count< 3 && a.base.get(i).count != this.base.get(i).count) {
                        result = false;
                        break;
                    }
                    
                }
                return result;
            }
        }
    }
    
    private class CharWithCount {
        char c;
        int count;
        CharWithCount(char c, int count) {
            this.c = c;
            this.count = count;
        }
    }
}
