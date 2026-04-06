import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class NoteManager {
    private static final String FILE_NAME = "data.txt";
    private final List<String> lines;

    public NoteManager() {
        this.lines = new ArrayList<>();
        loadFromFile();
    }

    private void loadFromFile() {
        File file = new File(FILE_NAME);
        if (!file.exists()) {
            return;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }

    private void saveToFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (String line : lines) {
                writer.write(line);
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }

    public void viewNote() {
        if (lines.isEmpty()) {
            System.out.println("==== View note ====");
            System.out.println("Note is empty.\n");
            return;
        }

        System.out.println("==== View note ====");
        String separator = "*".repeat(30);
        System.out.println(separator);

        for (int i = 0; i < lines.size(); i++) {
            System.out.println((i + 1) + "| " + lines.get(i));
        }

        System.out.println(separator);
        System.out.println();
    }

    public void editNote(Scanner sc) {
        System.out.println("==== Edit following note ====");

        if (lines.isEmpty()) {
            System.out.println("Note is empty.\n");
            return;
        }

        String separator = "*".repeat(30);
        System.out.println(separator);

        for (int i = 0; i < lines.size(); i++) {
            System.out.println((i + 1) + "| " + lines.get(i));
        }

        System.out.println(separator);

        while (true) {
            System.out.println("1.  Append new line");
            System.out.println("2.  Update at line");
            System.out.println("3.  Delete line");
            System.out.print("Choose an opt: ");

            String choice = sc.nextLine().trim();
            System.out.println();

            switch (choice) {
                case "1":
                    appendLine(sc);
                    break;
                case "2":
                    updateLine(sc);
                    break;
                case "3":
                    deleteLine(sc);
                    break;
                default:
                    System.out.println("Invalid option. Please choose 1-3.\n");
                    continue;
            }
            break;
        }
    }

    private void appendLine(Scanner sc) {
        System.out.print("Input a string for line #" + (lines.size() + 1) + ": ");
        String newLine = sc.nextLine();
        lines.add(newLine);
        System.out.println("Line #" + lines.size() + " is appended to the note.\n");
        saveToFile();
    }

    private void updateLine(Scanner sc) {
        int lineNum = readValidLineNumber(sc, "Update at line: ");
        if (lineNum == -1) {
            return;
        }

        System.out.print("Input a string for line #" + lineNum + ": ");
        String updatedLine = sc.nextLine();
        lines.set(lineNum - 1, updatedLine);
        System.out.println("Line #" + lineNum + " is updated.\n");
        saveToFile();
    }

    private void deleteLine(Scanner sc) {
        int lineNum = readValidLineNumber(sc, "Delete line number: ");
        if (lineNum == -1) {
            return;
        }

        String deletedLine = lines.remove(lineNum - 1);
        System.out.println("Line #" + lineNum + " is deleted.\n");
        saveToFile();
    }

    private int readValidLineNumber(Scanner sc, String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = sc.nextLine().trim();

            try {
                int lineNum = Integer.parseInt(input);
                if (lineNum < 1 || lineNum > lines.size()) {
                    System.out.println("Please input a valid line number (1-" + lines.size() + ").");
                    continue;
                }
                return lineNum;
            } catch (NumberFormatException e) {
                System.out.println("Please input a valid number.");
            }
        }
    }
}

public class ex4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        NoteManager manager = new NoteManager();

        while (true) {
            System.out.println("==== Menu ====");
            System.out.println("1.  View my note");
            System.out.println("2.  Edit");
            System.out.println("3.  Quit");
            System.out.print("Choose an option: ");

            String choice = sc.nextLine().trim();
            System.out.println();

            switch (choice) {
                case "1":
                    manager.viewNote();
                    break;
                case "2":
                    manager.editNote(sc);
                    break;
                case "3":
                    System.out.println("BYE BYE!!");
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid option. Please choose 1-3.\n");
                    break;
            }
        }
    }
}
