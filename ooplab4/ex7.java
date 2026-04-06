public class ex7 {

    static class ITStudent {
        String name, id;
        void study() {
            System.out.println(name + " studies in it");
        }
    }

    static class ProgrammingStudent extends ITStudent {
        String language;
        void code() {
            System.out.println(name + " codes in " + language);
        }
    }

    static class TelecomStudent extends ITStudent {
        String network;
        void configure() {
            System.out.println(name + " configures " + network);
        }
    }

    static class Point {
        double x, y;
        Point(double x, double y) { 
            this.x = x; 
            this.y = y; }
    }

    static class Line extends Point {
        double x2, y2;
        Line(double x1, double y1, double x2, double y2) {
            super(x1, y1); 
            this.x2 = x2; 
            this.y2 = y2;
        }
        double length() { 
            return Math.sqrt(Math.pow(x2-x, 2) + Math.pow(y2-y, 2)); 
        }
    }

    static class Triangle extends Line {
        double x3, y3;
        Triangle(double x1, double y1, double x2, double y2, double x3, double y3) {
            super(x1, y1, x2, y2); 
            this.x3 = x3; 
            this.y3 = y3;
        }
        double area() { 
            return 0.5 * Math.abs((x2-x)*(y3-y) - (x3-x)*(y2-y)); 
        }
    }

    static class Rectangle extends Line {
        double width, height;
        Rectangle(double x, double y, double w, double h) {
            super(x, y, x+w, y+h); 
            this.width = w; 
            this.height = h;
        }
        double area() { 
            return width * height; 
        }
    }

    public static void main(String[] args) {

        ProgrammingStudent ps = new ProgrammingStudent();
        ps.name = "hengrith"; 
        ps.language = "C++";
        ps.study();  
        ps.code();

        TelecomStudent ts = new TelecomStudent();
        ts.name = "caro"; 
        ts.network = "5G";
        ts.study();  
        ts.configure();

        Triangle t = new Triangle(0,0, 4,0, 0,3);
        System.out.println("Triangle area: " + t.area());

        Rectangle r = new Rectangle(0,0, 4,3);
        System.out.println("Rectangle area: " + r.area());
    }
}