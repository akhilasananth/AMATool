package app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

public class AMAController {
	 @Autowired
	 AMARepository ama;
	 
	 @Autowired
	 UserRepository use;
	 
	@PostMapping("/user/AMA/AMA-Creation")
	public String createAMA(@RequestParam(value="name") String name,@RequestParam(value="handle") String handle,
			@RequestParam(value="deadline to vote") String date,
			@RequestParam(value="description") String description, @RequestParam(value="Key words") String tags, Model m){
		User user=new User(name, handle);
		use.save(user);
		AMA amamade=new AMA(description);
		amamade.setListOfKeyWords(amamade.getKeyWords(tags));
		amamade.setCreator(user);
		amamade.setDeadlineToVote(amamade.convertStringToDate(date));
		ama.save(amamade);
		m.addAttribute("ama");
		return "ama/display/ID";
	}
	@GetMapping("/user/AMA/ID")
	public String displayAMA(@RequestParam(value="ID") long ID, Model m){
		AMA wantedama=ama.findOne(ID);
		m.addAttribute("wantedAMA");
		return "ama/display/ID";
	}
	
}
