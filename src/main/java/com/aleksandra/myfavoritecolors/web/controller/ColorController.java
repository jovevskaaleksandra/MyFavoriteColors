package com.aleksandra.myfavoritecolors.web.controller;

import com.aleksandra.myfavoritecolors.exceptions.ColorAlreadyExists;
import com.aleksandra.myfavoritecolors.exceptions.ColorFormatWrong;
import com.aleksandra.myfavoritecolors.exceptions.ColorNameTooLong;
import com.aleksandra.myfavoritecolors.exceptions.ColorNotFound;
import com.aleksandra.myfavoritecolors.model.Color;
import com.aleksandra.myfavoritecolors.service.ColorService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/")
public class ColorController {

    private final ColorService colorService;

    public ColorController(ColorService colorService) {
        this.colorService = colorService;
    }

    @ModelAttribute("color")
    public Color color(){
        return new Color();
    }

    @GetMapping
    public String getColors(Model model)
    {
        List<Color> colors = this.colorService.GetColors();
        model.addAttribute("colors", colors);
        return "index";
    }

    @PostMapping("/add-color")
    public String addColor(@ModelAttribute("course") @RequestBody Color color, Model model) throws ColorAlreadyExists, ColorFormatWrong, ColorNameTooLong {
        this.colorService.AddColor(color);
        model.addAttribute("color","");
        return "redirect:/";
    }

    @PostMapping("/{id}/delete")
    public String deleteColor(@PathVariable Long id) throws ColorNotFound {
        this.colorService.DeleteColorById(id);
        return "redirect:/";
    }
}
