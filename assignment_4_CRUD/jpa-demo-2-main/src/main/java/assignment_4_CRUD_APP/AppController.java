package assignment_4_CRUD_APP;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AppController {


    @GetMapping({"/", ""})
    public String deleteCharacter() {

        return "redirect:/characters/all";
    }
}
