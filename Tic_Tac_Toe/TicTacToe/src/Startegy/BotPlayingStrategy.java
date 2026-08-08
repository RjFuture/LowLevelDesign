package Startegy;


import Modals.Board;
import Modals.Game;
import Modals.Move;

public interface BotPlayingStrategy {

    public Move makeMove(Board board);

}
