package Modals;

import Modals.enums.CellState;
import Modals.enums.GameState;
import Startegy.WinningStartegy;

import java.util.ArrayList;
import java.util.List;

public class Game {

    private Board board;
    private List<Player> players;
    private List<Move> moves;
    private int nextTurn;
    private Player winner;
    private GameState gameState;
    private List<WinningStartegy> winnerStrategies;

    public Game(int size,List<Player> players,List<WinningStartegy> winnerStrategies)
    {
        this.board = new Board(size); // Strong has a Composition
        this.players = players; //Weak Composition
        this.winnerStrategies = winnerStrategies;
        gameState = GameState.INPROGRESS;
        this.nextTurn =0;
        this.moves = new ArrayList<>();
    }

    public void makeMove(Game game)
    {
        // player's turn
        Player player = players.get(this.getNextTurn());
        System.out.println("It's "+player.getName()+" turn");

        //fill the cell when make move
        Move move = player.makeMove(this);

        // next turn update
        this.setNextTurn((this.nextTurn+1) % players.size());

        moves.add(move);

        int row = move.getCell().getRow();
        int col = move.getCell().getCol();
        Cell currCell = board.getCells().get(row).get(col);
        currCell.setCellstate(CellState.FILLED);
        currCell.setPlayer(player);

        // checking if winner or not

        if(checkingWinner(move))
        {
            this.setWinner(player);
            this.setGameState(GameState.COMPLETED);

        }
        else if(moves.size()== this.getBoard().getSize() * this.getBoard().getSize())
        {
            this.setGameState(GameState.DRAW);
        }

    }

    private boolean checkingWinner(Move move)
    {
        for(WinningStartegy winnerStrategy : winnerStrategies )
        {
            if(winnerStrategy.checkWinner(move)) return true;
        }
        return false;
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
        return winnerStrategies;
    }

    public void setWinnerStartegy(List<WinningStartegy> winnerStartegy) {
        this.winnerStrategies = winnerStartegy;
    }
}
