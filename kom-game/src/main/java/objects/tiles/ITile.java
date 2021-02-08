package objects.tiles;

import objects.Player;

import java.util.List;

public interface ITile {
    void addPlayer(Player player);
    void removePlayer(Player player);
}
