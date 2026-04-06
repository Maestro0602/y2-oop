public class ex4 {
    public static void main(String[] args) {
        System.out.printf("%3s", " ");
        for (int j = 1; j <= 10; j++) {
            System.out.printf("|%3d", j);
        }
        System.out.println("|");
        for (int i = 0; i <= 10; i++) {
            System.out.print("---+");
        }
        System.out.println();
        for (int i = 1; i <= 5; i++) {
            System.out.printf("%3d", i);
            for (int j = 1; j <= 10; j++) {
                System.out.printf("|%3d", i * j);
            }
            System.out.println("|");
        }

        System.out.println();

        String[][] data = {
            {"Country",        "Name",    "Profession",        "Age"},
            {"Germany",        "Michael", "Computer Engineer", "19"},
            {"England",        "Robert",  "Artist",            "34"},
            {"United Kingdom", "Julia",   "Designer",          "42"},
            {"United Staates", "Jo",      "Actor",             "21"}
        };
        String divider = "-------------------------------------------------------";
        System.out.println(divider);
        for (String[] row : data) {
            System.out.printf("| %-15s| %-8s| %-18s| %3s |%n",
                row[0], row[1], row[2], row[3]);
                 System.out.println(divider);
        }
    }
}
