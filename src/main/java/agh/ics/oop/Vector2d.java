package agh.ics.oop;

public class Vector2d {
    public final int x;
    public final int y;

    public Vector2d(int x, int y){
        this.x = x;
        this.y = y;
    }

    public String toString() {
        String position = "(" + Integer.toString(this.x) + "," + Integer.toString(this.y) + ")";
        return position;
    }

    public boolean precedes(Vector2d other) {
        if (this.x <= other.x && this.y <= other.y) {
            return true;
        }
        else {
            return false;
        }

    }

    public boolean follows(Vector2d other) {
        if (this.x >= other.x && this.y >= other.y) {
            return true;
        }
        else {
            return false;
        }

    }

    Vector2d add(Vector2d other) {
        Vector2d newVector1 = new Vector2d(this.x + other.x, this.y + other.y);
        return newVector1;
    }

    Vector2d subtract(Vector2d other) {
        Vector2d newVector2 = new Vector2d(this.x - other.x, this.y - other.y);
        return newVector2;
    }

    Vector2d upperRight(Vector2d other) {
        Vector2d newVector3 = new Vector2d(Math.max(this.x, other.x), Math.max(this.y, other.y));
        return newVector3;
    }

    Vector2d lowerLeft(Vector2d other) {
        Vector2d newVector4 = new Vector2d(Math.min(this.x, other.x), Math.min(this.y, other.y));
        return newVector4;
    }

    Vector2d opposite() {
        Vector2d newVector5 = new Vector2d(-this.x, -this.y);
        return newVector5;
    }

    public boolean equals(Object other){
        if (this == other)
            return true;
        if (!(other instanceof Vector2d))
            return false;
        Vector2d that = (Vector2d) other;
        return (this.x == that.x && this.y == that.y);
    }
}
