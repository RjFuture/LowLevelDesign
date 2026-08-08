package Modals;

import Modals.enums.BotDifficulty;
import Modals.enums.PlayerType;
import Startegy.BotPlayingStrategy;
import factory.BotPlayingStartegyFactory;

public class Bot extends Player{
    private BotDifficulty botDifficulty;
    private BotPlayingStrategy botPlayingStrategy;

    public Bot(int id,String name, Symbol symbol, BotDifficulty botDifficulty) {
        super(id, name,symbol, PlayerType.BOT);
        this.botDifficulty = botDifficulty;
        this.botPlayingStrategy = BotPlayingStartegyFactory.getPlayingStrategy(botDifficulty);

    }

    public BotDifficulty getBotDifficulty() {
        return botDifficulty;
    }

    public void setBotDifficulty(BotDifficulty botDifficulty) {
        this.botDifficulty = botDifficulty;
    }

    public BotPlayingStrategy getBotPlayingStrategy() {
        return botPlayingStrategy;
    }

    public void setBotPlayingStrategy(BotPlayingStrategy botPlayingStrategy) {
        this.botPlayingStrategy = botPlayingStrategy;
    }

    @Override
    public Move makeMove(Game game)
    {
        System.out.println("It's "+this.getName()+" bot turn");
       Move move =  botPlayingStrategy.makeMove(game.getBoard());
       move.setPlayer(this);
       return move;
    }
}
