import Controllers.GameController;
import Modals.*;
import Modals.enums.BotDifficulty;
import Modals.enums.GameState;
import Startegy.ColumnWinningStrategy;
import Startegy.DiagonalWinnigStartegy;
import Startegy.RowWinningStartegy;
import Startegy.WinningStartegy;

import java.util.ArrayList;
import java.util.List;

public class Client {

    public static void main(String args[]) {

        int size = 3;
        List<Player> players = new ArrayList<>();
        players.add(new Human(1,"Rajnish",new Symbol("X","X"),25));
//        players.add(new Human(2,"Lokesh",new Symbol("O","O"),24));
//        players.add(new Human(3,"Bimla",new Symbol("B","B"),34));
        players.add(new Bot(5,"Rob",new Symbol("O","O"), BotDifficulty.EASY));

        List<WinningStartegy> winningStartegies = new ArrayList<>();
        winningStartegies.add(new RowWinningStartegy(size));
        winningStartegies.add(new ColumnWinningStrategy(size));
        winningStartegies.add(new DiagonalWinnigStartegy(size));

        GameController gameController = new GameController();

        Game game = gameController.startGame(size,players,winningStartegies);

//        gameController.display(game);

        // start game

        while(gameController.getGameState(game).equals(GameState.INPROGRESS))
        {
            //input from players
            gameController.display(game);
            // make moves
            gameController.makeMove(game);
            //check winner
            // if winner comes then update Gamestate = completed
        }

        gameController.display(game);

        if(gameController.getGameState(game).equals(GameState.DRAW))
        {
            System.out.println("Game is Draw");
        }
        else
        {
            System.out.println("player: "+game.getWinner().getName() +" has win the game");
        }



    }
}
