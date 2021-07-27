package service;

import service.dto.GamePlayer;
import service.dto.GameRound;
import service.dto.types.Pick;
import service.dto.types.RoundOutcome;
import util.InputController;
import util.RandomGenerator;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Class GamingService
 *
 * @author Oleksandr Storozhuk
 * @version 1.0.0
 * created on 02.07.2021
 *
 * "Rock, scissors, paper" console game engine with localization support.
 * By default, localization set as system. It can be configured by setLocale() method.
 */
public class GamingService {
    protected final int GAMES_MAX = 100;
    protected final int USERNAME_LEN_MAX = 50;

    protected GamePlayer computer, player;
    protected int totalRounds, playedRounds;

    // set localization as default
    protected Locale loc = Locale.getDefault();
    protected ResourceBundle rb = ResourceBundle.getBundle("MessagesBundle", loc);

    /* Set player's name and game rounds count from console input */
    protected void configure() {
        player = new GamePlayer().setName(
                InputController.stringLine(USERNAME_LEN_MAX, rb.getString("enterYourName"), rb.getString("badInput")));
        computer = new GamePlayer().setName(rb.getString("computerName"));
        totalRounds = InputController.intValue(0, GAMES_MAX, rb.getString("gamesToPlay"), rb.getString("badInput"));
    }

    /* Play one game round and return result for the first player */
    protected RoundOutcome playRound(Pick i1, Pick i2) {
        RoundOutcome result = GameRound.getResult(i1, i2);
        switch (result) {
            case WIN -> player.setScore(player.getScore()+1);
            case LOSE -> computer.setScore(computer.getScore()+1);
        }
        return result;
    }

    /* Check players scores for a draw */
    protected boolean draw() {
        return player.getScore() == computer.getScore();
    }

    /* Get winner if not a draw */
    protected GamePlayer winner() {
        return player.getScore() > computer.getScore()?player:computer;
    }

    /* Show players stats */
    protected void showResults() {
        String gameOutcome = draw()?rb.getString("DRAW"):rb.getString("winner").concat(winner().getName());
        System.out.printf(rb.getString("gameResults"), playedRounds, totalRounds,
                gameOutcome, player.getScore(), computer.getScore());
    }

    /* Play the game */
    public void play() {
        Pick playerPicks, computerPicks;
        RoundOutcome round;
        int input;

        System.out.println(rb.getString("greeting"));
        this.configure();

        System.out.println(rb.getString("gameStarted"));
        for(playedRounds = 0; playedRounds < totalRounds; playedRounds++) {
            input = InputController.intValue(0, 3, rb.getString("roundTurn"), rb.getString("badInput"));
            if(input == 0) { // player terminates the game
                System.out.println(rb.getString("terminatedByPlayer"));
                break;
            }

            playerPicks = Pick.values()[input-1];
            computerPicks = Pick.values()[RandomGenerator.getInt(0,2)];
            round = playRound(playerPicks, computerPicks);
            System.out.printf(rb.getString("roundResults"), player.getName(), rb.getString(playerPicks.name()),
                    computer.getName(), rb.getString(computerPicks.name()), rb.getString(round.name()));
        }

        this.showResults();
    }

    /* Set console output localization */
    public void setLocale(String lang, String country) {
        loc = new Locale(lang, country);
        rb = ResourceBundle.getBundle("MessagesBundle", loc);
    }
}
