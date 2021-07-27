import service.GameService;

/**
 * Class Game
 *
 * Realization of Rock, scissors and paper game.
 */
public class Game {
    public static void main(String[] args) {
        new GameService().play();
    }
}
