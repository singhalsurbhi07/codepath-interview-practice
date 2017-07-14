/**You are in an infinite 2D grid where you can move in any of the 8 directions :

        (x,y) to
        (x+1, y),
        (x - 1, y),
        (x, y+1),
        (x, y-1),
        (x-1, y-1),
        (x+1,y+1),
        (x-1,y+1),
        (x+1,y-1)
        You are given a sequence of points and the order in which you need to cover the points.
        Give the minimum number of steps in which you can achieve it. You start from the first point.

        Example :

        Input : [(0, 0), (1, 1), (1, 2)]
        Output : 2
        It takes 1 step to move from (0, 0) to (1, 1). It takes one more step to move from (1, 1) to (1, 2).

        This question is intentionally left slightly vague. Clarify the question by trying out a few cases in the “See Expected Output” section.*/

public class MinStepsInInfiniteGrid {
    // X and Y co-ordinates of the points in order.
    // Each point is represented by (X.get(i), Y.get(i))
    public int coverPoints(ArrayList<Integer> X, ArrayList<Integer> Y) {
        int x_length = X.size();
        int y_length = Y.size();

        if (x_length != y_length) {
            return 0;
        }

        int steps = 0;

        for (int i=1; i< x_length; i++) {
            int x1 = X.get(i-1);
            int y1 = Y.get(i-1);

            int x2 = X.get(i);
            int y2 = Y.get(i);
            steps += Math.abs(x2-x1) > Math.abs(y2-y1) ? Math.abs(x2-x1) : Math.abs(y2-y1);
        }

        return steps;

    }
}