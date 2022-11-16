package com.aleksandra.myfavoritecolors.exceptions;

public class ColorFormatWrong extends Exception{
    public ColorFormatWrong(String message){
        super(String.format("%s",message));
    }
}
