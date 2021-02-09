package nl.rickverkuijlen.mormel.game.objects.tiles;

import nl.rickverkuijlen.mormel.game.objects.Player;

public interface ITile {
    void addPlayer(Player player);
    void removePlayer(Player player);
}
