package wuhan_hospital.first;

import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class FirstController {

@Autowired
FirstDB firstDB;

@Autowired
FirstDBRepository firstDBRepository;
	
	@GetMapping(value = {"/", "/first"})
	public String firstPage(Model model) {
		model.addAttribute("first", new First());
		model.addAttribute("firsts", firstDBRepository.findAll());
		return "first";
	}
	
	@GetMapping(value = {"/board"})
	public String boardPage(Model model) {
		//model.addAttribute("first", new First());
		model.addAttribute("firsts", firstDBRepository.findAll());
		return "board";
	}
	
	@PostMapping("/first")
	public String create(First first, Model model) throws Exception {
		System.out.println(first.getId());
		System.out.println(first.getTitle());
		System.out.println(first.getContent());
		
		firstDB.insert_info(first);
		
		model.addAttribute("firsts", firstDBRepository.findAll());
		
		return "first";
	}
}

