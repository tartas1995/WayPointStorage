package me.tartas1995.waypointstorage.entities;

public class WayPoint {
    private int x;
    private int y;
    private int z;

    public WayPoint() {}

    @Override
    public String toString() {
        return "XYZ: " + this.x + " / " + this.y + " / " + this.z;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getX() {
        return x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getY() {
        return y;
    }

    public void setZ(int z) {
        this.z = z;
    }

    public int getZ() {
        return z;
    }
}
