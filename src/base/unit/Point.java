package base.unit;

public class Point {
    //坐标
    private final int x;
    private final int z;

    public Point(int x, int z) {
        this.x = x;
        this.z = z;
    }

    public Point(Point point) {
        this.x = point.x;
        this.z = point.z;
    }

    public Point() {
        x = 0;
        z = 0;
    }

    public Point(Vector vec) {
        this.x = vec.getX();
        this.z = vec.getZ();
    }

    public int getX() {
        return x;
    }

    public int getZ() {
        return z;
    }
}
