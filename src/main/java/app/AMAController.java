package app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class AMAController {

	@Autowired
	 AMARepository amaR;
	 
	 @Autowired
	 UserRepository use;
	//@PathVariable("handle") String handle

	@PostMapping("/ama")
	public String createAMA(@ModelAttribute("ama") AMA ama){
		//amamade.setListOfKeyWords(amamade.getKeyWords(tags));
		amaR.save(ama);
		return "user";
	}//@PathVariable("handle") String handle


	@GetMapping("/ama")
	public String displayAMA(Model model) {
		model.addAttribute("ama", new AMA());
		return "ama";
	}
	
}
