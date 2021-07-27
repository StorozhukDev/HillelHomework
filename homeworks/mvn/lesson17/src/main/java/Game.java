import service.LoggedGameService;

/**
 * Class Game
 *
 * Realization of Rock, scissors and paper game.
 * Write results to log files.
 * See more info about log structure at ./service/impl
 */
public class Game {
    public static void main(String[] args) {
        new LoggedGameService().play();
    }
}
