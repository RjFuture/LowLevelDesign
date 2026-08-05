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

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public List<Move> getMoves() {
        return moves;
    }

    public void setMoves(List<Move> moves) {
        this.moves = moves;
    }

    public int getNextTurn() {
        return nextTurn;
    }

    public void setNextTurn(int nextTurn) {
        this.nextTurn = nextTurn;
    }

    public Player getWinner() {
        return winner;
    }

    public void setWinner(Player winner) {
        this.winner = winner;
    }

    public GameState getGameState() {
        return gameState;
    }

    public void setGameState(GameState gameState) {
        this.gameState = gameState;
    }

    public List<WinningStartegy> getWinnerStartegy() {
        return winnerStartegy;
    }

    public void setWinnerStartegy(List<WinningStartegy> winnerStartegy) {
        this.winnerStartegy = winnerStartegy;
    }
}
