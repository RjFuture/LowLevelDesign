package factory;

import Modals.Human;
import Modals.Player;
import Modals.Symbol;

public class HumanFactory {


    public static Player createHuman(int id, String name, Symbol symbol, int age)
    {

            return new Human(id,name,symbol,age);

    }
}
