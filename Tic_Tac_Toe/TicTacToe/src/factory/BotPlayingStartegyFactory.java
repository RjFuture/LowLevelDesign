package factory;

import Modals.enums.BotDifficulty;
import Startegy.BotPlayingStrategy;
import Startegy.EasyBotPlayingStrategy;
import Startegy.HardBotPlayingStrategy;
import Startegy.MediumBotPlayingStrategy;

public class BotPlayingStartegyFactory {

    public static BotPlayingStrategy getPlayingStrategy(BotDifficulty botDifficulty)
    {
         if(botDifficulty.equals(BotDifficulty.HARD))
         {
             return new HardBotPlayingStrategy();
         }
         else if(botDifficulty.equals(BotDifficulty.MEDIUM))
        {
            return new MediumBotPlayingStrategy();
        }
        return  new EasyBotPlayingStrategy();
    }
}
