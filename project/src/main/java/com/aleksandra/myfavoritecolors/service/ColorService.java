package com.aleksandra.myfavoritecolors.service;

import com.aleksandra.myfavoritecolors.exceptions.ColorAlreadyExists;
import com.aleksandra.myfavoritecolors.exceptions.ColorNotFound;
import com.aleksandra.myfavoritecolors.model.Color;

import java.util.List;

public interface ColorService {

    Color AddColor(Color color) throws ColorAlreadyExists;

    List<Color> GetColors();

    void DeleteColorById(Long id) throws ColorNotFound;
}
