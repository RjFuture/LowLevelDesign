import Controllers.GameController;
import Modals.Game;
import Modals.Player;
import Modals.enums.GameState;
import Startegy.WinningStartegy;

import java.util.ArrayList;
import java.util.List;

public class Client {

    public static void main(String args[]) {

        int size = 4;
        List<Player> players = new ArrayList<>();
        List<WinningStartegy> winningStartegies = new ArrayList<>();

        GameController gameController = new GameController();

        Game game = gameController.startGame(size,players,winningStartegies);

        gameController.display(game);

        // start game

        while(!gameController.getGameState(game).equals(GameState.INPROGRESS))
        {
            //input from players
            // make moves
            //check winner
            // if winner comes then update Gamestate = completed
        }

        if(gameController.getGameState(game).equals(GameState.DRAW))
        {
            System.out.println("Game is Draw");
        }
        else
        {
            System.out.println("player:"+game.getWinner().getName()+ " has win the game");
        }



    }
}
