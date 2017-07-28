public class SquareRoot {
    public int sqrt(int a) {
        if (a == 0 || a == 1) {
            return a;
        }

        int i = 0;
        int j = a/2 + 1;


        while (i < j) {
            if ((i + 1) == j) {
                return i;
            }
            int mid = (i + j) / 2;
            long square = (long)Math.pow(mid, 2);
            if (square == a) {
                return mid;
            } else if (square > a) {
                j = mid;
            } else {
                i = mid;
            }
        }

        return i;
    }
}
