package wuhan_hospital.third;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ThirdController {

	@Autowired
	ThirdDB thirdDB;
	
	@Autowired
	ThirdDBRepository thirdDBRepository;
	
	@GetMapping(value = {"/third"})
	public String user(Model model) {
		model.addAttribute("third", new Third());
		model.addAttribute("thirds", thirdDBRepository.findAll());
		return "third";
		//return "<h1> This is User Page </h1>";
	}
	
	//public User create(@RequestBody User user) {
	@PostMapping("/third")
	public String create(Third third, Model model) throws Exception {
		System.out.println(third.getId());
		System.out.println(third.getTitle());
		System.out.println(third.getContent());
		
		
		thirdDB.insert_user(third);
		//userDB.insert_user(user);
		//userDBRepository.save(user);
		
		model.addAttribute("thirds", thirdDBRepository.findAll());
		
		return "third";
		//return "redirect:/user";
		//return "redirect:/"
	}
}
