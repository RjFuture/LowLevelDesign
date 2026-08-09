package Startegy;

import Modals.Board;
import Modals.Cell;
import Modals.Game;
import Modals.Move;
import Modals.enums.CellState;

public class EasyBotPlayingStrategy implements BotPlayingStrategy{

    @Override
    public Move makeMove(Board board)
    {
        // Easy playing startegy it will fill the empty cells

        for(int row =0;row<board.getSize();row++)
        {
            for(int col =0;col<board.getSize();col++)
            {
                if(board.getCells().get(row).get(col).getCellstate().equals(CellState.EMPTY))
                {
                    Cell actualcell =  board.getCells().get(row).get(col);
                    return new Move(null,actualcell);
                }
            }
        }
        return null;
    }
}
