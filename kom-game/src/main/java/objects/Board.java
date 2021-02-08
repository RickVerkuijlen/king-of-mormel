package objects;

import lombok.Getter;
import org.apache.commons.lang.RandomStringUtils;

import java.util.List;

@Getter
public class Board {
    public String joinCode;
    public int amountOfRounds;
    public List<Player> playerList;

    public void generateJoinCode() {
        int length = 5;
        boolean useLetters = true;
        boolean useNumbers = true;

        String joinCode = RandomStringUtils.random(length, useLetters, useNumbers);
        this.joinCode = joinCode.toUpperCase();
    }
}
