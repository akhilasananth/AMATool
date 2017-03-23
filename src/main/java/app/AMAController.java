package app;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;


@Controller
public class AMAController {

	@Autowired
	AMARepository amaR;
	 
	@Autowired
	UserRepository use;
	//@PathVariable("handle") String handle

	long parentId;

	@Autowired
	QuestionRepository questionR;

	@GetMapping("/ama")
	public String displayAMA(Model model) {
		model.addAttribute("ama", new AMA());
		return "ama";
	}

	@PostMapping("/ama")
	public String createAMA(@ModelAttribute("ama") AMA ama, BindingResult result){
		//amamade.setListOfKeyWords(amamade.getKeyWords(tags));
		if (result.hasErrors()) {
			return "ama";
		}
		amaR.save(ama);
		return "user";
	}//@PathVariable("handle") String handle

	@GetMapping("/users/{userhandle}/amas")
	public String displayAMAsByUser(@PathVariable String userhandle, Model model, HttpServletRequest request, HttpServletResponse response){
		List<AMA> amasList = new ArrayList<AMA>();
		String handle=userhandle;
		User u=use.findByHandle(handle);
		for(AMA ama:u.getListOfAMAsCreated()){
			amasList.add(ama);
		}
		model.addAttribute("amasList",amasList);
		return "displayAMAsByUser";
	}


	@GetMapping("/users/{userhandle}/amas/{id}")
	public String displayAMA(@PathVariable String userhandle, @PathVariable String id, Model model){

			long amaid = Long.parseLong(id);

		parentId = amaid;

		AMA ama = amaR.findById(amaid);

		//model.addAttribute("ama", ama.toString());
		model.addAttribute("ama", ama.toString());
		model.addAttribute("question", new Question(amaid));
		model.addAttribute("userhandle", userhandle);
		model.addAttribute("id", id);
		return "displayAMA";

	}

	@PostMapping("/users/{userhandle}/amas/{id}")
	public String createQuestion(@PathVariable String userhandle, @PathVariable String id, @ModelAttribute("question") Question question, Model model){
		if ((Calendar.getInstance().getTime()).after(amaR.findById(parentId).getDeadlineToVote())){
			return "deadAMA";
		}
		else{
		question.setParent(parentId);
			questionR.save(question);
			return "reviewQuestion";

	}}

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
