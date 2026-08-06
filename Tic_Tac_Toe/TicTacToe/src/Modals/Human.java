package Modals;

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

       return  new Move(this, new Cell(row,col));
    }
}
