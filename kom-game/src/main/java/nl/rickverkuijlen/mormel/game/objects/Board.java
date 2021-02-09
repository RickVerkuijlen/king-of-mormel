package nl.rickverkuijlen.mormel.game.objects;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Board{
    public String joinCode;
    public int amountOfRounds;
    public List<Player> playerList;
    public Owner owner;
}
