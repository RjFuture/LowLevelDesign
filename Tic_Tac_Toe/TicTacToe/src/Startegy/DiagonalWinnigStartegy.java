package Startegy;

import Modals.Move;
import Modals.Player;

import java.util.HashMap;

public class DiagonalWinnigStartegy implements WinningStartegy{

    private int size;
    private HashMap<String,Integer> diaMaps[];

    public DiagonalWinnigStartegy(int size) {
        this.size = size;
        this.diaMaps = new HashMap[2]; // like only 2 diagonal and reverse diagonal
    }

    //2 types of diagonal
    //1st one is when row==col that is normal diagonal
    //2nd one is row+col = size that is reverse diagonal
    // assume as 0 index for main diagonal
    //assume 1 for reverse diagonal

    @Override
    public boolean checkWinner(Move move) {
        //curplayer
        Player currplayer = move.getPlayer();

        // currRow

        int currRow = move.getCell().getRow();

        // currCol
        int currCol = move.getCell().getCol();

        //symbol
        String currSymbol = currplayer.getSymbol().getName();

        boolean flag1 = false;
        boolean flag2 = false;

        if(currRow==currCol)
        {
            HashMap<String,Integer> currMap1 = diaMaps[0];

            currMap1.put(currSymbol,currMap1.getOrDefault(currSymbol,0)+1);

             flag1 =  (currMap1.get(currSymbol) == size);
        }
        if (currRow+currCol==(size-1))
        {
            HashMap<String,Integer> currMap2 = diaMaps[1];
            currMap2.put(currSymbol,currMap2.getOrDefault(currSymbol,0)+1);

             flag2 =  (currMap2.get(currSymbol) == size);
        }

        return (flag1 || flag2);

    }
}
