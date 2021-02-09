package nl.rickverkuijlen.mormel.websocket.messages;

import lombok.Builder;
import lombok.Data;

import java.sql.Timestamp;

@Data
@Builder
public class GameMessage {
    private String sender;
    private String content;
    @Builder.Default private Timestamp timestamp = new Timestamp(System.currentTimeMillis());
}
