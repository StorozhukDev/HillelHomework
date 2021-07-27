import service.AtmService;

/**
 * Write multithreaded mini application (Automatic Teller Machine).
 * Each thread (client) can put and take money from ATM.
 */
public class Main {
    public static void main(String[] args) {
        AtmService.begin();
    }
}
