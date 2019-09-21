package demo.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

import demo.service.UserService;
//@Component
@Controller//专用，可以代替Component
public class UserController {
	@Autowired
	@Qualifier("userServiceNormal")
	private UserService userService;
	
	public void add() {
		userService.add();
	}
}
