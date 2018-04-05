package ru.stqa.pft.sandbox;

public class Point {
    public double x;
    public double y;

    public Point (double x, double y){
        this.x = x;
        this.y = y;
    }
    public double distance(Point p){ //вычисляет расстояние между экземпляром у которого вызван и любым другим экземпляром
        double h = Math.sqrt(Math.pow((p.x-this.x), 2)+Math.pow((p.y-this.y), 2));
        return h;
    }

    public static double distance(Point p1, Point p2){ //вычисляет расстояние между двуямя любыми экземплярами
        double h = Math.sqrt(Math.pow((p2.x-p1.x), 2)+Math.pow((p2.y-p1.y), 2));
        return h;

    }

}
