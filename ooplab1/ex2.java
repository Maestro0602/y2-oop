public class ex2 {
    public static void main(String[] args) {
        System.out.printf("%-30s %s%n", "\\n", "Line Break.");
        System.out.printf("%-30s %s%n", "\\t", "Tabulation.");
        System.out.printf("%-30s %s%n", "\\'", "Single Quote.");
        System.out.printf("%-30s %s%n", "\\\"", "Double Quote.");
        System.out.printf("%-30s %s%n", "\\", "\\ Sign.");
        System.out.printf("%-30s %s%n", "\\\\", "\\\\ Sign.");
        System.out.printf("%-30s %s%n", "//", "Line Comment.");
        System.out.printf("%-30s %s%n", "/* ... */", "Block Comment.");
        System.out.println();
        System.out.println("\"\"\"");
        System.out.printf("%-30s %s%n"," ",  "Text block.");
        System.out.println("\"\"\"");
    }
}

