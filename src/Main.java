import java.awt.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public static abstract class Shape implements Comparable<Shape> {
        public abstract double area();

        public int compareTo(Shape s) {
            return Double.compare(this.area(), s.area());
        }
    }
    public static class Rectangle extends Shape {
        private double l1;
        private double l2;

        public Rectangle(double l1, double l2) {
            this.l1 = l1;
            this.l2 = l2;
        }

        public double area() {
            return l1 * l2;
        }
    }

    public static class Circle extends Shape {
        private double r;

        public Circle(double r) {
            this.r = r;
        }

        public double area() {
            return Math.PI * r * r;
        }
    }

    public static class Triangle extends Shape {
        private double b;
        private double h;

        public Triangle(double b, double h) {
            this.b = b;
            this.h = h;
        }

        public double area() {
            return b * h / 2;
        }
    }

    static double sum(Shape[] s) {

    }

    static void sort(Shape[] v) {
        int i = 0;
        for(Shape s : v) {
            boolean found = false;
            int j = 0;

            while (!found || j >= i) {
                if (s.compareTo(v[j]) < 0) {
                    found = true;

                    v[i] = v[j];
                    v[j] = s;
                }
                j++;
            }
            i++;
        }
    }

    public static void main(String[] args) {
        Shape[] v = new Shape[4];

        v[0] = new Rectangle(5, 3);
        v[1] = new Circle(5);
        v[2] = new Square(5);
        v[3] = new Circle(120);

        double res = sum(v);

        System.out.println("sum: " + res);

        print(v);

        sort(v);

        print(v);
    }
}
