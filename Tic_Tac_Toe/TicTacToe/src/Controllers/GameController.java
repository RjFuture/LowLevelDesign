package Controllers;

import Modals.Game;
import Modals.Player;
import Startegy.WinningStartegy;

import java.util.List;

public class GameController {

    public Game startGame(int size, List<Player> players , List<WinningStartegy> winnerStartegy)
    {
        return new Game(size,players,winnerStartegy);
    }

    public void display(Game game)
    {
        game.getBoard().display();
    }

}
