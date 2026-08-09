package Startegy;

import Modals.Board;
import Modals.Cell;
import Modals.Move;
import Modals.enums.CellState;

import java.util.Random;

public class MediumBotPlayingStrategy implements BotPlayingStrategy{

    @Override
    public Move makeMove(Board board){
        int size = board.getSize();
        Random random = new Random();
        int row;
        int col;
        do{

            row = random.nextInt(size); //range [0 size]
            col = random.nextInt(size);

        }while(board.getCells().get(row).get(col).getCellstate().equals(CellState.FILLED));

        Cell actualCell = board.getCells().get(row).get(col);
        Move move =  new Move(null,actualCell);
        return move;
    }
}
