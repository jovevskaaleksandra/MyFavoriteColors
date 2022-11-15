package mk.aleksandra.myfavoritecolors.Service.impl;

import mk.aleksandra.myfavoritecolors.Exceptions.ColorAlreadyExists;
import mk.aleksandra.myfavoritecolors.Exceptions.ColorNotFound;
import mk.aleksandra.myfavoritecolors.Model.Color;
import mk.aleksandra.myfavoritecolors.Repository.ColorRepository;
import mk.aleksandra.myfavoritecolors.Service.ColorService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ColorServiceImpl implements ColorService {

    private final ColorRepository colorRepository;

    public ColorServiceImpl(ColorRepository colorRepository) {
        this.colorRepository = colorRepository;
    }

    @Override
    public Color AddColor(Color color) throws ColorAlreadyExists {
        Optional<Color> existingColor = colorRepository.findByName(color.getName());
        if(existingColor.isPresent())
        {
            throw new ColorAlreadyExists("Color already exists");
        }
        return colorRepository.save(color);
    }

    @Override
    public List<Color> GetColors() {
        return this.colorRepository.findAll();
    }

    @Override
    public void DeleteColorById(Long id) throws ColorNotFound {
        Optional<Color> color = colorRepository.findById(id);
        if(color.isEmpty())
        {
            throw new ColorNotFound("Color not found");
        }
        colorRepository.delete(color.get());
    }
}
