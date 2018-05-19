package database;

import model.Game;
import model.User;

import java.util.ArrayList;

public interface GameDAO {

    boolean addGame(Game game);
    Game getGameById(int id);
    ArrayList<Game> getGamesByUser(User user);
    ArrayList<Game> getAllGames();

}
