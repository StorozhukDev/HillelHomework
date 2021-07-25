package util;

import java.util.Random;

/**
 * Class RandomGenerator
 *
 * @author Oleksandr Storozhuk
 * @version 1.0.0
 * created on 02.07.2021
 *
 * Contains methods to get random values within needed diapason.
 */
public class RandomGenerator {
    static Random random = new Random();

    public static int getInt(int min, int max) {
        return (random.nextInt(max - min + 1) + min);
    }
}
