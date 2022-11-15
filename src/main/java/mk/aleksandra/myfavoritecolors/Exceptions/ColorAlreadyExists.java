package mk.aleksandra.myfavoritecolors.Exceptions;

public class ColorAlreadyExists extends Exception{
    public ColorAlreadyExists(String message){
        super(String.format("%s",message));
    }
}
