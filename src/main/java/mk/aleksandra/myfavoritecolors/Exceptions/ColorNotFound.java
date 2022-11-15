package mk.aleksandra.myfavoritecolors.Exceptions;

public class ColorNotFound extends Exception{
    public ColorNotFound(String message){
        super(String.format("%s",message));
    }
}
