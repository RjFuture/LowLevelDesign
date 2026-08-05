package Modals;

import Modals.enums.GameState;
import Startegy.WinningStartegy;

import java.util.List;

public class Game {

    private Board board;
    private List<Player> players;
    private List<Move> moves;
    private int nextTurn;
    private Player winner;
    private GameState gameState;
    private List<WinningStartegy> winnerStartegy;

    public Game(int size,List<Player> players,List<WinningStartegy> winnerStartegy)
    {
        this.board = new Board(size); // Strong has a Composition
        this.players = players; //Weak Composition
        this.winnerStartegy = winnerStartegy;
        gameState = GameState.INPROGRESS;
    }

}
