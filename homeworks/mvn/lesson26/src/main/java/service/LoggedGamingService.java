package service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import service.dto.types.Pick;
import service.dto.types.RoundOutcome;

/**
 * @author Oleksandr Storozhuk
 * @version 1.0.0
 * created on 02.07.2021
 *
 * Extended version of GamingService that logs important information.
 *
 * There are 2 types of logs:
 *  - Each game information         /log/GamesLog/log_[playerName]_[date].log
 *  - Game results                  /log/Results/results.log
 */
public class LoggedGamingService extends GamingService {
    private static Logger gameLog;
    private static Logger resLog;

    @Override
    protected void configure() {
        super.configure();

        MDC.put("player.name",  player.getName());
        resLog = LoggerFactory.getLogger("logger.results");
        gameLog = LoggerFactory.getLogger("logger.games");

        gameLog.info("Player {} joined the game.", this.player.getName());
    }

    @Override
    protected RoundOutcome playRound(Pick i1, Pick i2) {
        RoundOutcome round = super.playRound(i1, i2);
        gameLog.info("Round {}/{} : {} picks {}, {} picks {} -> {}", playedRounds+1, totalRounds, player.getName(),
                i1.name(), computer.getName(), i2.name(), round.name());
        return round;
    }

    @Override
    protected void showResults() {
        super.showResults();
        gameLog.info("Player {} left the game.", this.player.getName());
        if(totalRounds != playedRounds) {
            gameLog.warn("Player selected {} games, {} games played, {} games left.",
                    totalRounds, playedRounds, totalRounds-playedRounds);
        }
        resLog.info("{} vs {}, Rounds played: {}/{}, {} ({}:{})", player.getName(), computer.getName(),
                playedRounds, totalRounds, draw()?"DRAW":winner().getName(), player.getScore(), computer.getScore());
    }
}
