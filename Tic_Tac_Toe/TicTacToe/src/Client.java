import Controllers.GameController;
import Modals.*;
import Modals.enums.BotDifficulty;
import Modals.enums.GameState;
import Startegy.ColumnWinningStrategy;
import Startegy.DiagonalWinnigStartegy;
import Startegy.RowWinningStartegy;
import Startegy.WinningStartegy;
import setup.GameSetup;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Client {

    public static void main(String args[]) {

        Scanner sc = new Scanner(System.in);
        System.out.println("what size of board you want ?");

        int size = sc.nextInt();
        sc.nextLine();
        List<Player> players = GameSetup.collectPlayer();
// shuufling the player too randomize their turn , anyone can have first turn
        Collections.shuffle(players);

//        players.add(new Human(1,"Rajnish",new Symbol("X","X"),25));
//        players.add(new Human(2,"Lokesh",new Symbol("O","O"),24));
//        players.add(new Human(3,"Bimla",new Symbol("B","B"),34));
//        players.add(new Bot(5,"Rob",new Symbol("O","O"), BotDifficulty.EASY));

        // for now this is woinning startegies after this depends on client what type needed
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

            //in ongoing game we can undo if we want to adding global undo
            System.out.println("Want to undo this or move ?");
            String input = sc.nextLine();
            if(input.equalsIgnoreCase("UNDO"))
            {
                gameController.undo(game);
                continue; // skip makeMove this iteration, re-loop and re-display
            }

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
