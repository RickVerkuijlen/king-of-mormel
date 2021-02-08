package objects.tiles;

import objects.Player;

import java.util.List;

public class Waterfall extends BasicTile {
    private List<Player> allPlayers;

    public void passOn() {
        List<Player> temp = this.allPlayers;
        for (Player player : this.allPlayers) {
            this.allPlayers.remove(player);
        }
        this.allPlayers = temp;
    }
}
