package com.aleksandra.myfavoritecolors.service.impl;

import com.aleksandra.myfavoritecolors.exceptions.ColorAlreadyExists;
import com.aleksandra.myfavoritecolors.exceptions.ColorFormatWrong;
import com.aleksandra.myfavoritecolors.exceptions.ColorNameTooLong;
import com.aleksandra.myfavoritecolors.exceptions.ColorNotFound;
import com.aleksandra.myfavoritecolors.model.Color;
import com.aleksandra.myfavoritecolors.repository.ColorRepository;
import com.aleksandra.myfavoritecolors.service.ColorService;
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
    public Color AddColor(Color color) throws ColorAlreadyExists, ColorFormatWrong, ColorNameTooLong {
        if(color.getName()==null || color.getCode()==null)
        {
            throw new ColorFormatWrong("Please enter correct color format");
        }
        Optional<Color> existingColorByName = this.colorRepository.findColorByName(color.getName());
        Optional<Color> existingColorByCode = this.colorRepository.findColorByCode(color.getCode());
        if(existingColorByName.isPresent() || existingColorByCode.isPresent())
        {
            throw new ColorAlreadyExists("Color already exists");
        }

        if(color.getName().length()>100)
        {
            throw new ColorNameTooLong("Color name too long");
        }
        return colorRepository.save(color);
    }

    @Override
    public List<Color> GetColors() {
        return colorRepository.findAll();
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
