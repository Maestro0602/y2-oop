import java.util.*;
class video{
    String title;
    String uploader;
    String type;
    float length;

    video(String title, String uploader, String type, float length) {
        this.title = title;
        this.uploader = uploader;
        this.type = type;
        this.length = length;
        }
}

public class ex4 {
    
    static class vidManager{
        video[] vids = new video [100];
        int count = 0;
        Scanner sc = new Scanner(System.in);

        public void viewVideo(){
            System.out.println("===============================================================================================");
            System.out.printf("| %-40s | %-20s | %-10s | %-10s |\n", "Title", "Uploader", "Type", "Length");
            System.out.println("===============================================================================================");
            for (int i = 0; i < count; i++) {
                video v = vids[i];
                System.out.printf("| %-40s | %-20s | %-10s | %-10.2f |\n", v.title, v.uploader, v.type, v.length);
            }
            System.out.println("===============================================================================================");
        }

        public void addVideo(){
            System.out.println("==== Add a new video ====");
            System.out.print("Title: "); 
            String title = sc.nextLine();

            System.out.print("Uploader: "); 
            String uploader = sc.nextLine();

            System.out.print("Type: "); 
            String type = sc.nextLine();

            System.out.print("Length (in minutes): "); 
            float length = sc.nextFloat(); 

            vids[count++] = new video(title, uploader, type, length);
            System.out.println("Video added.");
        }

        public void search() {
            System.out.print("Input title: ");
            String keyword = sc.next().toLowerCase();
            int found = 0;
            for (int i = 0; i < count; i++) {
                if (vids[i].title.toLowerCase().contains(keyword)) {
                    System.out.println((++found) + ". " + vids[i].title + " by " + vids[i].uploader);
                }
            }
            if (found == 0) System.out.println("0 video found.");
            else System.out.println(found + " video(s) found.");
        }

        public void run(){
            vids[count++] = new video("404(New Era)","KiiKii","Music Video",3);
            vids[count++] = new video("Going Seventeen - EP 67","Seventeen","Comedy video",35);
            vids[count++] = new video("I tried every fastfood chain","Dylan Huynh","Food Vlog",30);
            
            int choice;
            do{
                System.out.println("==== Video Search ====");
                System.out.println("1. Search");
                System.out.println("2. View all videos");
                System.out.println("3. Add a new video");
                System.out.println("4. Exit");
                System.out.print("Choose an option: ");
                choice = sc.nextInt();
                sc.nextLine(); // Consume the leftover newline

                switch (choice) {
                    case 1: search(); 
                    break;
                    case 2: viewVideo(); 
                    break;
                    case 3: addVideo(); 
                    break;
                    case 4: System.out.println("Exiting..."); break;
                    default: System.out.println("Invalid option. Try again.");
                } 
            } while (choice != 4);
        }
    }

    public static void main(String[] args) {
        vidManager vm = new vidManager();
        vm.run();
    }
}
