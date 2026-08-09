package Modals;

import Exceptions.BotExceedsCapacity;
import Exceptions.InvalidPlayerCountException;
import Exceptions.PlayerSymbolNotUnique;
import Modals.enums.CellState;
import Modals.enums.GameState;
import Modals.enums.PlayerType;
import Startegy.WinningStartegy;

import java.util.ArrayList;
import java.util.HashSet;
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

    public static Builder getBuilder()
    {
        return new Builder();
    }

    public void undo() {

        int latest_idx = moves.size()-1;
        if(latest_idx<0) return;
        Move latest_move = moves.get(latest_idx);

        // NEW: tell every winning strategy to reverse what this move did to its counters
        for (WinningStartegy strategy : winnerStrategies) {
            strategy.undoMove(latest_move);
        }

        Cell latest_cell = latest_move.getCell();
        latest_cell.setCellstate(CellState.EMPTY);
        latest_cell.setPlayer(null);
        moves.remove(latest_idx);
        if(moves.size()==0) //means that was first move now we did undo too
        {
            this.nextTurn =0;
            return;
        }

        this.nextTurn = (nextTurn-1<0)?players.size()-1:(nextTurn-1);

    }

    public static class Builder
    {
        int size;
        List<Player> players;
        List<WinningStartegy> winningStartegies;

        public int getSize()
        {
            return  size;
        }

        public List<Player> getPlayers() {
            return players;
        }

        public Builder setPlayers(List<Player> players) {
            this.players = players;
            return this;
        }

        public Builder setSize(int size) {
            this.size = size;
            return this;
        }

        public List<WinningStartegy> getWinningStartegies() {
            return winningStartegies;
        }

        public Builder setWinningStartegies(List<WinningStartegy> winningStartegies) {
            this.winningStartegies = winningStartegies;
            return this;
        }

        public Game build()
        {
            //validate players is less than or equal too size-1
            validatePlayerNumber();
          //maximum bot can be 1
            validateBotCount();
            // Symbol should be unique for each player
            validateAllplayer();

            return new Game(size,players,winningStartegies);
        }

        private void validatePlayerNumber()
        {
            if(this.players.size()>=this.size)
            {
                throw new InvalidPlayerCountException("Number of players should be less than "+this.size);
            }
        }

        private void validateBotCount()
        {
            int cnt =0;
            for(Player player: players)
            {
                if(player.getPlayerType().equals(PlayerType.BOT)) cnt++;
            }
            if(cnt>1)
            {
                throw  new BotExceedsCapacity("Bots can be used maximum of 1 ");
            }
        }

        private void validateAllplayer()
        {
            HashSet<Symbol> hashSet = new HashSet<>();
            for(Player player:players)
            {
                hashSet.add(player.getSymbol());
            }
            if(hashSet.size()!=players.size())
            {
                throw  new PlayerSymbolNotUnique("Players Symbols are not unique ,please use unique symbol for each player");
            }
        }


    }
}
