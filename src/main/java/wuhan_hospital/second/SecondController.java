package wuhan_hospital.second;

import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.beans.factory.annotation.Autowired;

@Controller
public class SecondController {
	
	@Autowired
	SecondDB secondDB;
	
	@Autowired
	SecondDBRepository secondDBRepository;
	
	@GetMapping(value= {"/second"})
	public String first (Model model) {
		model.addAttribute("second", new Second());
		model.addAttribute("seconds", secondDBRepository.findAll());
		return "second";
	}
	
	@PostMapping("/second")
	public String create(Second second, Model model) throws Exception {
		System.out.println(second.getId());
		System.out.println(second.getTitle());
		System.out.println(second.getContent());
		
		secondDB.insert_info(second);
		
		//model.addAttribute("seconds", secondDBRepository.findAll());
		
		return "second";
	}
	

	
}
