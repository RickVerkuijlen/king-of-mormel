package nl.rickverkuijlen.mormel.game.operations;

import lombok.Data;
import nl.rickverkuijlen.mormel.game.objects.Board;
import nl.rickverkuijlen.mormel.game.objects.Owner;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Component;

@Component
@Data
public class BoardOperations {

    private Board board;

    public void createBoard(Owner owner) {
        board = Board.builder()
                .owner(owner)
                .amountOfRounds(0)
                .joinCode(generateJoinCode())
                .build();
    }

    private static String generateJoinCode() {
        int length = 5;
        boolean useLetters = true;
        boolean useNumbers = true;

        return RandomStringUtils.random(length, useLetters, useNumbers).toUpperCase();
    }
}
