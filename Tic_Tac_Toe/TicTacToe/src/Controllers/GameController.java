package Controllers;

import Modals.Game;
import Modals.Player;
import Modals.enums.GameState;
import Startegy.WinningStartegy;

import java.util.List;

public class GameController {

    public Game startGame(int size, List<Player> players , List<WinningStartegy> winnerStartegy)
    {
        return Game.getBuilder().setSize(size).setPlayers(players).setWinningStartegies(winnerStartegy).build();
    }

    public void display(Game game)
    {
        game.getBoard().display();
    }

    public GameState getGameState(Game game)
    {
        return game.getGameState();
    }

    public void makeMove(Game game)
    {
         game.makeMove(game);
    }

}
