package Modals;

import Modals.enums.CellState;
import Modals.enums.PlayerType;

import java.util.Scanner;

public class Human extends Player{

    private int age;
    private Scanner sc = new Scanner(System.in);

    public Human(int id, String name,Symbol symbol, int age) {
        super(id,name, symbol, PlayerType.HUMAN);
        this.age = age;
    }

    @Override
    public Move makeMove(Game game)
    {
       System.out.println("tell your move "+this.getName()+" by telling which row and which column");


       int row = sc.nextInt();
       int col = sc.nextInt();
       while(!validateMove(row,col,game))
       {
           System.out.println("please try again");
           row = sc.nextInt();
           col = sc.nextInt();
       }

       return  new Move(this, new Cell(row,col));
    }

    private boolean validateMove(int row, int col,Game game) {
        int sizeOfBoard = game.getBoard().getSize();
        if(sizeOfBoard<=row || sizeOfBoard<=col || row<0 || col<0)
        {
            System.out.println("Out of bounds move ");
            return false;
        }

        if(game.getBoard().getCells().get(row).get(col).getCellstate().equals(CellState.FILLED))
        {
            System.out.println("Wrong move the cell is filled already");
            return false;
        }
        return true;
    }
}
