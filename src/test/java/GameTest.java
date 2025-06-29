import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class GameTest {

    Player player1 = new Player(1, "Алексей", 56);
    Player player2 = new Player(2, "Николай", 52);
    Player player3 = new Player(3, "Владимир", 84);
    Player player4 = new Player(4, "Петр", 56);

    //Проверка метода регистрации игроков, если список пуст
    @Test
    public void shouldBeRegisteredIfListEmpty() {
        Game game = new Game();

        game.register(player1);

        ArrayList<Player> expected = new ArrayList<>();
        expected.add(player1);

        ArrayList<Player> actuale = game.findAll();

        Assertions.assertEquals(expected, actuale);
    }

    //Проверка метода регистрации игроков, если список не пуст
    @Test
    public void shouldBeRegisteredIfListNotEmpty() {
        Game game = new Game();

        game.register(player1);
        game.register(player2);

        ArrayList<Player> expected = new ArrayList<>();
        expected.add(player1);
        expected.add(player2);

        ArrayList<Player> actuale = game.findAll();

        Assertions.assertEquals(expected, actuale);
    }

    //Проверка метода регистрации игроков, если список не пуст и игрок зарегистрирован
    @Test
    public void shouldBeRegisteredIfListNotEmptyAndPlayerRegistered() {
        Game game = new Game();

        game.register(player1);
        game.register(player1);

        ArrayList<Player> expected = new ArrayList<>();
        expected.add(player1);

        ArrayList<Player> actuale = game.findAll();

        Assertions.assertEquals(expected, actuale);
    }

    //Метод соревнования: Если первый игрок не зарегистрирован
    @Test
    public void shouldExceptionIfFirstPlayerNotRegistered() {
        Game game = new Game();

        game.register(player2);

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("Алексей", "Николай");
        });
    }

    //Метод соревнования: Если второй игрок не зарегистрирован
    @Test
    public void shouldExceptionIfSecondPlayerNotRegistered() {
        Game game = new Game();

        game.register(player1);

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("Алексей", "Николай");
        });
    }

    //Метод соревнования: Если обы игрока не зарегистрированы
    @Test
    public void shouldExceptionIfBothPlayersNotRegistered() {
        Game game = new Game();

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("Алексей", "Николай");
        });
    }

    //Метод соревнования: Если обы игрока зарегистрированы, выигрывает 1 игрок
    @Test
    public void shouldExceptionIfBothPlayersRegisteredAndFirstPlayerWin() {
        Game game = new Game();

        game.register(player1);
        game.register(player2);

        int expected = 1;
        int actuale = game.round("Алексей", "Николай");

        Assertions.assertEquals(expected, actuale);
    }

    //Метод соревнования: Если обы игрока зарегистрированы, выигрывает 2 игрок
    @Test
    public void shouldExceptionIfBothPlayersRegisteredAndSecondPlayerWin() {
        Game game = new Game();

        game.register(player2);
        game.register(player3);

        int expected = 2;
        int actuale = game.round("Николай", "Владимир");

        Assertions.assertEquals(expected, actuale);
    }

    //Метод соревнования: Если обы игрока зарегистрированы, ничья
    @Test
    public void shouldExceptionIfBothPlayersRegisteredAndDraw() {
        Game game = new Game();

        game.register(player1);
        game.register(player4);

        int expected = 0;
        int actuale = game.round("Алексей", "Петр");

        Assertions.assertEquals(expected, actuale);
    }
}
