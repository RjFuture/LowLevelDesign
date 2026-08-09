package Startegy;

import Modals.Move;
import Modals.Player;

import java.util.HashMap;

public class RowWinningStartegy implements WinningStartegy{

    private int size;
    private HashMap<String, Integer> rowMaps[];

    public RowWinningStartegy(int size) {
        this.size = size;
        this.rowMaps = new HashMap[size];
        for(int i=0;i<size;i++)
        {
            rowMaps[i] = new HashMap<>();
        }
    }

    @Override
    public boolean checkWinner(Move move) { // 1 means winner and from move we can get the player by

        Player curPlayer = move.getPlayer();

        //get current row
        int curr_row = move.getCell().getRow();
        HashMap<String,Integer> currRowMap = rowMaps[curr_row];

        String currSymbol = curPlayer.getSymbol().getName();

        //        one way
//        currRowMap.put(currSymbol,currRowMap.getOrDefault(currSymbol,0)+1);

        if(!currRowMap.containsKey(currSymbol))
        {
            currRowMap.put(currSymbol,0);
        }

        currRowMap.put(currSymbol,currRowMap.get(currSymbol)+1);



        return currRowMap.get(currSymbol)== size ;


    }

    @Override
    public void undoMove(Move move) {

        Player curplayer = move.getPlayer();
        int row = move.getCell().getRow();
        int col = move.getCell().getCol();

        HashMap<String, Integer> currRowmaps = rowMaps[row];

        String currSymbol = curplayer.getSymbol().getName();

        if (currRowmaps.containsKey(currSymbol)) {
            currRowmaps.put(currSymbol, currRowmaps.get(currSymbol) - 1);

        }
    }
}
