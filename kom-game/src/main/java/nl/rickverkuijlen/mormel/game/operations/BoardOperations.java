package nl.rickverkuijlen.mormel.game.operations;

import lombok.Data;
import nl.rickverkuijlen.mormel.game.objects.Board;
import nl.rickverkuijlen.mormel.game.objects.Owner;
import nl.rickverkuijlen.mormel.game.objects.Player;
import org.apache.commons.lang3.RandomStringUtils;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Data
public class BoardOperations {

    private static List<Board> allBoards = new ArrayList<>();

    public Board createBoard(Owner owner) {
        Board board = Board.builder()
                .owner(owner)
                .amountOfRounds(0)
                .playerList(new ArrayList<>())
                .joinCode(generateJoinCode())
                .build();
        allBoards.add(board);
        System.out.println(allBoards.size());
        return board;
    }

    public Board joinBoard(String joinCode, Player player) {
        Board board = allBoards.stream()
                        .filter(x -> x.joinCode.equals(joinCode))
                        .findFirst()
                        .orElse(null);

        if(board != null) {
            board.addPlayer(player);
            return board;
        } else {
            return null;
        }
    }

    @NotNull
    private static String generateJoinCode() {
        int length = 5;
        boolean useLetters = true;
        boolean useNumbers = true;

        String joinCode = RandomStringUtils.random(length, useLetters, useNumbers).toUpperCase();

        if(allBoards.stream().anyMatch(x -> x.joinCode.equals(joinCode))) {
            generateJoinCode();
        }
        return joinCode;
    }
}
