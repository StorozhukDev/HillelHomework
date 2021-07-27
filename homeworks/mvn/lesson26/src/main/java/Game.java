import service.GamingService;
import service.LoggedGamingService;

/**
 * @author Oleksandr Storozhuk
 * @version 1.0.0
 * created on 02.07.2021
 *
 * "Rock, scissors, paper" console game with localization and logging support.
 * Localization may be set by program arguments ("java -jar HW26-1.0-shaded.jar RU ru").
 */
public class Game {
    public static void main(String[] args) {
        GamingService game = new LoggedGamingService();
        if(args.length == 2) {
            game.setLocale(args[0], args[1]);
        }
        game.play();
    }
}
