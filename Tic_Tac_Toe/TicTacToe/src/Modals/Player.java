package Modals;

import Modals.enums.PlayerType;

public abstract class Player {

    private String name;
    private int id;
    private Symbol symbol;
    private PlayerType playerType;

    public Player(int id,String name, Symbol symbol, PlayerType playerType) {
        this.id = id;
        this.name = name;
        this.symbol = symbol;
        this.playerType = playerType;
    }

    public Symbol getSymbol() {
        return symbol;
    }

    public PlayerType getPlayerType() {
        return playerType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setSymbol(Symbol symbol) {
        this.symbol = symbol;
    }

    public void setPlayerType(PlayerType playerType) {
        this.playerType = playerType;
    }

    public abstract Move makeMove(Game game);
}
