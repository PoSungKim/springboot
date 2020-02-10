package wuhan_hospital.user;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {
	
	@Autowired
	UserDB userDB;
	
	@Autowired
	UserDBRepository userDBRepository;
	
	@Autowired
	HttpSession session;
	
	@GetMapping(value = {"/join"})
	public String joinPage() {
		return "join";
	}
	
	@GetMapping(value = {"/login"})
	public String loginPage() {
		return "login";
	}
	
	@PostMapping(value = "/joinRequest")
	public String joinRequest(User user) throws Exception {
		System.out.println(user.getId());
		System.out.println(user.getUser_id());
		System.out.println(user.getUser_pw());
		
		User check_user = userDBRepository.findByUserIdANDUserPw(user.getUser_id(), user.getUser_pw());
		if (check_user != null) {
			session.setAttribute("loginUser", check_user);
			return "redirect:/";
		}
		userDB.join_user(user);
		session.setAttribute("loginUser", check_user);
		return "redirect:/";
	}
	
	@PostMapping(value = "/loginRequest")
	public String loginRequest(User user) throws Exception {
		System.out.println(user.getId());
		System.out.println(user.getUser_id());
		System.out.println(user.getUser_pw());
		
		User check_user = userDBRepository.findByUserIdANDUserPw(user.getUser_id(), user.getUser_pw());
		if (check_user == null) {
			return "redirect:/login";
		}
		session.setAttribute("loginUser", check_user);
		
		return "redirect:/";
	}
	
	@GetMapping(value = {"/logout"})
	public String logoutRequest() {
		
		session.invalidate();
		return "redirect:/";
	}
	
}
