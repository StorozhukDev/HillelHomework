package service.dto;

import service.dto.types.Pick;
import service.dto.types.RoundOutcome;

import static service.dto.types.RoundOutcome.*;

/**
 * Class GameRound
 *
 * @author Oleksandr Storozhuk
 * @version 1.0.0
 * created on 02.07.2021
 */
public class GameRound {
    public final static RoundOutcome[][] resultsTable = new RoundOutcome[][] {
            {DRAW, WIN, LOSE},
            {LOSE, DRAW, WIN},
            {WIN, LOSE, DRAW}
    };

    public static RoundOutcome getResult(Pick i1, Pick i2) {
        return resultsTable[i1.ordinal()][i2.ordinal()];
    }
}
