package com.aleksandra.myfavoritecolors.web.controller;

import com.aleksandra.myfavoritecolors.exceptions.ColorAlreadyExists;
import com.aleksandra.myfavoritecolors.exceptions.ColorNotFound;
import com.aleksandra.myfavoritecolors.model.Color;
import com.aleksandra.myfavoritecolors.service.ColorService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/color")
public class ColorController {

    private final ColorService colorService;

    public ColorController(ColorService colorService) {
        this.colorService = colorService;
    }

    @GetMapping
    public List<Color> getColors()
    {
        List<Color> colors = this.colorService.GetColors();
        return colors;
    }

    @PostMapping("/add-color")
    public String addColor(@RequestBody Color color) throws ColorAlreadyExists {
        this.colorService.AddColor(color);
        return "/redirect:/";
    }

    @PostMapping("/{id}/delete")
    public String deleteColor(@PathVariable Long id) throws ColorNotFound {
        this.colorService.DeleteColorById(id);
        return "/redirect:/";
    }
}
