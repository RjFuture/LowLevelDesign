package Modals;

import Modals.enums.PlayerType;

public class Human extends Player{

private int age;

    public Human(int id, Symbol symbol, PlayerType playerType, int age) {
        super(id, symbol, playerType);
        this.age = age;
    }
}
