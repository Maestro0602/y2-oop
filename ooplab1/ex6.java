class Employee {
    int employeeID;
    String name;
    char gender;
    int age;
    double salary;
    String department;
}

class Car {
    String brand;
    String model;
    int year;
    String color;
    double price;
    int horsepower;
}

class BankAccount {
    int accountNumber;
    String ownerName;
    double balance;
    String accountType;
    String currency;
}

class Video {
    int videoID;
    String title;
    String genre;
    double duration;
    int releaseYear;
    String director;
}

public class ex6 {
    public static void main(String[] args) {
        Employee emp1 = new Employee();
        emp1.employeeID = 1001;
        emp1.name = "Alice";
        emp1.gender = 'F';
        emp1.age = 30;
        emp1.salary = 2500.00;
        emp1.department = "Engineering";

        Employee emp2 = new Employee();
        emp2.employeeID = 1002;
        emp2.name = "Bob";
        emp2.gender = 'M';
        emp2.age = 45;
        emp2.salary = 3800.00;
        emp2.department = "Management";

        Car car1 = new Car();
        car1.brand = "Toyota";
        car1.model = "Camry";
        car1.year = 2022;
        car1.color = "White";
        car1.price = 25000.00;
        car1.horsepower = 203;

        Car car2 = new Car();
        car2.brand = "BMW";
        car2.model = "M3";
        car2.year = 2023;
        car2.color = "Black";
        car2.price = 72000.00;
        car2.horsepower = 473;

        BankAccount acc1 = new BankAccount();
        acc1.accountNumber = 100001;
        acc1.ownerName = "Alice";
        acc1.balance = 5000.00;
        acc1.accountType = "Savings";
        acc1.currency = "USD";

        BankAccount acc2 = new BankAccount();
        acc2.accountNumber = 100002;
        acc2.ownerName = "Bob";
        acc2.balance = 15000.00;
        acc2.accountType = "Checking";
        acc2.currency = "EUR";

        Video vid1 = new Video();
        vid1.videoID = 2001;
        vid1.title = "Inception";
        vid1.genre = "Sci-Fi";
        vid1.duration = 148.0;
        vid1.releaseYear = 2010;
        vid1.director = "Christopher Nolan";

        Video vid2 = new Video();
        vid2.videoID = 2002;
        vid2.title = "Interstellar";
        vid2.genre = "Sci-Fi";
        vid2.duration = 169.0;
        vid2.releaseYear = 2014;
        vid2.director = "Christopher Nolan";

        System.out.println("Employee 1: " + emp1.employeeID + ", " + emp1.name + ", " + emp1.gender + ", " + emp1.age + ", " + emp1.salary + ", " + emp1.department);
        System.out.println("Employee 2: " + emp2.employeeID + ", " + emp2.name + ", " + emp2.gender + ", " + emp2.age + ", " + emp2.salary + ", " + emp2.department);
        System.out.println("Car 1: " + car1.brand + ", " + car1.model + ", " + car1.year + ", " + car1.color + ", " + car1.price + ", " + car1.horsepower + "hp");
        System.out.println("Car 2: " + car2.brand + ", " + car2.model + ", " + car2.year + ", " + car2.color + ", " + car2.price + ", " + car2.horsepower + "hp");
        System.out.println("Account 1: " + acc1.accountNumber + ", " + acc1.ownerName + ", " + acc1.balance + ", " + acc1.accountType + ", " + acc1.currency);
        System.out.println("Account 2: " + acc2.accountNumber + ", " + acc2.ownerName + ", " + acc2.balance + ", " + acc2.accountType + ", " + acc2.currency);
        System.out.println("Video 1: " + vid1.videoID + ", " + vid1.title + ", " + vid1.genre + ", " + vid1.duration + "min, " + vid1.releaseYear + ", " + vid1.director);
        System.out.println("Video 2: " + vid2.videoID + ", " + vid2.title + ", " + vid2.genre + ", " + vid2.duration + "min, " + vid2.releaseYear + ", " + vid2.director);
    }
}
