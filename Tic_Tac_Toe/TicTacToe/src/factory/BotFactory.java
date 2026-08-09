package factory;

import Modals.Bot;
import Modals.Player;
import Modals.Symbol;
import Modals.enums.BotDifficulty;

public class BotFactory {

    public static Player createBot(int id, String name, Symbol symbol, BotDifficulty botDifficulty)
    {
    return new Bot(id,name,symbol,botDifficulty);
    }
}
