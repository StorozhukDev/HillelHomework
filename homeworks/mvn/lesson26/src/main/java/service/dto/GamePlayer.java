package service.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * Class GamePlayer
 *
 * @author Oleksandr Storozhuk
 * @version 1.0.0
 * created on 02.07.2021
 */
@Getter
@Setter
@Accessors(chain = true)
@NoArgsConstructor
public class GamePlayer {
    private String name;
    private int score;
}
