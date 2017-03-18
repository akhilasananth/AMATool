package app;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


@Controller
public class AMAController {

	@Autowired
	AMARepository amaR;
	 
	@Autowired
	UserRepository use;
	//@PathVariable("handle") String handle

	@Autowired
	QuestionRepository questionR;

	@GetMapping("/ama")
	public String displayAMA(Model model) {
		model.addAttribute("ama", new AMA());
		return "ama";
	}

	@PostMapping("/ama")
	public String createAMA(@ModelAttribute("ama") AMA ama){
		//amamade.setListOfKeyWords(amamade.getKeyWords(tags));
		amaR.save(ama);
		return "user";
	}//@PathVariable("handle") String handle

	@GetMapping("/users/{userhandle}/amas")
	public String displayAMAsByUser(@PathVariable String userhandle, Model model){
		return "displayAMAsByUser";
	}

	@GetMapping("/users/{userhandle}/amas/{id}")
	public String displayAMA(@PathVariable String userhandle, @PathVariable String id, Model model){
		long amaid = Long.parseLong(id);
		AMA ama = amaR.findById(amaid);
		model.addAttribute("ama", ama.toString());
		model.addAttribute("question", new Question(amaid));
		model.addAttribute("userhandle", userhandle);
		model.addAttribute("id", id);
		return "displayAMA";
	}

	@PostMapping("/users/{userhandle}/amas/{id}")
	public String createQuestion(@PathVariable String userhandle, @ModelAttribute("question") Question question, Model model){
		questionR.save(question);
		return "reviewQuestion";
	}

	@GetMapping("/users/{userhandle}/amas/{id}/questions")
	public String displayAMAQuestions(@PathVariable String userhandle, @PathVariable String id, Model model){
		List<String> amaQuestions = new ArrayList<String>();
		long amaid = Long.parseLong(id);
		Iterator iterator = questionR.findAllByParent(amaid).iterator();
		while(iterator.hasNext()){
			amaQuestions.add(iterator.next().toString());
		}
		model.addAttribute("amaQuestions", amaQuestions);
		return "displayQuestions";
	}
/*
	@GetMapping("/users/amas")
	public String displayAMAsByUser(){

		return "displayAMAsByUser";
	}*/
	
}
