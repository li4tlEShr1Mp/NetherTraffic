package base.unit;

public class Vector {
    //向量
    private int x, z;

    Vector() {
        x = 0;
        z = 0;
    }

    Vector(Vector vec) {
        this.x = vec.getX();
        this.z = vec.getZ();
    }

    public Vector(Point pos) {
        this.x = pos.getX();
        this.z = pos.getZ();
    }

    public Vector(int x, int z) {
        this.x = x;
        this.z = z;
    }

    public int getX() {
        return x;
    }

    public int getZ() {
        return z;
    }

    public Vector add(Vector vec) {
        this.x+=vec.x;
        this.z+=vec.z;
        return this;
    }

    public Vector minus(Vector vec) {
        this.x-=vec.x;
        this.z-=vec.z;
        return this;
    }

    public Vector ratio(float ratio){
        this.x=(int)(this.x*ratio);
        this.z=(int)(this.z*ratio);
        return this;
    }
}
