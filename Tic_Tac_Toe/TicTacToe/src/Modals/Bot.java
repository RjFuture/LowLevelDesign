package Modals;

import Modals.enums.BotDifficulty;
import Modals.enums.PlayerType;
import Startegy.BotPlayingStrategy;
import factory.BotPlayingStartegyFactory;

public class Bot extends Player{
    private BotDifficulty botDifficulty;
    private BotPlayingStrategy botPlayingStrategy;

    public Bot(int id,String name, Symbol symbol, PlayerType playerType, BotDifficulty botDifficulty,BotPlayingStrategy botPlayingStrategy) {
        super(id, name,symbol, playerType);
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
}
