import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Cuts {

    public int countMaxIntersectedCuts(List<Cut> cuts) {
        List<Point> points = convertToPoints(cuts);

        int max = 0;
        int cutsCounter = 0;

        for (Point point : points) {
            if (point.isLeft) {
                cutsCounter++;
                if (cutsCounter > max) {
                    max = cutsCounter;
                }
            } else {
                cutsCounter--;
            }
        }
        return max;
    }

    private List<Point> convertToPoints(List<Cut> cuts) {
        return cuts.stream()
                .flatMap(cut -> Stream.of(new Point(cut.left, true), new Point(cut.right, false)))
                .sorted()
                .collect(Collectors.toList());
    }
}
