package ru.netology.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.NotRegisteredException;
import ru.netology.domain.Player;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {
    private Game game = new Game();
    private Player player1 = new Player(1, "Boris", 25);
    private Player player2 = new Player(2, "Max", 18);
    private Player player3 = new Player(3, "Olga", 21);
    private Player player4 = new Player(4, "Vladislav", 30);
    private Player player5 = new Player(5, "Maria", 15);
    private Player player6 = new Player(6, "Oleg", 25);

    @BeforeEach
    public void addPlayers() {
        game.registerAll(List.of(player1, player2, player3, player4, player5, player6));
    }

    @Test
    public void shouldFindPlayerByName() {
        assertEquals(player4, game.findByName("Vladislav"));
    }


    @Test
    public void shouldFindPlayerByNonexistentName() {
        assertNull(game.findByName("Irina"));
    }

    @Test
    public void shouldFindAllPlayers() {
        assertEquals(List.of(player1, player2, player3, player4, player5, player6), game.findAll());
    }

    @Test
    public void shouldCatchExceptionForPlayer1() {
        assertThrows(NotRegisteredException.class, () -> game.round("Irina", "Olga"));
    }

    @Test
    public void shouldCatchExceptionForPlayer2() {
        assertThrows(NotRegisteredException.class, () -> game.round("Max", "Irina"));
    }

    @Test
    public void shouldCatchExceptionForBothPlayers() {
        assertThrows(NotRegisteredException.class, () -> game.round("Irina", "Sam"));
    }

    @Test
    public void shouldReturnWinnerPlayer1() {
        assertEquals(1, game.round("Olga", "Max"));
    }

    @Test
    public void shouldReturnWinnerPlayer2() {
        assertEquals(2, game.round("Boris", "Vladislav"));
    }

    @Test
    public void shouldReturnDraw() {
        assertEquals(0, game.round("Oleg", "Boris"));
    }

}