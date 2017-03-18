package app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by joelprakash on 3/17/2017.
 */
@Controller
public class UserController {

    @Autowired
    private UserRepository useR;
    //@PathVariable("handle") String handle


    @PostMapping("/user-creation")
    public String createUser(@ModelAttribute("user") User user){
        //amamade.setListOfKeyWords(amamade.getKeyWords(tags));
        useR.save(user);
        return "user-creation";
    }//@PathVariable("handle") String handle


    @GetMapping("/user-creation")
    public String displayUser(Model model) {
        model.addAttribute("user", new User());
        return "user-creation";
    }

    @GetMapping("/userList")
    public String listOfUsers(Model model) {
        List<String> allUsers = new ArrayList<String>();
        Iterator it = useR.findAll().iterator();
        while(it.hasNext()) {
            allUsers.add(it.next().toString());
        }
        model.addAttribute("allUsers",allUsers);
        return "userList";
    }

//    @PostMapping("/users")
//    public String listOfUsers(Model model) {
//        String allUsers = "";
//        Iterator it = useR.findAll().iterator();
//        while(it.hasNext()) {
//            allUsers += it.next().toString()+"\n";
//        }
//        model.addAttribute("allUsers",allUsers);
//        return "users";
//    }
}