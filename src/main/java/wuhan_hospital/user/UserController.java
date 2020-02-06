package wuhan_hospital.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RestController;

//@RestController
@Controller
public class UserController {
	
	@Autowired
	UserDB userDB;
	
	@Autowired
	UserDBRepository userDBRepository;
	
	
	//@GetMapping("/user")
	@GetMapping(value = {"/", "/user"})
	public String user(Model model) {
		model.addAttribute("user", new User());
		model.addAttribute("users", userDBRepository.findAll());
		return "user";
		//return "<h1> This is User Page </h1>";
	}
	
	//public User create(@RequestBody User user) {
	@PostMapping("/user")
	public String create(User user, Model model) throws Exception {
		System.out.println(user.getId());
		System.out.println(user.getUsername());
		System.out.println(user.getPassword());
		
		
		userDB.insert_user(user);
		//userDB.insert_user(user);
		//userDBRepository.save(user);
		
		model.addAttribute("users", userDBRepository.findAll());
		
		return "user";
		//return "redirect:/user";
		//return "redirect:/"
	}
	
	
}
