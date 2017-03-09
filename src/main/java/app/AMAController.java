package app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

public class AMAController {
	 @Autowired
	 AMARepository ama;
	 
	 @Autowired
	 UserRepository use;
	 
	@PostMapping("{handle}/AMA/AMA-Creation")
	public @ResponseBody String createAMA(@PathVariable("handle") String handle, @RequestParam(value="name") String name,
			@RequestParam(value="deadline to vote") String date,
			@RequestParam(value="description") String description, @RequestParam(value="Key words") String tags, Model m){
		AMA amamade=new AMA(description);
		amamade.setListOfKeyWords(amamade.getKeyWords(tags));
		amamade.setDeadlineToVote(amamade.convertStringToDate(date));
		ama.save(amamade);
		m.addAttribute("ama");
		return "ama/display/ID";
	}
	@GetMapping("{handle}/user/AMA/{ID}")
	public @ResponseBody String displayAMA(@PathVariable("handle") String handle, @PathVariable("ID") Long ID, Model m){
		AMA wantedama=ama.findOne(ID);
		m.addAttribute("wantedAMA");
		return "ama/display/ID";
	}
	
}
