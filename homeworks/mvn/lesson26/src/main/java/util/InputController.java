package util;

import java.util.Scanner;

/**
 * Class InputController
 *
 * @author Oleksandr Storozhuk
 * @version 1.0.0
 * created on 02.07.2021
 *
 * Contains methods to get correct input from console.
 */
public class InputController {
    private static final Scanner sc = new Scanner(System.in);

    public static int intValue(int minVal, int maxVal, String inputMsg, String badInputMsg) {
        int tmp;
        do {
            System.out.print(inputMsg + " (" + minVal + "-" + maxVal + "):");
            if(sc.hasNextInt()) {
                tmp = sc.nextInt();
                if(tmp >= minVal && tmp <= maxVal) {
                    return tmp;
                }
            } else {
                sc.next(); // skip bad input
            }
            System.out.println(badInputMsg);
        } while(true);
    }

    public static String stringLine(int maxLen, String inputMsg, String badInputMsg) {
        String tmp;
        do {
            System.out.print(inputMsg + " (" + maxLen + "):");
            tmp = sc.nextLine();
            if(tmp.length() <= maxLen) {
                return tmp;
            }
            System.out.println(badInputMsg);
        } while(true);
    }
}
