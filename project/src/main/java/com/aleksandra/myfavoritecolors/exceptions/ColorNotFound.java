package com.aleksandra.myfavoritecolors.exceptions;

public class ColorNotFound extends Exception{
    public ColorNotFound(String message){
        super(String.format("%s",message));
    }
}
