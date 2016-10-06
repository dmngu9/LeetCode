public class Solution {
    public int lastRemaining(int n) {
        if (n == 1) 
            return 1;
        int gap = 2;
        int lastEvenNum = (n%2) == 0 ? n : n - 1;
        int firstEvenNum = 2;
        int factor = n/2;
        boolean rightDirection = true;
        while (factor > 1) {
            if (rightDirection) {
                if ((lastEvenNum - firstEvenNum) % (gap*2) == 0) {
                    firstEvenNum += gap;
                }
                lastEvenNum -= gap;
                gap *= 2;
                rightDirection = false;
            } else {
                if ((lastEvenNum - firstEvenNum) % (gap*2) == 0) {
                    lastEvenNum -= gap;
                }
                firstEvenNum += gap;
                gap *= 2;
                rightDirection = true;
            }
            if (firstEvenNum == lastEvenNum)
                return firstEvenNum;
            factor /= 2;
        }
        return firstEvenNum;
    }
}