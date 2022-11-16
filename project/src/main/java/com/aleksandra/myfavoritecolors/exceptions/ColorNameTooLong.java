package com.aleksandra.myfavoritecolors.exceptions;

public class ColorNameTooLong extends Exception{
    public ColorNameTooLong(String message){
        super(String.format("%s",message));
    }
}
