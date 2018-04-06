package ru.stqa.pft.sandbox;

public class MyFirstProgramm {
	public static void main (String args[]) {
		System.out.println("Hello world");

		Point p1 = new Point(1, 1);
		Point p2 = new Point(1,3);
		Point z = new Point(2, 5);
		System.out.println("Расстояние между точками p1:(" + p1.x + "; " + p1.y + ")  и p2:(" + p2.x + "; " + p2.y + ") равно "
				+ p1.distance(p2));
		System.out.println("Расстояние между точками p1:(" + p1.x + "; " + p1.y + ")  и p2:(" + p2.x + "; " + p2.y + ") равно "
				+ Point.distance(p1, p2));
		System.out.println("Расстояние между точками p1:(" + p1.x + "; " + p1.y + ")  и p2:(" + p2.x + "; " + p2.y + ") равно "
				+ p1.distance(z));
		System.out.println("Расстояние между точками z:(" + z.x + "; " + z.y + ")  и p2:(" + p2.x + "; " + p2.y + ") равно "
				+ Point.distance(z, p2));

		System.out.println("Расстояние между точками p1:(" + p1.x + "; " + p1.y + ")  и p2:(" + p2.x + "; " + p2.y + ") равно "
				+ distance(p1, p2)); //Использование метода расчета расстояния из запускаемого класса

	}

	public static double distance(Point p1, Point p2){ //Метод расположен в запускаемом классе
		double h = Math.sqrt(Math.pow((p2.x-p1.x), 2)+Math.pow((p2.y-p1.y), 2));
		return h;
	}


}