package com.example.Wool_Amore;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


import java.util.List;

@Controller
public class ArtController {

    private final WoolRepository woolRepository;

    public ArtController(WoolRepository woolRepository) {
        this.woolRepository = woolRepository;
    }

    @GetMapping("/artlist")
    public String showArtList(Model model) {
        List<Art> artList = woolRepository.getAll();
        model.addAttribute("artList", artList);
        return "artList"; // Nazwa szablonu Thymeleaf (artList.html)
    }
    @GetMapping("/editArt/{id}")
    public String editArt(@PathVariable Long id, Model model) {
        Art art = woolRepository.getById(id);
        model.addAttribute("art", art);
        return "editArt"; // Nazwa szablonu Thymeleaf (editArt.html)
    }

    @GetMapping("/delete/{id}")
    public String deleteArt(@PathVariable Long id) {
        woolRepository.deleteArt(id);
        return "redirect:/artlist";

    }

    @PostMapping("/updateArt")
    public String updateArt(@ModelAttribute Art art) {
        woolRepository.updateArt(art);
        return "redirect:/artlist"; // Przekierowanie po zaktualizowaniu danych
    }

    @GetMapping ("/newArt")

    public String newArt(Model model) {
        Art art = new Art();
        model.addAttribute("art", art);
        return "newArt"; // Przekierowanie po zaktualizowaniu danych
    }

    @PostMapping("/save")
    public String saveArt(@ModelAttribute Art art) {
        woolRepository.save(art);
        return "redirect:/artlist"; // Przekierowanie po zaktualizowaniu danych
    }

}