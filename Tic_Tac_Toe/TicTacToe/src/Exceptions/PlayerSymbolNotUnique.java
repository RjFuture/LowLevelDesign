package Exceptions;

public class PlayerSymbolNotUnique extends RuntimeException{

    public PlayerSymbolNotUnique(String message) {
        super(message);
    }
}
