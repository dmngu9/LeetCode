public int arrange(int[] A) {
    Arrays.sort(A);
    int balls = A.length;
    int max = -1;

    for (int i = 0; i < A.length; i++) {
        int windowStart = A[i];
        int windowEnd = windowStart + balls - 1;
        if (windowEnd > 1000000000)
            break;
        
        int endIndexOfAInWindow = Arrays.binarySearch(A, windowEnd);
        
        if (endIndexOfAInWindow < 0)
            endIndexOfAInWindow = endIndexOfAInWindow * (-1) - 1 - 1;
        
        int ballsInWindow = endIndexOfAInWindow - i + 1;
        if (ballsInWindow > max)
            max = ballsInWindow;
    }

    return balls - max;
}
