package app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * Created by joelprakash on 3/17/2017.
 */
@Controller
public class UserController {

    @Autowired
    UserRepository useR;
    //@PathVariable("handle") String handle


    @PostMapping("/user")
    public String createAMA(@ModelAttribute("user-creation") User user){
        //amamade.setListOfKeyWords(amamade.getKeyWords(tags));
        useR.save(user);
        return "user";
    }//@PathVariable("handle") String handle


    @GetMapping("/user")
    public String displayAMA(Model model) {
        model.addAttribute("user", new User());
        return "user";
    }
}
