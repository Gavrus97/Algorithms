public class Point implements Comparable<Point> {

    int value;
    PointType type;

    public Point(int value, PointType type) {
        this.value = value;
        this.type = type;
    }


    @Override
    public int compareTo(Point anotherPoint) {

        if (this.value == anotherPoint.value) {
            if (this.type == PointType.LEFT && anotherPoint.type != PointType.LEFT)
                return -1;
            else if (this.type != PointType.LEFT && anotherPoint.type == PointType.LEFT)
                return 1;
            else if (this.type == PointType.RIGHT && anotherPoint.type != PointType.RIGHT)
                return 1;
            else if (this.type != PointType.RIGHT && anotherPoint.type == PointType.RIGHT)
                return -1;
            else return 0;
        } else
            return this.value - anotherPoint.value;

    }

    @Override
    public String toString() {
        return "Point{" +
                "value=" + value +
                ", type=" + type +
                '}';
    }
}
