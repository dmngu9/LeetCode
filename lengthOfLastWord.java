public class Solution {
	public int lengthOfLastWord(final String a) {
	    boolean isStart = false;
	    boolean isEnd = false;
	    int count = 0;
	    for (int i = 0; i < a.length(); i++) {
	        if (a.charAt(i) != ' ' && !isEnd) {
	            isStart = true;
	            count++;
	        } else if (a.charAt(i) == ' ' && isStart) {
	            isEnd = true;
	            isStart = false;
	        } else if (a.charAt(i) != ' ' && isEnd) {
	            isStart = true;
	            isEnd = false;
	            count = 1;
	        }
	    }
	    return count;
	}
}