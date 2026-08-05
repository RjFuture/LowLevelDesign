package Modals;

import Modals.enums.PlayerType;

public abstract class Player {

    private int id;
    private Symbol symbol;
    private PlayerType playerType;

    public Player(int id, Symbol symbol, PlayerType playerType) {
        this.id = id;
        this.symbol = symbol;
        this.playerType = playerType;
    }

    public Symbol getSymbol() {
        return symbol;
    }

    public PlayerType getPlayerType() {
        return playerType;
    }
}
