package lab7;
import java.util.concurrent.ThreadLocalRandom;

abstract class NumberRandomizer {
    abstract int randomizeInBetween(int min, int max);
    abstract int[] randomizeUniqueInBetween(int min, int max, int amount);
}

class RNG extends NumberRandomizer {

    @Override
    int randomizeInBetween(int min, int max) {
        return ThreadLocalRandom.current().nextInt(min, max + 1);
    }

    @Override
    int[] randomizeUniqueInBetween(int min, int max, int amount) {

        int[] arr = new int[amount];

        for (int i = 0; i < amount; i++) {
            arr[i] = ThreadLocalRandom.current().nextInt(min, max + 1);
        }

        return arr;
    }
}

public class ex2 {

    public static void main(String[] args) {

        RNG rng = new RNG();

        int num = rng.randomizeInBetween(0, 99);
        System.out.println("Random number: " + num);

        int[] arr = rng.randomizeUniqueInBetween(0, 99, 67);

        System.out.println("Numbers:");

        for (int x : arr) {
            System.out.print(x + " ");
        }
    }
}