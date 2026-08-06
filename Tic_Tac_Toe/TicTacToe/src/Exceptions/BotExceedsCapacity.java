package Exceptions;

public class BotExceedsCapacity extends RuntimeException{

    public BotExceedsCapacity(String message) {
        super(message);
    }
}
