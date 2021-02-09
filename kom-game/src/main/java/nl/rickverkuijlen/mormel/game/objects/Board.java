package nl.rickverkuijlen.mormel.game.objects;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Board{
    public String joinCode;
    public int amountOfRounds;

    @Setter(AccessLevel.NONE)
    public List<Player> playerList;
    public Owner owner;

    public void addPlayer(Player player) {
        this.playerList.add(player);
    }

    public void removePlayer(Player player) {
        this.playerList.remove(player);
    }
}
