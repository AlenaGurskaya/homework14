import java.util.ArrayList;

public class Game {

    ArrayList<Player> players; //Список зарегестрированных игроков

    public Game() {
        this.players = new ArrayList<>();
    }

    //Метод регистрации игрока
    public void register(Player player) {
        if (!players.contains(player)) { //Если игрока нет в списке зарегестрированных
            players.add(player);     //то, метод его добавляет
        }
    }

    //Метод соревнования между двумя игроками
    public int round(String playerName1, String playerName2) throws NotRegisteredException {
        //Проверка на регистрацию игрока
        if ((findByName(playerName1) == null) || (findByName(playerName2) == null)) {
            if (findByName(playerName1) == null) {
                throw new NotRegisteredException("Игрок " + playerName1 + " не зарегестирован");
            }
            if (findByName(playerName2) == null) {
                throw new NotRegisteredException("Игрок " + playerName2 + " не зарегестирован");
            }
        }
        //Метод должен возвращать одно число — 0 в случае ничьи, 1 в случае победы первого игрока и 2 в случае победы второго игрока.
        Player player1 = findByName(playerName1);
        Player player2 = findByName(playerName2);
        int strength1 = player1.getStrength();
        int strength2 = player2.getStrength();

        if (strength1 > strength2) {
            return 1;
        } else if (strength1 < strength2) {
            return 2;
        } else {
            return 0;
        }
    }

    //Поиск по имени
    public Player findByName(String name) {
        for (Player player : players) {
            if (player.getName().equals(name)) {
                return player;
            }
        }
        return null;
    }

    public ArrayList<Player> findAll() {
        return players;
    }
}

