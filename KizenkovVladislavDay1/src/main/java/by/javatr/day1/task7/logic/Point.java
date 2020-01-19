package by.javatr.day1.task7.logic;

public class Point {
    private double x;
    private double y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double distance(Point p){
        return Math.sqrt(square(this.x-p.x)+square(this.y-p.y));
    }

    private double square(double v){
        return v*v;
    }

    @Override
    public String toString() {
        return "( " + x +", " + y +")";
    }
}
