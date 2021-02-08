package objects.tiles;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;
import objects.Player;

import java.util.ArrayList;
import java.util.List;

@Data
public class BasicTile implements ITile {
    @Setter(AccessLevel.NONE)
    private List<Player> playersOnTile = new ArrayList<>();

    public void addPlayer(Player player) {
        this.playersOnTile.add(player);
    }

    public void removePlayer(Player player) {
        this.playersOnTile.remove(player);
    }
}
