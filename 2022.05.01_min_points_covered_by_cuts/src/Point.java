public class Point implements Comparable<Point> {

    int value;
    boolean isLeft;

    public Point(int value, boolean isLeft) {
        this.value = value;
        this.isLeft = isLeft;
    }

    @Override
    public int compareTo(Point anotherPoint) {
        if (this.value == anotherPoint.value) {
            if (this.isLeft && !anotherPoint.isLeft)
                return -1;
            else if (anotherPoint.isLeft && !this.isLeft)
                return 1;
            else return 0;
        } else
            return this.value - anotherPoint.value;
    }
}
