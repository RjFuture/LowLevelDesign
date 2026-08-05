package Modals;

import Modals.enums.PlayerType;

public class Human extends Player{

private int age;

    public Human(int id, String name,Symbol symbol, PlayerType playerType, int age) {
        super(id,name, symbol, playerType);
        this.age = age;
    }
}
