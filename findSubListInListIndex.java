public int find (Node list1, Node list2) {
    if (list1 == null || list2 == null)
        return -1;

    int index = -1;
    int indexCursor = 0;
    Node start = list2;

    while (list1 != null) {
        if (list1.val == list2.val) {
            if (index == -1)
                index = indexCursor;
            if (list2.next == null)
                return index;
            list2 = list2.next;
        } else {
            index = -1;
            list2 = start;
        }
        indexCursor++;
        list1 = list1.next;
    }
    return -1;
}
