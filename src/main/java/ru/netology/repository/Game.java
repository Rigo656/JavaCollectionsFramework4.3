package ru.netology.repository;

import ru.netology.domain.NotRegisteredException;
import ru.netology.domain.Player;

import java.util.HashMap;
import java.util.Map;

public class Game {
    private Map<String,Player> players = new HashMap<>();

    public void register(Player player) {
        this.players.put(player.getName(),player);
    }

    public int round(String firstPlayer, String secondPlayer) {
        Player player1 = players.get(firstPlayer);
        Player player2 = players.get(secondPlayer);
        if (player1 == null) {
            throw new NotRegisteredException(firstPlayer);
        }
        if (player2 == null) {
            throw new NotRegisteredException(secondPlayer);
        }
        if (player1.getStrength() > player2.getStrength()) {
            return 1;
        }
        if (player1.getStrength() < player2.getStrength()) {
            return 2;
        }
        return 0;
    }

}
