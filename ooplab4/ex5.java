import java.util.*;

class song {
    String title, artist, length;
    double price;

    song(String title, String artist, String length, double price) {
        this.title = title;
        this.artist = artist;
        this.length = length;
        this.price = price;
    }
}

class Album {
    String title, genre;
    ArrayList<song> songs = new ArrayList<>();

    Album(String title, String genre) {
        this.title = title;
        this.genre = genre;
    }
}

public class ex5 {

    static class MusicManager {
        ArrayList<Album> store = new ArrayList<>();
        Scanner sc = new Scanner(System.in);

        public void viewStore() {
            if (store.isEmpty()) { System.out.println("No albums yet."); return; }
            System.out.println("====== Music Store ======");
            
            for (Album a : store) {
                System.out.println("Album: " + a.title + " | Genre: " + a.genre);
                System.out.println("======================================================================");
                
                if (a.songs.isEmpty()) {
                    System.out.println("There are no songs in this album yet");
                } else {
                    int i = 1;
                    
                    for (song s : a.songs) {
                        System.out.printf("  | %d | %-20s | %-10s | %-10s | $%.2f |\n",
                        i++, s.title, s.artist, s.length, s.price);
                    }
                }
                System.out.println("======================================================================");
            }
        }

        public void createAlbum() {
            System.out.println("===== Create new album =====");
            System.out.print("Album title: "); 
            String title = sc.nextLine();

            System.out.print("Genre: ");       
            String genre = sc.nextLine();

            store.add(new Album(title, genre));
            System.out.println("Album created!");
        }

        public void addSong() {
            if (store.isEmpty()) { System.out.println("No albums yet! Create one first."); return; }

            System.out.println("===== Add a new song =====");
            System.out.println("Select following album:");
            for (int i = 0; i < store.size(); i++)
                System.out.println((i + 1) + ". " + store.get(i).title);

            System.out.print("Choose album: "); int idx = sc.nextInt() - 1; sc.nextLine();

            System.out.print("Song title: "); 
            String title  = sc.nextLine();

            System.out.print("artist: ");     
            String artist = sc.nextLine();

            System.out.print("Length: ");     
            String length = sc.nextLine();

            System.out.print("Price: ");      
            double price  = sc.nextDouble(); sc.nextLine();

            store.get(idx).songs.add(new song(title, artist, length, price));
            System.out.println("A new song added to the album!");
        }

        public void run() {
            
            Album a1 = new Album("Piss in the wind", "Alternative pop");
            a1.songs.add(new song("LOVE YOU LESS",    "Joji", "3:21 mins", 20));
            a1.songs.add(new song("Pixelated Kisses","Joji", "1:50 mins", 20));
            store.add(a1);

            store.add(new Album("wannabewithu", "bedroom pop")); 

            Album a3 = new Album("CINEMA", "Indie pop");
            a3.songs.add(new song("Calling U Back", " The Marías", "3:19 mins", 10));
            store.add(a3);

            int choice;
            do {
                System.out.println("\n====== Menu ======");
                System.out.println("1. View a music store");
                System.out.println("2. Add a song");
                System.out.println("3. Create an album");
                System.out.println("4. Quit");
                System.out.print("Choose an option: ");
                choice = sc.nextInt();
                sc.nextLine(); // clear buffer

                switch (choice) {
                    case 1: viewStore();   
                    break;
                    case 2: addSong();     
                    break;
                    case 3: createAlbum(); 
                    break;
                    case 4: System.out.println("Exiting..."); 
                    break;
                    default: System.out.println("Invalid option. Try again.");
                }
            } while (choice != 4);
        }
    }

    public static void main(String[] args) {
        MusicManager mm = new MusicManager();
        mm.run();
    }
}