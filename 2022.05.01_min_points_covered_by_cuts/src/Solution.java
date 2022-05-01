import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Solution {

    public int minPointsCoveredByCuts(List<Cut> cuts) {
        List<Point> points = new ArrayList<>(convertCutsToPoints(cuts));

        int counter = 0;
        int countOpenedCuts = 0;

        int i = 0;
        while (i < points.size()) {
            if (points.get(i).isLeft) {
                counter++;
                countOpenedCuts++;
                i++;
                while (points.get(i).isLeft) {
                    i++;
                    countOpenedCuts++;
                }
            } else {
                int j = 0;
                while (j < countOpenedCuts) {
                    countOpenedCuts--;
                    i++;
                    if (i < points.size() && points.get(i).isLeft) {
                        counter++;
                        countOpenedCuts+=2;
                    }
                }
                countOpenedCuts = 0;
            }

        }
        return counter;
    }

    private List<Point> convertCutsToPoints(List<Cut> cuts) {
        return cuts
                .stream()
                .flatMap(cut -> Stream.of(new Point(cut.left, true), new Point(cut.right, false)))
                .sorted()
                .collect(Collectors.toList());
    }
}
