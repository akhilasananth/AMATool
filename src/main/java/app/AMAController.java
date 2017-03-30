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
	UserRepository useR;
	//@PathVariable("handle") String handle
	private User user = new User();
	long parentId;
	String handle;

	@Autowired
	QuestionRepository questionR;

	@GetMapping("/user/{userhandle}/ama-creation")
	public String displayAMA(@PathVariable String userhandle, Model model) {
		this.handle = userhandle;
		user=useR.findByHandle(handle);
		model.addAttribute("ama", new AMA());
		model.addAttribute("user",user);
		return "ama";
	}

	@PostMapping("/user/{userhandle}/ama-creation")
	public String createAMA(@ModelAttribute("ama") AMA ama, @PathVariable String userhandle,Model model){
		user=useR.findByHandle(handle);
		model.addAttribute("user",user);
		amaR.save(ama);
		user.addAMAToUserList(ama);
		return "ama";
	}//@PathVariable("handle") String handle




	@GetMapping("/users/{userhandle}/amas")
	public String displayAMAsByUser(@PathVariable String userhandle, Model model, HttpServletRequest request, HttpServletResponse response){
		List<AMA> amasList = new ArrayList<AMA>();
		for(AMA ama:user.getListOfAMAsCreated()){
			amasList.add(ama);
		}
        user =useR.findByHandle(handle);
		model.addAttribute("ama", new AMA());
        model.addAttribute("user",user);
		model.addAttribute("amasList",amasList);
		return "displayAMAsByUser";
	}


	@GetMapping("/users/{userhandle}/amas/{id}")
	public String displayAMA(@PathVariable String userhandle, @PathVariable String id, Model model){

			long amaid = Long.parseLong(id);

		parentId = amaid;

		AMA ama = amaR.findById(amaid);

		//model.addAttribute("ama", ama.toString());
		model.addAttribute("ama", ama);
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
