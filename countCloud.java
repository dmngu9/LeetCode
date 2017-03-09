int countClouds(char[][] skyMap) {
    if (skyMap.length == 0) 
        return 0;
    
    final char marked = 'x';
    char[][] checkMap = skyMap;
    int noOfCloud = 0;
    
    while (true) {
        ArrayList<Integer> startingPoint = findStartingPoint(checkMap);
        if (startingPoint.size() == 0)
            return noOfCloud;

        LinkedList<ArrayList<Integer>> list = new LinkedList<>();
        checkMap[startingPoint.get(0)][startingPoint.get(1)] = marked;
        list.add(startingPoint);

        while (!list.isEmpty()) {
            ArrayList<Integer> coord = list.removeFirst(); //read it out
            int x = coord.get(0);
            int y = coord.get(1);

            // look for vertice
            // look up
            if ((x - 1) >= 0 && checkMap[x-1][y] == '1') {
                list = enqueue(x-1, y, list);
                checkMap[x-1][y] = marked;
            } 
            // look down
            if ((x + 1) < checkMap.length && checkMap[x+1][y] == '1') {
                list = enqueue(x+1, y, list);
                checkMap[x+1][y] = marked;
            }
            // look left
            if ((y - 1) >= 0 && checkMap[x][y-1] == '1') {
                list = enqueue(x, y-1, list);
                checkMap[x][y-1] = marked;
            }
            // look right
            if ((y + 1) < checkMap[x].length && checkMap[x][y+1] == '1') {
                list = enqueue(x, y+1, list);
                checkMap[x][y+1] = marked;
            }
        }
        noOfCloud++;
    }
}

ArrayList<Integer> findStartingPoint (char[][] checkMap) {
    ArrayList<Integer> list = new ArrayList<>();
    for (int i = 0; i < checkMap.length; i++) {
        for (int j = 0; j < checkMap[i].length; j++) {
            if (checkMap[i][j] == '1') {
                list.add(i);
                list.add(j);
                return list;
            }
        }
    }
    return list;
}

LinkedList<ArrayList<Integer>> enqueue (int x, int y, LinkedList<ArrayList<Integer>> list) {
    ArrayList<Integer> adjElement = new ArrayList<>();
    adjElement.add(x);
    adjElement.add(y);
    list.add(adjElement);
    return list;
}
