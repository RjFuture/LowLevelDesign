package Startegy;

import Modals.Move;
import Modals.Player;

import java.util.HashMap;

public class ColumnWinningStrategy implements WinningStartegy{
    private int size;
    private HashMap<String,Integer> colMaps[];

    public ColumnWinningStrategy(int size) {
        this.size = size;
        this.colMaps = new HashMap[size];

        for(int i=0;i<size;i++)
        {
            colMaps[i] = new HashMap<>();
        }
    }

    @Override
    public boolean checkWinner(Move move)
    {
        //current player
        Player curPlayer = move.getPlayer();

        // get current_col
        int curr_col = move.getCell().getCol();

        //get cur_idx
        HashMap<String,Integer> currColMap = colMaps[curr_col];
        String currSymbol = curPlayer.getSymbol().getName();

        currColMap.put(currSymbol,currColMap.getOrDefault(currSymbol,0)+1);

        return currColMap.get(currSymbol)==size;
    }

    @Override
    public void undoMove(Move move) {

        Player curplayer = move.getPlayer();
        int row = move.getCell().getRow();
        int col = move.getCell().getCol();

        HashMap<String, Integer> currColMaps = colMaps[col];

        String currSymbol = curplayer.getSymbol().getName();

        if (currColMaps.containsKey(currSymbol)) {
            currColMaps.put(currSymbol, currColMaps.get(currSymbol) - 1);

        }

    }
}
