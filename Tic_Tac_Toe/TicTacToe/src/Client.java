import Controllers.GameController;
import Modals.Game;
import Modals.Player;
import Startegy.WinningStartegy;

import java.util.ArrayList;
import java.util.List;

public class Client {

    public static void main(String args[]) {

        int size = 3;
        List<Player> players = new ArrayList<>();
        List<WinningStartegy> winningStartegies = new ArrayList<>();

        GameController gameController = new GameController();

        Game game = gameController.startGame(size,players,winningStartegies);

        gameController.display(game);



    }
}
