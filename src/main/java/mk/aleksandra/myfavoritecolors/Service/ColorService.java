package mk.aleksandra.myfavoritecolors.Service;

import mk.aleksandra.myfavoritecolors.Exceptions.ColorAlreadyExists;
import mk.aleksandra.myfavoritecolors.Exceptions.ColorNotFound;
import mk.aleksandra.myfavoritecolors.Model.Color;

import java.util.List;

public interface ColorService {

    Color AddColor(Color color) throws ColorAlreadyExists;

    List<Color> GetColors();

    void DeleteColorById(Long id) throws ColorNotFound;
}
