package assignment_4_CRUD_APP.Character;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 *
 * @author sunny
 */
@RequestMapping("/characters")
@Controller
public class CharacterController {

    @Autowired
    private CharacterService service;

    @GetMapping("/all")
    public String getCharacter(Model model) {
        model.addAttribute("characterList", service.getAllCharacter());
        return "characters/list-characters";
    }
    


    @GetMapping("/id={characterId}")
    public String getCharacter(@PathVariable long characterId, Model model) {
        model.addAttribute("character", service.getCharacterById(characterId));
        return "characters/character-detail";
    }

    @GetMapping("/delete/id={characterId}")
    public String deleteCharacter(@PathVariable long characterId, Model model) {
        service.deleteCharacterById(characterId);
        return "redirect:/characters/all";
    }


    @PostMapping("/create")
    public String createCharacter(Character character) {
        service.saveCharacter(character);
        return "redirect:/characters/all";
    }

    /*
    @PostMapping("/update/id={characterId}")
    public String updateCharacter(@PathVariable long characterId, Character character) {
        service.saveCharacter(character);
        return "redirect:/characters/all";
    }
     */

    @PostMapping("/update")
    public String updateCharacter(@ModelAttribute("character") Character character) {
        service.saveCharacter(character);
        return "redirect:/characters/all";
    }

    @GetMapping("/update-status/id={characterId}&status={status}")
    public String updateCharacterStatus(@PathVariable long characterId,
            @PathVariable String status) {
        Character existing = service.getCharacterById(characterId);
        service.saveCharacter(existing);
        return "redirect:/characters/all";
    }

    @GetMapping("/create")
    public String newCharacterForm(Model model) {
        Character character = new Character();
        model.addAttribute("character", character);
        model.addAttribute("isUpdate", false);
        return "characters/create-character";
    }

    @GetMapping("/update/id={characterId}")
    public String updateCharacterForm(@PathVariable long characterId, Model model) {
        model.addAttribute("character", service.getCharacterById(characterId));
        model.addAttribute("isUpdate", true);
        model.addAttribute("characterList", service.getAllCharacter());
        return "characters/update-character";
    }
    /*
    @InitBinder
    public void dateBinder(WebDataBinder binder) {
        // 2023-04-19 02:14:25
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat,
                false));
    }

     */
}