package setup;

import Exceptions.TypeNOTPRESENT;
import Modals.Player;
import Modals.Symbol;
import Modals.enums.BotDifficulty;
import Modals.enums.PlayerType;
import factory.BotFactory;
import factory.HumanFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GameSetup {

    public static List<Player>  collectPlayer()
    {
     Scanner sc = new Scanner(System.in);
     List<Player> players = new ArrayList<>();
     List<Symbol> usedSymbols = new ArrayList<>();

     int nextId =1;

     System.out.println("How amny players ?");
     int numPlayers = sc.nextInt();
     sc.nextLine();

     for(int i =0;i<numPlayers;i++)
     {
         System.out.println("-- Player " +(i+1)+" --");
         System.out.print("Type (HUMAN,BOT) ");
         String typeinput = sc.nextLine();
         typeinput = typeinput.trim().toUpperCase();
         PlayerType playerType = PlayerType.valueOf(typeinput);

         System.out.print("Name: ");
         String name = sc.nextLine();

         System.out.println("Symbol (e.g.X) :");
         String symbolValue = sc.nextLine();

         Symbol symbol = new Symbol(symbolValue,symbolValue);

         Player player;
         if(playerType.equals(PlayerType.HUMAN))
         {
             System.out.println("Age: ");
             int age = sc.nextInt();
             sc.nextLine();
              player = HumanFactory.createHuman(nextId,name,symbol,age);
         }
         else if(playerType.equals(PlayerType.BOT))
         {
             System.out.print("Bot difficulty (EASY/MEDIUM/HARD): ");
             String botDifficulty = sc.nextLine().trim().toUpperCase();
             BotDifficulty botDifficulty1 = BotDifficulty.valueOf(botDifficulty);
             player = BotFactory.createBot(nextId,name,symbol,botDifficulty1);
         }
         else throw new TypeNOTPRESENT("This Type of player doesn't exist ");

         players.add(player);
         usedSymbols.add(symbol);
         nextId++;

     }
     return players;
    }
}
