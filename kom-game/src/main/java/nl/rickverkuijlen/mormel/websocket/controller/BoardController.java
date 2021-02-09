package nl.rickverkuijlen.mormel.websocket.controller;

import com.google.gson.Gson;
import nl.rickverkuijlen.mormel.game.objects.Owner;
import nl.rickverkuijlen.mormel.game.operations.BoardOperations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import nl.rickverkuijlen.mormel.websocket.messages.GameMessage;

@Controller
public class BoardController {
    @Autowired
    private BoardOperations boardOperations;

    private final static String SENDER = "Server";

    private Gson gson = new Gson();

    @MessageMapping("/createBoard")
    @SendTo("/game")
    public GameMessage createBoard(@Payload GameMessage gameMessage) {
        Owner owner = gson.fromJson(gameMessage.getContent(), Owner.class);

        boardOperations.createBoard(owner);

        return GameMessage.builder()
                .sender(SENDER)
                .content(gson.toJson(boardOperations.getBoard()))
                .build();
    }
}
