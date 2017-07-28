public class SearchForRange {
    // DO NOT MODIFY THE LIST
    private int findBoundIndex(int i, int j, int target, boolean start, List<Integer> a) {
        while (i < j) {
            int mid = (i + j)/2;

            if (a.get(mid) == target && ((start && (mid > 0) && a.get(mid-1) != target) ||
                    (!start && (mid < a.size() - 1) && a.get(mid+1) != target))) {
                return mid;
            } else if ((start && a.get(mid) >= target) || (!start && a.get(mid) > target)){
                j = mid-1;
            } else {
                i = mid+1;
            }
        }

        return a.get(i) == target ? i : -1;
    }
    public ArrayList<Integer> searchRange(final List<Integer> a, int b) {
        if (a == null || a.size() == 0) {
            return null;
        }

        int i = 0;
        int j = a.size() - 1;

        int start = findBoundIndex(i, j, b, true, a);
        int end = findBoundIndex(i, j, b, false, a);;

        ArrayList<Integer> res = new ArrayList<Integer>();
        res.add(start);
        res.add(end);
        return res;
    }
}
