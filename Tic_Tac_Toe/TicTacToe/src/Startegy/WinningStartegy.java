package Startegy;

import Modals.Move;
import Modals.Player;

public interface WinningStartegy {

    boolean checkWinner(Move move);
    void undoMove(Move move);
}
