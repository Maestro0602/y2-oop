import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

abstract class Shape {
    public abstract void printSummary(int index);

    public abstract void draw();
}

class Line extends Shape {
    private final int length;

    public Line(int length) {
        this.length = length;
    }

    @Override
    public void printSummary(int index) {
        System.out.println(index + ". length: " + length);
    }

    @Override
    public void draw() {
        for (int i = 0; i < length; i++) {
            System.out.print("_");
        }
        System.out.println();
    }
}

class Rectangle extends Shape {
    private final int width;
    private final int height;

    public Rectangle(int width, int height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public void printSummary(int index) {
        System.out.println(index + ". Width: " + width + ", Height: " + height);
    }

    @Override
    public void draw() {
        for (int r = 0; r < height; r++) {
            for (int c = 0; c < width; c++) {
                if (r == 0 || r == height - 1 || c == 0 || c == width - 1) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}

class Triangle extends Shape {
    private final int height;

    public Triangle(int height) {
        this.height = height;
    }

    @Override
    public void printSummary(int index) {
        System.out.println(index + ". Height: " + height);
    }

    @Override
    public void draw() {
        for (int r = 1; r <= height; r++) {
            for (int c = 1; c <= r; c++) {
                if (r == height || c == 1 || c == r) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}

class ShapeManager {
    private final List<Shape> shapes;

    public ShapeManager() {
        this.shapes = new ArrayList<>();
    }

    public void addNewShape(Scanner sc) {
        System.out.println("==== Add new shape ====");
        System.out.println("Select a shape:");
        System.out.println("1.  Line");
        System.out.println("2.  Rectangle");
        System.out.println("3.  Triangle");
        System.out.print("Choose an opt: ");

        String choice = sc.nextLine().trim();

        switch (choice) {
            case "1": {
                int length = readPositiveInt(sc, "Input length: ");
                shapes.add(new Line(length));
                break;
            }
            case "2": {
                int width = readPositiveInt(sc, "Input width: ");
                int height = readPositiveInt(sc, "Input height: ");
                shapes.add(new Rectangle(width, height));
                break;
            }
            case "3": {
                int height = readPositiveInt(sc, "Input height: ");
                shapes.add(new Triangle(height));
                break;
            }
            default:
                System.out.println("Invalid shape option.");
                break;
        }

        System.out.println();
    }

    public void viewAllLines() {
        System.out.println("==== List all lines ====");
        printByType(Line.class);
    }

    public void viewAllRectangles() {
        System.out.println("==== List all rectangles ====");
        printByType(Rectangle.class);
    }

    public void viewAllTriangles() {
        System.out.println("==== List all triangles ====");
        printByType(Triangle.class);
    }

    private void printByType(Class<? extends Shape> type) {
        int count = 0;

        for (Shape shape : shapes) {
            if (type.isInstance(shape)) {
                count++;
                shape.printSummary(count);
                shape.draw();
                System.out.println();
            }
        }

        if (count == 0) {
            System.out.println("No shape found.");
            System.out.println();
        }
    }

    private int readPositiveInt(Scanner sc, String prompt) {
        while (true) {
            System.out.print(prompt);
            String value = sc.nextLine().trim();

            try {
                int number = Integer.parseInt(value);
                if (number > 0) {
                    return number;
                }
                System.out.println("Please input a number greater than 0.");
            } catch (NumberFormatException e) {
                System.out.println("Please input a valid number.");
            }
        }
    }
}

public class ex3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ShapeManager manager = new ShapeManager();

        while (true) {
            System.out.println("==== Menu ====");
            System.out.println("1.  View all lines");
            System.out.println("2.  View all rectangles");
            System.out.println("3.  View all triangles");
            System.out.println("4.  Add a new shape");
            System.out.println("5.  Quit");
            System.out.print("Choose an opt: ");

            String choice = sc.nextLine().trim();
            System.out.println();

            switch (choice) {
                case "1":
                    manager.viewAllLines();
                    break;
                case "2":
                    manager.viewAllRectangles();
                    break;
                case "3":
                    manager.viewAllTriangles();
                    break;
                case "4":
                    manager.addNewShape(sc);
                    break;
                case "5":
                    System.out.println("BYE BYE!!");
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid option. Please choose 1-5.\n");
                    break;
            }
        }
    }
}
