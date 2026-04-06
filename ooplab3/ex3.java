import java.util.Scanner;

public class ex3 {
    static Scanner sc = new Scanner(System.in);
    
    public static void main(String[] args) {
        mainMenu();
    }
    
    public static void mainMenu() {
        int choice;
        while (true) {
            System.out.println("Phone Setting:");
            System.out.println("1. General                  >");
            System.out.println("2. Wi-Fi                    >");
            System.out.println("3. Bluetooth                >");
            System.out.println("4. Mobile Data              >");
            System.out.println("5. Hotspot                  >");
            System.out.println("6. Notification             >");
            System.out.println("0. Quit");
            System.out.print("Choose an option: ");
            choice = sc.nextInt();
            
            switch (choice) {
                case 1:
                    generalMenu();
                    break;
                case 2:
                    wifiMenu();
                    break;
                case 3:
                    bluetoothMenu();
                    break;
                case 4:
                    mobileDataMenu();
                    break;
                case 5:
                    hotspotMenu();
                    break;
                case 6:
                    notificationMenu();
                    break;
                case 0:
                    System.out.println("Goodbye!");
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid choice");
            }
            System.out.println();
        }
    }
    
    public static void generalMenu() {
        int choice;
        while (true) {
            System.out.println("General:");
            System.out.println("1. About                    >");
            System.out.println("2. Software update          >");
            System.out.println("3. Storage                  >");
            System.out.println("0. Back");
            System.out.print("Choose an option: ");
            choice = sc.nextInt();
            
            switch (choice) {
                case 1:
                    System.out.println("General > About:");
                    System.out.println("Name                 iPhone");
                    System.out.println("Model                IXs");
                    System.out.println("Version              18.5");
                    System.out.println("0. Back");
                    sc.nextInt();
                    break;
                case 2:
                    System.out.println("General > Software update:");
                    System.out.println("======================");
                    System.out.println("Software is up to date");
                    System.out.println("======================");
                    System.out.println("0. Back");
                    sc.nextInt();
                    break;
                case 3:
                    System.out.println("Title:");
                    System.out.println("==============================");
                    System.out.println("The Feature is not available");
                    System.out.println("==============================");
                    System.out.println("0. Back");
                    sc.nextInt();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Invalid choice");
            }
            System.out.println();
        }
    }
    
    public static void wifiMenu() {
        int choice;
        while (true) {
            System.out.println("Wi-Fi:");
            System.out.println("Status                      On");
            System.out.println("Network                     I-Coffee");
            System.out.println("1. Other networks           >");
            System.out.println("0. Back");
            System.out.print("Choose an option: ");
            choice = sc.nextInt();
            
            switch (choice) {
                case 1:
                    wifiOtherNetworks();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Invalid choice");
            }
            System.out.println();
        }
    }
    
    public static void wifiOtherNetworks() {
        int choice;
        while (true) {
            System.out.println("Wi-Fi > Other networks:");
            System.out.println("Bayon coffee             *****");
            System.out.println("Angkor coffee            **");
            System.out.println("Brown coffee             ****");
            System.out.println("Koi                      *");
            System.out.println("0. Back");
            System.out.print("Choose an option: ");
            choice = sc.nextInt();
            
            if (choice == 0) {
                return;
            } else {
                System.out.println("Connecting...");
            }
            System.out.println();
        }
    }
    
    public static void bluetoothMenu() {
        int choice;
        while (true) {
            System.out.println("Bluetooth:");
            System.out.println("Status                      Off");
            System.out.println("0. Back");
            System.out.print("Choose an option: ");
            choice = sc.nextInt();
            
            if (choice == 0) {
                return;
            } else {
                System.out.println("Invalid choice");
            }
            System.out.println();
        }
    }
    
    public static void mobileDataMenu() {
        int choice;
        while (true) {
            System.out.println("Mobile Data:");
            System.out.println("Status                      On");
            System.out.println("0. Back");
            System.out.print("Choose an option: ");
            choice = sc.nextInt();
            
            if (choice == 0) {
                return;
            } else {
                System.out.println("Invalid choice");
            }
            System.out.println();
        }
    }
    
    public static void hotspotMenu() {
        int choice;
        while (true) {
            System.out.println("Hotspot:");
            System.out.println("Status                      Off");
            System.out.println("0. Back");
            System.out.print("Choose an option: ");
            choice = sc.nextInt();
            
            if (choice == 0) {
                return;
            } else {
                System.out.println("Invalid choice");
            }
            System.out.println();
        }
    }
    
    public static void notificationMenu() {
        int choice;
        while (true) {
            System.out.println("Notification:");
            System.out.println("Status                      On");
            System.out.println("0. Back");
            System.out.print("Choose an option: ");
            choice = sc.nextInt();
            
            if (choice == 0) {
                return;
            } else {
                System.out.println("Invalid choice");
            }
            System.out.println();
        }
    }
}
