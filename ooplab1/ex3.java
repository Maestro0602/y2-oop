public class ex3 {
    public static void main(String[] args) {
        for (int i = 8; i >= 0; i--) {
            for (int j = 0; j < 9-i; j++) 
                System.out.print(" ");  
            for (int j = 0; j < 2* i -1; j++) System.out.print("*");
            System.out.println();
        }

        System.out.println();

        int width = 15, height = 16;
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (i == 0 || i == height - 1 || j == 0 || j == width - 1)
                    System.out.print("*");
                else
                    System.out.print(" ");
            }
            System.out.println();
        }

        System.out.println();

        for (int i = 1; i <= 5; i++) {
            for (int j = i; j <= i + 4; j++) {
                System.out.printf("%2d", j);
            }
            System.out.println();
        }
    }
}
