import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Cuts {

    public int countMaxIntersectedCuts(List<Cut> cuts) {
        List<Point> points = convertToPoints(cuts);
        Collections.sort(points);

        int max = 0;
        int cutsCounter = 0;

        for (Point point : points) {
            if (point.isLeft) {
                cutsCounter++;
            } else {
                if (cutsCounter > max) {
                    max = cutsCounter;
                }
                cutsCounter--;
            }
        }
        return max;
    }

    private List<Point> convertToPoints(List<Cut> cuts) {
        List<Point> result = new ArrayList<>();

        for (Cut cut : cuts) {
            result.add(new Point(cut.left, true));
            result.add(new Point(cut.right, false));
        }
        return result;
    }
}
