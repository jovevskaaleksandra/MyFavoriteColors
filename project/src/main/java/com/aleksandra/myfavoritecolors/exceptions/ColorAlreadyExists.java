package com.aleksandra.myfavoritecolors.exceptions;

public class ColorAlreadyExists extends Exception{
    public ColorAlreadyExists(String message){
        super(String.format("%s",message));
    }
}
