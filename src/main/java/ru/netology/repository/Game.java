package ru.netology.repository;

import ru.netology.domain.NotRegisteredException;
import ru.netology.domain.Player;

import java.util.LinkedList;
import java.util.List;

public class Game {
    private List<Player> players = new LinkedList<>();

    public Player findByName(String name) {
        for (Player player : players) {
            if (player.getName().equals(name)) {
                return player;
            }
        }
        return null;
    }

    public void registerAll(List<Player> players) {
        this.players.addAll(players);
    }

    public List<Player> findAll() {
        return players;
    }

    public int round(String firstPlayer, String secondPlayer) {
        Player player1 = findByName(firstPlayer);
        Player player2 = findByName(secondPlayer);
        if (findByName(firstPlayer) == null) {
            throw new NotRegisteredException(firstPlayer);
        }
        if (findByName(secondPlayer) == null) {
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
