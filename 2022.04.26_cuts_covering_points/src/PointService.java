import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PointService {

    public Map<Integer, Integer> getCoveringCutsNumberByPoint(List<Integer> numbers, List<Cut> cuts) {
        List<Point> points = convertCutsToPoints(cuts);
        points.addAll(convertNumbersToPoints(numbers));
        Collections.sort(points);

        System.out.println(points);

        Map<Integer, Integer> result = new HashMap<>();
        int count = 0;
        for (Point point : points) {
            if (point.type == PointType.LEFT)
                count++;
            else if (point.type == PointType.RIGHT)
                count--;
            else
                result.put(point.value, count);
        }

        return result;
    }

    private List<Point> convertCutsToPoints(List<Cut> cuts) {
        return cuts.stream()
                .flatMap(cut -> Stream.of(new Point(cut.left, PointType.LEFT), new Point(cut.right, PointType.RIGHT)))
                .sorted()
                .collect(Collectors.toList());
    }

    private List<Point> convertNumbersToPoints(List<Integer> numbers) {
        return numbers.stream()
                .flatMap(number -> Stream.of(new Point(number, PointType.NUMBER)))
                .collect(Collectors.toList());
    }
}
