package nl.rickverkuijlen.mormel.websocket.controller;

import com.google.gson.Gson;
import nl.rickverkuijlen.mormel.game.objects.Board;
import nl.rickverkuijlen.mormel.game.objects.Owner;
import nl.rickverkuijlen.mormel.game.objects.Player;
import nl.rickverkuijlen.mormel.game.operations.BoardOperations;
import nl.rickverkuijlen.mormel.game.operations.PlayerOperations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import nl.rickverkuijlen.mormel.websocket.messages.WebSocketMessage;

@Controller
public class BoardController {
    @Autowired
    private BoardOperations boardOperations;

    @Autowired
    private PlayerOperations playerOperations;

    private Gson gson = new Gson();

    @MessageMapping("/createBoard")
    @SendTo("/game")
    public WebSocketMessage createBoard(@Payload WebSocketMessage webSocketMessage) {
        Owner owner = gson.fromJson(webSocketMessage.getContent(), Owner.class);

        return WebSocketMessage.builder()
                .content(gson.toJson(boardOperations.createBoard(owner)))
                .build();
    }

    @MessageMapping("/joinBoard/{joinCode}")
    @SendTo("/game/{joinCode}")
    public WebSocketMessage joinBoard(@DestinationVariable String joinCode, @Payload WebSocketMessage webSocketMessage) {
        Player player = gson.fromJson(webSocketMessage.getContent(), Player.class);

        player.setWidMark(playerOperations.determineWidMark(player.getGender()));

        Board board = boardOperations.joinBoard(joinCode, player);

        return WebSocketMessage.builder()
                .content(gson.toJson(board))
                .build();
    }
}
